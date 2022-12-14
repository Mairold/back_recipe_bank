package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingListServiceDomain {

    @Resource
    private ShoppingListRepository shoppingListRepository;

    public Integer saveNewShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList).getId();
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
}
