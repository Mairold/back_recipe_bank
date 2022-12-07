package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientRequest;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnitService;
import ee.recipebank.backrecipebank.business.ingredient.dto.RecipeIngredientDto;
import ee.recipebank.backrecipebank.domain.recipe.RecipeServiceDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceDomain {
    @Resource
    private IngredientRepository ingredientRepository;

    @Resource
    private IngredientMapper ingredientMapper;

    @Resource
    private RecipeServiceDomain recipeServiceDomain;

    @Resource
    private AllowedMeasurementUnitService allowedMeasurementUnitService;

    public Optional<Ingredient> getOptionalIngredient(IngredientRequest ingredientRequest) {
        return ingredientRepository.findByName(ingredientRequest.getIngredientName());
    }

    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }


    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientBy(Integer ingredientId) {
        return ingredientRepository.findById(ingredientId).get();
    }





    public RecipeIngredientDto addRecipeIngredientToRecipe(RecipeIngredientDto recipeIngredient) {
        recipeServiceDomain.getRecipeById(recipeIngredient.getRecipeId());


        RecipeIngredientDto response = new RecipeIngredientDto();

//        Ingredient ingredient = ingredientMapper.ingredientRequestToRecipeIngredient(recipeIngredient);
        return null;
    }

    public List<AllowedMeasurementUnit> getAllowedMeasurementUnits(Integer ingredientId) {
        List<AllowedMeasurementUnit> allowedMeasurementUnitByIngredientId = allowedMeasurementUnitService.findByIngredientId(ingredientId);
        return allowedMeasurementUnitByIngredientId;

    }
}