package ee.recipebank.backrecipebank.domain.recipe;

import ee.recipebank.backrecipebank.business.recipe.RecipeRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeServiceInDomain {

    @Resource
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {return recipeRepository.findAll();
    }

    public List<Recipe> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        return recipeRepository.findFilteredRecipesBy(prepId, catId, name);
    }



    public Recipe findThisRecipeId(RecipeRequest request) {
        return recipeRepository.findById(request.getRecipeId()).get();


    }

}
