package ee.recipebank.backrecipebank.domain.recipe.recipeInSection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeInSectionRepository extends JpaRepository<RecipeInSection, Integer> {

    @Query("select r from RecipeInSection r where r.sectionInMenu.menu.id = ?1")
    List<RecipeInSection> findBy(Integer menuId);

    @Query(value = "SELECT i.id, ig.id, mu.id, (ri.quantity / r.serving_size * ris.planned_serving_size) as finalquantity\n" +
            "FROM recipe_in_section ris\n" +
            "JOIN recipe r ON ris.recipe_id = r.id\n" +
            "JOIN recipe_ingredient ri ON r.id = ri.recipe_id\n" +
            "JOIN ingredient i ON i.id = ri.ingredient_id\n" +
            "JOIN ingredient_group ig ON ig.id = i.ingredient_group_id\n" +
            "JOIN measurement_unit mu ON mu.id = ri.measure_unit_id\n" +
            "JOIN section_in_menu sim ON sim.id = ris.section_in_menu_id\n" +
            "JOIN menu m ON m.id = sim.menu_id\n" +
            "WHERE sim.menu_id = ?1\n" +
            "ORDER BY ig.name", nativeQuery = true)
    List<TempEntity> findAllNeededInfoBy(Integer menuId);

}
