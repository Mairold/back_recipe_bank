package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingListIngredientRepository extends JpaRepository<ShoppingListIngredient, Integer> {

    @Query("select s from ShoppingListIngredient s where s.shoppingList.id = ?1 order by s.ingredientGroup.name")
    List<ShoppingListIngredient> findAllBy(Integer id);

    @Query("""
            select s from ShoppingListIngredient s
            where s.shoppingList.id = ?1 and s.isCustom = ?2
            order by s.ingredientGroup.name""")
    List<ShoppingListIngredient> findShoppingListIngredientBy(Integer id, Boolean isCustom);




}