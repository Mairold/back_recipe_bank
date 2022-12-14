package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {

    @Query("select s from ShoppingList s where s.menu.user.id = ?1 order by s.dateTimeAdded desc")
    List<ShoppingList> findAllByUserId(Integer id);
}