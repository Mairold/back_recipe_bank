package ee.recipebank.backrecipebank.domain.recipe.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query(value = """
            SELECT * 
            FROM recipe
            WHERE(( CASE WHEN ?1 = 0 THEN preparation_time_id ELSE 1 END ) > 0 AND
                  ( CASE WHEN ?1 <> 0 THEN ?1 ELSE preparation_time_id END ) = preparation_time_id) AND
                 (( CASE WHEN ?2 = 0 THEN recipe_category_id ELSE 1 END ) > 0 AND
                  ( CASE WHEN ?2 <> 0 THEN ?2 ELSE recipe_category_id END ) = recipe_category_id)
            AND UPPER(name) LIKE UPPER(CONCAT('%', ?3, '%'))
            """, nativeQuery = true)
    List<Recipe> findFilteredRecipesBy(Integer prepId, Integer catId, String name);
}