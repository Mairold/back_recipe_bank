package ee.recipebank.backrecipebank.business.shoppinglist;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientDto;
import ee.recipebank.backrecipebank.domain.ingridient.IngredientServiceDomain;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupService;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnitService;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredientService;
import ee.recipebank.backrecipebank.domain.menu.Menu;
import ee.recipebank.backrecipebank.domain.menu.MenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.TempEntity;
import ee.recipebank.backrecipebank.domain.shoppinglist.ShoppingListServiceDomain;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredient;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredientMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingListService {

    @Resource
    private ShoppingListServiceDomain shoppingListServiceDomain;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;
    @Resource
    private ShoppingListIngredientMapper shoppingListIngredientMapper;
    @Resource
    private MenuServiceDomain menuServiceDomain;
    @Resource
    private IngredientServiceDomain ingredientServiceDomain;
    @Resource
    private IngredientGroupService ingredientGroupService;
    @Resource
    private MeasurementUnitService measurementUnitService;



    public List<ShoppingListIngredientDto> getAllShoppingListIngredients(Integer shoppingListId) {
        return shoppingListIngredientMapper.toDtos(shoppingListServiceDomain.getShoppingIngredientListBy(shoppingListId));
    }

    public Integer saveNewShoppingList(Integer menuId) {
        ShoppingList shoppingList = getShoppingList(menuServiceDomain.getValidMenuBy(menuId));
        Integer shoppingListId = shoppingListServiceDomain.saveNewShoppingList(shoppingList);
        generateShoppingListIngredients(menuId,shoppingList);
        return shoppingListId;
    }

    private void generateShoppingListIngredients(Integer menuId, ShoppingList shoppingList) {
        List<TempEntity> allMenuRecipeIngredientsBy = recipeInSectionServiceDomain.getAllMenuRecipeIngredientsBy(menuId);

        List<ShoppingListIngredient> shoppingListIngredients = new ArrayList<>();
        for (TempEntity tempEntity : allMenuRecipeIngredientsBy) {
            ShoppingListIngredient shoppingListIngredient = new ShoppingListIngredient();
            shoppingListIngredient.setIngredient(ingredientServiceDomain.getIngredientBy(tempEntity.getIngredientId()));
            shoppingListIngredient.setIngredientGroup(ingredientGroupService.getIngredientGroupBy(tempEntity.getIngredientGroupId()));
            shoppingListIngredient.setMeasurementUnit(measurementUnitService.getMeasurementUnitBy(tempEntity.getMeasurementUnitId()));
            shoppingListIngredient.setShoppingList(shoppingList);
            shoppingListIngredient.setStatus("A");
            shoppingListIngredient.setDateTimeAdded(Instant.now());
            shoppingListIngredient.setQuantity(tempEntity.getFinalQuantity());
            shoppingListIngredient.setIsCustom(false);
            shoppingListIngredients.add(shoppingListIngredient);
        }
        shoppingListServiceDomain.saveShoppingListIngredients(shoppingListIngredients);
    }


    private ShoppingList getShoppingList(Menu validMenuBy) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setMenu(validMenuBy);
        shoppingList.setDateTimeAdded(Instant.now());
        return shoppingList;
    }
}
