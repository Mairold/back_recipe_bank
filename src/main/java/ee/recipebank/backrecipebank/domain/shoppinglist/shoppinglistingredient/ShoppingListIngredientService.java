package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingListIngredientService {

    @Resource
    private ShoppingListIngredientRepository shoppingListIngredientRepository;

    public List<ShoppingListIngredient> getShoppingIngredientListBy(Integer shoppingListId) {
        List<ShoppingListIngredient> allBy = shoppingListIngredientRepository.findAllWhereIngredientGroupIsNotNullBy(shoppingListId);
        List<ShoppingListIngredient> allCustomBy = shoppingListIngredientRepository.findAllWhereIngredientGroupIsNullBy(shoppingListId);
        allBy.addAll(allCustomBy);
        return allBy;
    }

    public void saveShoppingListIngredients(List<ShoppingListIngredient> shoppingListIngredients) {
        shoppingListIngredientRepository.saveAll(shoppingListIngredients);
    }

    public void saveCustomItem(ShoppingListIngredient shoppingListIngredient) {
        shoppingListIngredientRepository.save(shoppingListIngredient);
    }

    public void deleteItemBy(Integer ingredientId) {
        shoppingListIngredientRepository.deleteById(ingredientId);
    }

    public ShoppingListIngredient getShoppingIngredientBy(Integer shoppingListItemId) {
        Validation.validateShoppingListIngredient(shoppingListIngredientRepository.findById(shoppingListItemId));
        return shoppingListIngredientRepository.findById(shoppingListItemId).get();
    }
}
