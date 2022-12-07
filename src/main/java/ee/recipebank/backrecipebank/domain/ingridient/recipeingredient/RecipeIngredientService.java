package ee.recipebank.backrecipebank.domain.ingridient.recipeingredient;

import ee.recipebank.backrecipebank.business.ingredient.dto.RecipeIngredientRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeIngredientService {

    @Resource
    private RecipeIngredientRepository recipeIngredientRepository;

    public List<RecipeIngredient> findRecipeIngredientsBy(Integer recipeId) {
        return recipeIngredientRepository.findRecipeIngredientsBy(recipeId);
    }

    public void saveRecipeIngredient(RecipeIngredient recipeIngredient) {
        recipeIngredientRepository.save(recipeIngredient);
    }
}
