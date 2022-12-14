package ee.recipebank.backrecipebank.business.ingredient;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.business.ingredient.dto.*;
import ee.recipebank.backrecipebank.domain.ingridient.ingredient.Ingredient;
import ee.recipebank.backrecipebank.domain.ingridient.ingredient.IngredientMapper;
import ee.recipebank.backrecipebank.domain.ingridient.ingredient.IngredientServiceDomain;
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
import ee.recipebank.backrecipebank.domain.recipe.recipe.RecipeServiceDomain;
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
    private IngredientMapper ingredientMapper;
    @Resource
    private IngredientGroupMapper ingredientGroupMapper;
    @Resource
    private RecipeIngredientMapper recipeIngredientMapper;
    @Resource
    private AllowedMeasurementUnitMapper allowedMeasurementUnitMapper;

    public List<MeasurementDto> getAllMeasurements() {
        return ingredientMapper.toDtos(measurementUnitService.getAllMeasurements());
    }

    public List<IngredientGroupDto> getAllGroups() {
        return ingredientGroupMapper.toDtos(ingredientGroupService.getAllGroups());
    }

    @Transactional
    public void addIngredient(IngredientRequest request) {
        checkForDatabaseExistence(request);
        Ingredient ingredient = getIngredient(request);
        ingredientServiceDomain.saveIngredient(ingredient);
        addAllowedMeasurements(request, ingredient);
    }

    public List<IngredientInfo> getAllIngredients() {
        return ingredientMapper.toAwesomeDtos(ingredientServiceDomain.getAllIngredients());
    }

    public List<RecipeIngredientDto> getRecipeIngredients(Integer recipeId) {
        return recipeIngredientMapper.toDtos(recipeIngredientService.findRecipeIngredientsBy(recipeId));
    }

    public void addRecipeIngredientToRecipe(RecipeIngredientRequest request) {
        RecipeIngredient recipeIngredient = recipeIngredientMapper.toEntity(request);
        getRecipeIngredient(request, recipeIngredient);
        recipeIngredientService.saveRecipeIngredient(recipeIngredient);
    }

    public List<AllowedMeasurementUnitDto> getAllowedMeasurementUnits(Integer ingredientId) {
        return allowedMeasurementUnitMapper.toDtos(allowedMeasurementUnitService.findByIngredientId(ingredientId));
    }

    public void deleteRecipeIngredient(Integer recipeIngredientId) {
        recipeIngredientService.deleteBy(recipeIngredientId);
    }

    private void getRecipeIngredient(RecipeIngredientRequest request, RecipeIngredient recipeIngredient) {
        recipeIngredient.setIngredient(ingredientServiceDomain.getIngredientBy(request.getIngredientId()));
        recipeIngredient.setRecipe(recipeServiceDomain.findRecipeById(request.getRecipeId()));
        recipeIngredient.setMeasureUnit(measurementUnitService.getMeasurementUnitBy(request.getMeasurementUnitId()));
        recipeIngredient.setDateFrom(Instant.now());
    }

    private void addAllowedMeasurements(IngredientRequest request, Ingredient ingredient) {
        List<AllowedMeasurementUnit> allowedMeasurementUnits = getAllowedMeasurementUnits(request, ingredient);
        allowedMeasurementUnitService.saveAllMeasurementUnits(allowedMeasurementUnits);
    }

    private void checkForDatabaseExistence(IngredientRequest ingredientRequest) {
        Validation.validateIngredient(ingredientServiceDomain.getOptionalIngredient(ingredientRequest));
    }

    private Ingredient getIngredient(IngredientRequest request) {
        Ingredient ingredient = ingredientMapper.toEntity(request);
        ingredient.setIngredientGroup(ingredientGroupService.getIngredientGroup(request));
        return ingredient;
    }

    private List<AllowedMeasurementUnit> getAllowedMeasurementUnits(IngredientRequest request, Ingredient ingredient) {
        List<AllowedMeasurementUnit> allowedMeasurementUnits = new ArrayList<>();
        addAllowedMeasurementToList(request, ingredient, allowedMeasurementUnits);
        return allowedMeasurementUnits;
    }

    private void addAllowedMeasurementToList(IngredientRequest request, Ingredient ingredient, List<AllowedMeasurementUnit> allowedMeasurementUnits) {
        for (MeasurementDto allowedMeasurement : request.getAllowedMeasurements()) {
            AllowedMeasurementUnit allowedMeasurementUnit = new AllowedMeasurementUnit();
            MeasurementUnit measurementUnit = measurementUnitService.getAllowedMeasurementUnit(allowedMeasurement);
            allowedMeasurementUnit.setMeasurementUnit(measurementUnit);
            allowedMeasurementUnit.setIngredient(ingredient);
            allowedMeasurementUnits.add(allowedMeasurementUnit);
        }
    }
}
