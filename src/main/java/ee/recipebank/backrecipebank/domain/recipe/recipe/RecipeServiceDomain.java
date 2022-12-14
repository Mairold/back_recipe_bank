package ee.recipebank.backrecipebank.domain.recipe.recipe;

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
        if (recipeRepository.findById(recipeId).isPresent()) {
            return recipeRepository.findById(recipeId).get();
        } else {
            throw new NullPointerException("Recipe with id: " + recipeId + " does not exist");
        }
    }

    public void saveRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public void addInstructionsToRecipe(Recipe recipe) {
        recipeRepository.save(recipe);

    }
}
