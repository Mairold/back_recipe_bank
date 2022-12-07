package ee.recipebank.backrecipebank.domain.shoppinglist;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingListRepository;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredient;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListServiceDomain {

    @Resource
    private ShoppingListIngredientRepository shoppingListIngredientRepository;
    @Resource
    private ShoppingListRepository shoppingListRepository;
    public List<ShoppingListIngredient> getShoppingIngredientListBy(Integer shoppingListId, Boolean isCustom) {
        return shoppingListIngredientRepository.findShoppingListIngredientBy(shoppingListId, isCustom);

    }

    public Integer saveNewShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList).getId();
    }

    public void saveShoppingListIngredients(List<ShoppingListIngredient> shoppingListIngredients) {
        shoppingListIngredientRepository.saveAll(shoppingListIngredients);
    }

    public void saveCustomItem(ShoppingListIngredient shoppingListIngredient) {
        shoppingListIngredientRepository.save(shoppingListIngredient);
    }

    public ShoppingList getShoppingListBy(Integer shoppingListId) {
        Validation.validateShoppingList(shoppingListRepository.findById(shoppingListId));
        return shoppingListRepository.findById(shoppingListId).get();
    }

    public void updateShoppingList(ShoppingList shoppingList) {
        shoppingListRepository.save(shoppingList);
    }

    public List<ShoppingList> getAllShoppingLists(Integer menuId) {
        List<ShoppingList> allByMenuId = shoppingListRepository.findAllByMenuId(menuId);
        return allByMenuId;
    }
}
