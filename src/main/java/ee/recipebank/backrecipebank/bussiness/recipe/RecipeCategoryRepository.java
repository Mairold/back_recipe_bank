package ee.recipebank.backrecipebank.bussiness.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCategoryRepository extends JpaRepository<RecipeCategory, Integer> {
}