package ee.recipebank.backrecipebank.business.ingredient;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.business.ingredient.dto.*;
import ee.recipebank.backrecipebank.domain.ingridient.Ingredient;
import ee.recipebank.backrecipebank.domain.ingridient.IngredientMapper;
import ee.recipebank.backrecipebank.domain.ingridient.IngredientServiceDomain;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnitMapper;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnitService;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroup;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupMapper;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupService;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnit;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnitService;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredient;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredientMapper;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredientService;
import ee.recipebank.backrecipebank.domain.recipe.RecipeServiceDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.Instant;
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
    private RecipeServiceDomain recipeServiceDomain;
    @Resource
    private MeasurementUnitService measurementUnitService;
    @Resource
    private IngredientServiceDomain ingredientServiceDomain;
    @Resource
    private IngredientGroupService ingredientGroupService;
    @Resource
    private AllowedMeasurementUnitService allowedMeasurementUnitService;
    @Resource
    private RecipeIngredientService recipeIngredientService;
    @Resource
    private RecipeIngredientMapper recipeIngredientMapper;
    @Resource
    private AllowedMeasurementUnitMapper allowedMeasurementUnitMapper;

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

    public List<RecipeIngredientDto> getRecipeIngredients(Integer recipeId) {
        List<RecipeIngredient> recipeIngredients = recipeIngredientService.findRecipeIngredientsBy(recipeId);
        List<RecipeIngredientDto> recipeIngredientDtos = recipeIngredientMapper.toDtos(recipeIngredients);
        return recipeIngredientDtos;


        //    ingredients: [
//    {
//        ingredientName: '',
//                ingredientId: 0,
//            quantity: 0,
//            measurementUnit: ''
//    }
//      ],

    }

    public void addRecipeIngredientToRecipe(RecipeIngredientRequest request) {
        RecipeIngredient recipeIngredient = recipeIngredientMapper.toEntity(request);

        recipeIngredient.setIngredient(ingredientServiceDomain.getIngredientBy(request.getIngredientId()));
        recipeIngredient.setRecipe(recipeServiceDomain.getRecipeById(request.getRecipeId()));
        recipeIngredient.setMeasureUnit(measurementUnitService.getMeasurementUnitBy(request.getMeasurementUnitId()));
        recipeIngredient.setDateFrom(Instant.now());

        recipeIngredientService.saveRecipeIngredient(recipeIngredient);
    }

    public List<AllowedMeasurementUnitDto> getAllowedMeasurementUnits(Integer ingredientId) {
        List<AllowedMeasurementUnit> allowedMeasurementUnits = allowedMeasurementUnitService.findByIngredientId(ingredientId);

        return allowedMeasurementUnitMapper.toDtos(allowedMeasurementUnits);
    }
    //todo Quantity
//    public void

//    public void addQuantity(RecipeIngredientDto recipeIngredientDto) {
//        RecipeIngredient quantity = getQuantity (recipeIngredientDto);
//    }
//
//    private RecipeIngredient getQuantity(RecipeIngredientDto recipeIngredientDto) {
//    }
}
