package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
}