package ee.recipebank.backrecipebank.business.ingredient;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientGroupDto;
import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientInfo;
import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientRequest;
import ee.recipebank.backrecipebank.business.ingredient.dto.MeasurementDto;
import ee.recipebank.backrecipebank.domain.ingridient.Ingredient;
import ee.recipebank.backrecipebank.domain.ingridient.IngredientMapper;
import ee.recipebank.backrecipebank.domain.ingridient.IngredientServiceDomain;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnitService;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroup;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupMapper;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupService;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnit;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnitService;
import ee.recipebank.backrecipebank.domain.ingridient.recipeIngredient.RecipeIngredientDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    @Resource
    private IngredientMapper ingredientMapper;
    @Resource
    private IngredientGroupMapper ingredientGroupMapper;

    @Resource
    private MeasurementUnitService measurementUnitService;

    @Resource
    private IngredientServiceDomain ingredientServiceDomain;

    @Resource
    private IngredientGroupService ingredientGroupService;

    @Resource
    private AllowedMeasurementUnitService allowedMeasurementUnitService;

    public List<MeasurementDto> getAllMeasurements() {
        List<MeasurementUnit> allMeasurementUnits = measurementUnitService.getAllMeasurements();
        return ingredientMapper.toDtos(allMeasurementUnits);
    }

    public List<IngredientGroupDto> getAllGroups() {
        List<IngredientGroup> allGroups = ingredientGroupService.getAllGroups();

        return ingredientGroupMapper.toDtos(allGroups);
    }

    @Transactional
    public void addIngredient(IngredientRequest request) {
        checkForDatabaseExistence(request);
        Ingredient ingredient = getIngredient(request);
        ingredientServiceDomain.saveIngredient(ingredient);

        List<AllowedMeasurementUnit> allowedMeasurementUnits = getAllowedMeasurementUnits(request, ingredient);
        allowedMeasurementUnitService.saveAllMeasurementUnits(allowedMeasurementUnits);
    }

    private void checkForDatabaseExistence(IngredientRequest ingredientRequest) {
        Optional<Ingredient> optionalIngredient = ingredientServiceDomain.getOptionalIngredient(ingredientRequest);
        Validation.validateIngredient(optionalIngredient);
    }

    private Ingredient getIngredient(IngredientRequest ingredientRequest) {
        Ingredient ingredient = ingredientMapper.toEntity(ingredientRequest);
        IngredientGroup ingredientGroup = ingredientGroupService.getIngredientGroup(ingredientRequest);
        ingredient.setIngredientGroup(ingredientGroup);
        return ingredient;
    }

    private List<AllowedMeasurementUnit> getAllowedMeasurementUnits(IngredientRequest request, Ingredient ingredient) {
        List<AllowedMeasurementUnit> allowedMeasurementUnits = new ArrayList<>();

        for (MeasurementDto allowedMeasurement : request.getAllowedMeasurements()) {
            AllowedMeasurementUnit allowedMeasurementUnit = new AllowedMeasurementUnit();
            MeasurementUnit measurementUnit = measurementUnitService.getAllowedMeasurementUnit(allowedMeasurement);
            allowedMeasurementUnit.setMeasurementUnit(measurementUnit);
            allowedMeasurementUnit.setIngredient(ingredient);
            allowedMeasurementUnits.add(allowedMeasurementUnit);
        }
        return allowedMeasurementUnits;
    }

    public List<IngredientInfo> getAllIngredients() {
        List<Ingredient> ingredients = ingredientServiceDomain.getAllIngredients();
        return ingredientMapper.toAwesomeDtos(ingredients);
    }

    public RecipeIngredientDto addRecipeIngredientToRecipe(RecipeIngredientDto recipeIngredient) {
  return ingredientServiceDomain.addRecipeIngredientToRecipe(recipeIngredient);
    }

    public List<AllowedMeasurementUnit> getAllowedMeasurementUnits(Integer ingredientId) {
        List<AllowedMeasurementUnit> allowedMeasurementUnits = ingredientServiceDomain.getAllowedMeasurementUnits(ingredientId);
        return allowedMeasurementUnits;
    }
    //todo Quantity
    public void

//    public void addQuantity(RecipeIngredientDto recipeIngredientDto) {
//        RecipeIngredient quantity = getQuantity (recipeIngredientDto);
//    }
//
//    private RecipeIngredient getQuantity(RecipeIngredientDto recipeIngredientDto) {
//    }
}
