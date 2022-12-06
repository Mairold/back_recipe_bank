package ee.recipebank.backrecipebank.domain.ingridient.recipeIngredient;

import ee.recipebank.backrecipebank.domain.ingridient.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeIngredientService {


    @Resource
    private IngredientRepository ingredientRepository;

    @Resource
    private RecipeIngredientRepository recipeIngredientRepository;





}
