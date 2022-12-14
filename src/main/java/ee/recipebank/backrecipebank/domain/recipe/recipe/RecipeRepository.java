package ee.recipebank.backrecipebank.domain.recipe.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query( // Toob andmebaasist välja teksti, kategooria ja preptime'i järgi filtreeritud retseptid
            value = "SELECT *\n" +
                    "FROM recipe\n" +
                    "WHERE(\n" +
                    "        ( CASE\n" +
                    "              WHEN ?1 = 0 THEN preparation_time_id\n" +
                    "              ELSE 1\n" +
                    "            END\n" +
                    "            ) > 0\n" +
                    "  AND\n" +
                    "        ( CASE\n" +
                    "              WHEN ?1 <> 0 THEN ?1\n" +
                    "              ELSE preparation_time_id\n" +
                    "            END\n" +
                    "            ) = preparation_time_id)\n" +
                    "\n" +
                    "  AND\n" +
                    "\n" +
                    "(\n" +
                    "        ( CASE\n" +
                    "              WHEN ?2 = 0 THEN recipe_category_id\n" +
                    "              ELSE 1\n" +
                    "            END\n" +
                    "            ) > 0\n" +
                    "  AND\n" +
                    "        ( CASE\n" +
                    "              WHEN ?2 <> 0 THEN ?2\n" +
                    "              ELSE recipe_category_id\n" +
                    "            END\n" +
                    "            ) = recipe_category_id)\n" +
                    "AND upper(name) like upper(concat('%', ?3, '%'))",

            nativeQuery = true)
    List<Recipe> findFilteredRecipesBy(Integer prepId, Integer catId, String name);

    // kui siia queryt lisada soovin Recipe kohta, siis seal ei ole. Kas oleks vaja teha uue nimega Recipe


}