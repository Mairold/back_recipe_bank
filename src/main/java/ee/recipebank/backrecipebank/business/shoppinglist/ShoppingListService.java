package ee.recipebank.backrecipebank.business.shoppinglist;

import ee.recipebank.backrecipebank.business.ingredient.dto.ShoppingListDto;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.CustomShoppingListItem;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientDto;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupService;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnitService;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredient;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredientService;
import ee.recipebank.backrecipebank.domain.menu.Menu;
import ee.recipebank.backrecipebank.domain.menu.MenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionServiceDomain;
import ee.recipebank.backrecipebank.domain.shoppinglist.ShoppingListServiceDomain;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingListMapper;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredient;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredientMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListService {

    @Resource
    private ShoppingListServiceDomain shoppingListServiceDomain;
    @Resource
    private MeasurementUnitService measurementUnitService;
    @Resource
    private IngredientGroupService ingredientGroupService;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;
    @Resource
    private ShoppingListIngredientMapper shoppingListIngredientMapper;
    @Resource
    private ShoppingListMapper shoppingListMapper;
    @Resource
    private MenuServiceDomain menuServiceDomain;
    @Resource
    private RecipeIngredientService recipeIngredientService;


    public List<ShoppingListIngredientDto> getAllShoppingListIngredients(Integer shoppingListId) {
        List<ShoppingListIngredient> shoppingIngredients = shoppingListServiceDomain.getShoppingIngredientListBy(shoppingListId, false);
        List<ShoppingListIngredient> customShoppingIngredients = shoppingListServiceDomain.getShoppingIngredientListBy(shoppingListId, true);

        List<ShoppingListIngredientDto> shoppingListIngredientDtos = shoppingListIngredientMapper.toDtos(shoppingIngredients);
        List<ShoppingListIngredientDto> customShoppingListIngredientDtos = shoppingListIngredientMapper.toDtos(customShoppingIngredients);

        List<ShoppingListIngredientDto> compoundQuantities = compoundQuantities(shoppingListIngredientDtos);

        return joinTwoDtoLists(compoundQuantities,customShoppingListIngredientDtos);
    }

    private List<ShoppingListIngredientDto> joinTwoDtoLists(List<ShoppingListIngredientDto> compoundQuantities, List<ShoppingListIngredientDto> customShoppingListIngredientDtos) {
        compoundQuantities.addAll(customShoppingListIngredientDtos);
        return compoundQuantities;
    }

    public Integer generateNewShoppingList(Integer menuId) {
        ShoppingList shoppingList = generateShoppingList(menuServiceDomain.getValidMenuBy(menuId));
        Integer shoppingListId = shoppingListServiceDomain.saveNewShoppingList(shoppingList);
        List<ShoppingListIngredient> shoppingListIngredients = getShoppingListIngredients(menuId, shoppingList);
        shoppingListServiceDomain.saveShoppingListIngredients(shoppingListIngredients);
        return shoppingListId;
    }

    private List<ShoppingListIngredientDto> compoundQuantities(List<ShoppingListIngredientDto> listIngredients) {
        List<ShoppingListIngredientDto> finalList = new ArrayList<>();
        List<ShoppingListIngredientDto> duplicates = new ArrayList<>();
        for (ShoppingListIngredientDto listIngredient : listIngredients) {
            int counter = 0;
            for (ShoppingListIngredientDto ingredient : listIngredients) {
                if (listIngredient.getShoppingListIngredientName().equals(ingredient.getShoppingListIngredientName()) &&
                        listIngredient.getMeasurementName().equals(ingredient.getMeasurementName())) {

                    if (checkIfPresentInFinalList(finalList, listIngredient.getShoppingListIngredientName(), listIngredient.getMeasurementName()))
                    {
                        counter++;
                        if (counter == 1) {
                            duplicates.add(listIngredient);
                        }
                    } else {
                        finalList.add(listIngredient);
                    }
                }
            }
        }
        //        Remove double occurrences in two Lists
        for (ShoppingListIngredientDto finalItem : finalList) {
            duplicates.removeIf(duplicate -> finalItem.getShoppingListIngredientId().equals(duplicate.getShoppingListIngredientId()));
        }

        //        Add quantities to finalList
        for (ShoppingListIngredientDto duplicate : duplicates) {
            for (ShoppingListIngredientDto shoppingListIngredient : finalList) {
                if (shoppingListIngredient.getShoppingListIngredientName().equals(duplicate.getShoppingListIngredientName()) &
                        shoppingListIngredient.getMeasurementName().equals(duplicate.getMeasurementName())) {
                    shoppingListIngredient.addToQuantity(duplicate.getQuantity());
                }
            }
        }

        return finalList;
    }


    private boolean checkIfPresentInFinalList(List<ShoppingListIngredientDto> finalList,String value ,String name) {
        return finalList.stream().anyMatch(ingredient -> value.equals(ingredient.getShoppingListIngredientName()) && name.equals(ingredient.getMeasurementName()));
    }


    private List<ShoppingListIngredient> getShoppingListIngredients(Integer menuId, ShoppingList shoppingList) {
        List<ShoppingListIngredient> shoppingListIngredients = new ArrayList<>();
        List<RecipeInSection> recipeInSections = recipeInSectionServiceDomain.findRecipeInSectionBy(menuId);

        for (RecipeInSection recipeInSection : recipeInSections) {
            List<RecipeIngredient> recipeIngredients = recipeIngredientService.findRecipeIngredientsBy(recipeInSection.getRecipe().getId());
            for (RecipeIngredient recipeIngredient : recipeIngredients) {
                ShoppingListIngredient shoppingListIngredient = getShoppingListIngredient(shoppingList, recipeInSection, recipeIngredient);
                shoppingListIngredients.add(shoppingListIngredient);
            }
        }
        return shoppingListIngredients;
    }

    private ShoppingListIngredient getShoppingListIngredient(ShoppingList shoppingList, RecipeInSection recipeInSection, RecipeIngredient recipeIngredient) {
        ShoppingListIngredient shoppingListIngredient = new ShoppingListIngredient();
        shoppingListIngredient.setMeasurementUnit(recipeIngredient.getMeasureUnit());
        shoppingListIngredient.setShoppingList(shoppingList);
        shoppingListIngredient.setIngredient(recipeIngredient.getIngredient());
        shoppingListIngredient.setIngredientGroup(recipeIngredient.getIngredient().getIngredientGroup());
        BigDecimal shoppingListQuantity = getAllShoppingListIngredientQuantity(recipeIngredient.getQuantity(),
                recipeInSection.getRecipe().getServingSize(), recipeInSection.getPlannedServingSize());
        shoppingListIngredient.setQuantity(shoppingListQuantity);
        shoppingListIngredient.setStatus("A");
        shoppingListIngredient.setDateTimeAdded(Instant.now());
        shoppingListIngredient.setIsCustom(false);
        return shoppingListIngredient;
    }

    private BigDecimal getAllShoppingListIngredientQuantity(BigDecimal quantity, Integer servingSize, Integer plannedServingSize) {
        MathContext precision = new MathContext(6);
        return quantity.divide(BigDecimal.valueOf(servingSize), 10, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(plannedServingSize)).round(precision);

    }

    private ShoppingList generateShoppingList(Menu validMenuBy) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setMenu(validMenuBy);
        shoppingList.setDateTimeAdded(Instant.now());
        return shoppingList;
    }

    public void saveCustomShoppingListItem(CustomShoppingListItem customItem) {
        ShoppingListIngredient shoppingListIngredient = shoppingListIngredientMapper.toEntity(customItem);
        shoppingListServiceDomain.saveCustomItem(getShoppingListItemProperties(customItem, shoppingListIngredient));

    }

    private ShoppingListIngredient getShoppingListItemProperties(CustomShoppingListItem customItem, ShoppingListIngredient shoppingListItem) {
        shoppingListItem.setShoppingList(shoppingListServiceDomain.getShoppingListBy(customItem.getShoppingListId()));
        shoppingListItem.setIngredientGroup(ingredientGroupService.getIngredientGroupBy(customItem.getIngredientGroupId()));
        shoppingListItem.setMeasurementUnit(measurementUnitService.getMeasurementUnitBy(customItem.getMeasurementId()));
        shoppingListItem.setStatus("A");
        shoppingListItem.setDateTimeAdded(Instant.now());
        return shoppingListItem;
    }

    public void updateShoppingList(Integer shoppingListId, String shoppingListComment) {
        ShoppingListDto shoppingListDto = new ShoppingListDto();
        shoppingListDto.setShoppingListComment(shoppingListComment);
        ShoppingList shoppingList = shoppingListServiceDomain.getShoppingListBy(shoppingListId);
        shoppingListMapper.updateEntity(shoppingListDto,shoppingList);
        shoppingListServiceDomain.updateShoppingList(shoppingList);
    }

    public ShoppingListDto getShoppingList(Integer shoppingListId) {
        ShoppingList shoppingList = shoppingListServiceDomain.getShoppingListBy(shoppingListId);
        return shoppingListMapper.toDto(shoppingList);
    }
}


