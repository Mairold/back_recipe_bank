package ee.recipebank.backrecipebank.domain.shoppinglist;

import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingListRepository;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredient;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingListServiceDomain {

    @Resource
    private ShoppingListIngredientRepository shoppingListIngredientRepository;
    @Resource
    private ShoppingListRepository shoppingListRepository;
    public List<ShoppingListIngredient> getShoppingIngredientListBy(Integer shoppingListId) {
        return shoppingListIngredientRepository.findAllBy(shoppingListId);

    }

    public Integer saveNewShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList).getId();
    }

    public void saveShoppingListIngredients(List<ShoppingListIngredient> shoppingListIngredients) {
        shoppingListIngredientRepository.saveAll(shoppingListIngredients);
    }
}
