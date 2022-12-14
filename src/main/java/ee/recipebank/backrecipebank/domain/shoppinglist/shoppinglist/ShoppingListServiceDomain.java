package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import ee.recipebank.backrecipebank.Validation.Validation;
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

    public List<ShoppingListIngredient> getShoppingIngredientListBy(Integer shoppingListId) {
        List<ShoppingListIngredient> allBy = shoppingListIngredientRepository.findAllWhereIngredientGroupIsNotNullBy(shoppingListId);
        List<ShoppingListIngredient> allCustomBy = shoppingListIngredientRepository.findAllWhereIngredientGroupIsNullBy(shoppingListId);
        allBy.addAll(allCustomBy);
        return allBy;

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

    public List<ShoppingList> getAllShoppingListsBy(Integer userId) {
        return shoppingListRepository.findAllByUserId(userId);
    }

    public void deleteItemBy(Integer ingredientId) {
        shoppingListIngredientRepository.deleteById(ingredientId);
    }

    public ShoppingListIngredient getShoppingIngredientBy(Integer shoppingListItemId) {
        Validation.validateShoppingListIngredient(shoppingListIngredientRepository.findById(shoppingListItemId));
        return shoppingListIngredientRepository.findById(shoppingListItemId).get();
    }
}
