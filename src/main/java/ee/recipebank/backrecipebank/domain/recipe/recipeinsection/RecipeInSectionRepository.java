package ee.recipebank.backrecipebank.domain.recipe.recipeinsection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.annotation.Resource;
import java.util.List;

public interface RecipeInSectionRepository extends JpaRepository<RecipeInSection, Integer> {

    @Query("select r from RecipeInSection r where r.sectionInMenu.menu.id = ?1")
    List<RecipeInSection> findBy(Integer menuId);

    @Query("select r from RecipeInSection r where r.sectionInMenu.menu.id = ?1")
    List<RecipeInSection> findRecipeInSectionBy(Integer menuId);

}
