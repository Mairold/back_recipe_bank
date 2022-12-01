package ee.recipebank.backrecipebank.domain.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeInSectionRepository extends JpaRepository<RecipeInSection, Integer> {

    @Query("select r from RecipeInSection r where r.sectionInMenu.menu.id = ?1")
    List<RecipeInSection> findBy(Integer menuId);

}