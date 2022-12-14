package ee.recipebank.backrecipebank.business.shoppinglist;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.*;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupService;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnitService;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredient;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredientService;
import ee.recipebank.backrecipebank.domain.menu.menu.Menu;
import ee.recipebank.backrecipebank.domain.menu.menu.MenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionServiceDomain;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingListMapper;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingListServiceDomain;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredient;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredientMapper;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredientService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingListService {

    @Resource
    private ShoppingListServiceDomain shoppingListServiceDomain;
    @Resource
    private ShoppingListIngredientService shoppingListIngredientService;
    @Resource
    private MeasurementUnitService measurementUnitService;
    @Resource
    private IngredientGroupService ingredientGroupService;
    @Resource
    private MenuServiceDomain menuServiceDomain;
    @Resource
    private RecipeIngredientService recipeIngredientService;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;
    @Resource
    private ShoppingListIngredientMapper shoppingListIngredientMapper;
    @Resource
    private ShoppingListMapper shoppingListMapper;

    public List<ShoppingListIngredientDto> getAllShoppingListIngredients(Integer shoppingListId) {
        return shoppingListIngredientMapper.toDtos(shoppingListIngredientService.getShoppingIngredientListBy(shoppingListId));
    }

    public Integer generateNewShoppingList(Integer menuId) {
        ShoppingList shoppingList = generateShoppingList(menuServiceDomain.getValidMenuBy(menuId));
        Integer shoppingListId = shoppingListServiceDomain.saveNewShoppingList(shoppingList);
        List<ShoppingListIngredient> shoppingListIngredients = getShoppingListIngredients(menuId, shoppingList);
        shoppingListIngredientService.saveShoppingListIngredients(removeDuplicatesAndSumQuantity(shoppingListIngredients));
        return shoppingListId;
    }

    public void saveCustomShoppingListItem(CustomShoppingListItem customItem) {
        ShoppingListIngredient shoppingListIngredient = shoppingListIngredientMapper.toEntity(customItem);
        shoppingListIngredientService.saveCustomItem(getShoppingListItemProperties(customItem, shoppingListIngredient));
    }

    public void updateShoppingList(Integer shoppingListId, String shoppingListComment) {
        shoppingListServiceDomain.updateShoppingList(getUpdatedShoppingList(shoppingListId, shoppingListComment));
    }

    public ShoppingListDto getShoppingList(Integer shoppingListId) {
        return shoppingListMapper.toDto(shoppingListServiceDomain.getShoppingListBy(shoppingListId));
    }

    public List<MainViewInfoRequest> getALlShoppingListsAndMenusBy(Integer userId) {
        List<ShoppingList> allShoppingListsBy = shoppingListServiceDomain.getAllShoppingListsBy(userId);
        List<MainViewInfoRequest> mainViewInfoRequests = shoppingListMapper.toMainViewInfoRequests(allShoppingListsBy);
//        for (ShoppingList shoppingList : allShoppingListsBy) {
//            for (MainViewInfoRequest mainViewInfoRequest : mainViewInfoRequests) {
//                if (shoppingList.getId().equals(mainViewInfoRequest.getShoppingListId())) {
//                    mainViewInfoRequest.setShoppingListDate(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(shoppingList.getDateTimeAdded()));
//                    mainViewInfoRequest.setMenuDate(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss").format(shoppingList.getMenu().getDateTimeAdded()));
//                }
//            }
//        }
        return mainViewInfoRequests;
    }

    public void deleteShoppingListItem(Integer ingredientId) {
        shoppingListIngredientService.deleteItemBy(ingredientId);
    }

    public ShoppingListIngredientChange getShoppingListItem(Integer shoppingListItemId) {
        return shoppingListIngredientMapper.toChangeDto(shoppingListIngredientService.getShoppingIngredientBy(shoppingListItemId));
    }

    public void updateShoppingItem(ShoppingListIngredientChange request) {
        ShoppingListIngredient ingredient = shoppingListIngredientService.getShoppingIngredientBy(request.getShoppingListIngredientId());
        shoppingListIngredientMapper.changeRequestToEntity(request, ingredient);
        shoppingListIngredientService.saveCustomItem(setIngredient(request, ingredient));
    }

    private ShoppingList generateShoppingList(Menu validMenuBy) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setMenu(validMenuBy);
        shoppingList.setDateTimeAdded(Date.from(Instant.now()));
        return shoppingList;
    }

    private List<ShoppingListIngredient> removeDuplicatesAndSumQuantity(List<ShoppingListIngredient> shoppingListIngredients) {
        for (int i = 0; i < shoppingListIngredients.size(); i++) {
            ShoppingListIngredient original = shoppingListIngredients.get(i);
            for (int j = i + 1; j < shoppingListIngredients.size(); j++) {
                ShoppingListIngredient compare = shoppingListIngredients.get(j);
                if (original.getIngredient().getId().equals(compare.getIngredient().getId()) &&
                        original.getMeasurementUnit().getId().equals(compare.getMeasurementUnit().getId())) {
                    original.addToQuantity(compare.getQuantity());
                    shoppingListIngredients.remove(compare);
                }
            }
        }
        return shoppingListIngredients;
    }

    private List<ShoppingListIngredient> getShoppingListIngredients(Integer menuId, ShoppingList shoppingList) {
        List<ShoppingListIngredient> shoppingListIngredients = new ArrayList<>();
        List<RecipeInSection> recipeInSections = recipeInSectionServiceDomain.findRecipeInSectionBy(menuId);
        for (RecipeInSection recipeInSection : recipeInSections) {
            List<RecipeIngredient> recipeIngredients = recipeIngredientService.findRecipeIngredientsBy(recipeInSection.getRecipe().getId());
            for (RecipeIngredient recipeIngredient : recipeIngredients) {
                shoppingListIngredients.add(getShoppingListIngredient(shoppingList, recipeInSection, recipeIngredient));
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
        shoppingListIngredient.setDateTimeAdded(Date.from(Instant.now()));
        shoppingListIngredient.setIsCustom(false);
        return shoppingListIngredient;
    }

    private BigDecimal getAllShoppingListIngredientQuantity(BigDecimal quantity, Integer servingSize, Integer plannedServingSize) {
        MathContext precision = new MathContext(6);
        return quantity.divide(BigDecimal.valueOf(servingSize), 10, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(plannedServingSize)).round(precision);

    }

    private ShoppingListIngredient getShoppingListItemProperties(CustomShoppingListItem customItem, ShoppingListIngredient shoppingListItem) {
        shoppingListItem.setShoppingList(shoppingListServiceDomain.getShoppingListBy(customItem.getShoppingListId()));
        shoppingListItem.setIngredientGroup(ingredientGroupService.getIngredientGroupBy(customItem.getIngredientGroupId()));
        shoppingListItem.setMeasurementUnit(measurementUnitService.getMeasurementUnitBy(customItem.getMeasurementId()));
        shoppingListItem.setStatus("A");
        shoppingListItem.setDateTimeAdded(Date.from(Instant.now()));
        return shoppingListItem;
    }

    private ShoppingList getUpdatedShoppingList(Integer shoppingListId, String shoppingListComment) {
        ShoppingListDto shoppingListDto = new ShoppingListDto();
        shoppingListDto.setShoppingListComment(shoppingListComment);
        ShoppingList shoppingList = shoppingListServiceDomain.getShoppingListBy(shoppingListId);
        shoppingListMapper.updateEntity(shoppingListDto, shoppingList);
        return shoppingList;
    }

    private ShoppingListIngredient setIngredient(ShoppingListIngredientChange request, ShoppingListIngredient ingredient) {
        ingredient.setIngredientGroup(ingredientGroupService.getIngredientGroupBy(request.getIngredientGroupId()));
        ingredient.setMeasurementUnit(measurementUnitService.getMeasurementUnitBy(request.getIngredientMeasurementId()));
        ingredient.setDateTimeModified(Date.from(Instant.now()));
        return ingredient;
    }
}



