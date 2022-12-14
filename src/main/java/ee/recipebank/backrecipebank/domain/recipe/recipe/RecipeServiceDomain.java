package ee.recipebank.backrecipebank.domain.recipe.recipe;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeServiceDomain {

    @Resource
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        return recipeRepository.findFilteredRecipesBy(prepId, catId, name);
    }

    public Recipe findRecipeById(Integer recipeId) {
        Validation.validateRecipe(recipeRepository.findById(recipeId));
        return recipeRepository.findById(recipeId).get();
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void saveInstructionsToRecipe(Recipe recipe) {
        recipeRepository.save(recipe);

    }
}
