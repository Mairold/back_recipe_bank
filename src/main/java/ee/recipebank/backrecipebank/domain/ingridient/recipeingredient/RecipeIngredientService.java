package ee.recipebank.backrecipebank.domain.ingridient.recipeingredient;

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
}
