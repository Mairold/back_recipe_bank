package ee.recipebank.backrecipebank.domain.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeServiceDomain {

    @Resource
    private RecipeRepository recipeRepository;

    public List<Recipe> getAllRecipes() {return recipeRepository.findAll();
    }

    public List<Recipe> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        return recipeRepository.findFilteredRecipesBy(prepId, catId, name);
    }

    public Recipe findThisRecipeId(RecipeInsertRequest request) {
        return recipeRepository.findById(request.getRecipeId()).get();
    }

    public Recipe findRecipeId(RecipeChangeDto request) {
        return recipeRepository.findById(request.getRecipeId()).get();
    }


}
