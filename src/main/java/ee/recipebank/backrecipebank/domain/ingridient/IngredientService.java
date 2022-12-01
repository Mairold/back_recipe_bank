package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.business.ingredient.IngredientInfo;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnitRepository;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupMapper;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupRepository;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnitRepository;
import ee.recipebank.backrecipebank.business.ingredient.IngredientGroupDto;
import ee.recipebank.backrecipebank.business.ingredient.MeasurementDto;
import ee.recipebank.backrecipebank.business.ingredient.IngredientRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    @Resource
    private IngredientMapper ingredientMapper;
    @Resource
    private IngredientGroupMapper ingredientGroupMapper;
    @Resource
    private MeasurementUnitRepository measurementUnitRepository;
    @Resource
    private IngredientGroupRepository ingredientGroupRepository;
    @Resource
    private IngredientRepository ingredientRepository;
    @Resource
    private AllowedMeasurementUnitRepository allowedMeasurementUnitRepository;

    public List<MeasurementDto> getAllMeasurements() {
        return ingredientMapper.toDtos(measurementUnitRepository.findAll());
    }

    public List<IngredientGroupDto> getAllGroups() {
        return ingredientGroupMapper.toDtos(ingredientGroupRepository.findAll());
    }

    @Transactional
    public void addIngredient(IngredientRequest request) {
        checkForDatabaseExistence(request);
        Ingredient ingredient = getIngredient(request);
        ingredientRepository.save(ingredient);

        List<AllowedMeasurementUnit> allowedMeasurementUnits = getAllowedMeasurementUnits(request, ingredient);
        allowedMeasurementUnitRepository.saveAll(allowedMeasurementUnits);
    }

    private void checkForDatabaseExistence(IngredientRequest ingredientRequest) {
        Validation.validateIngredient(ingredientRepository.findByName(ingredientRequest.getIngredientName()));
    }

    private Ingredient getIngredient(IngredientRequest ingredientRequest) {
        Ingredient ingredient = ingredientMapper.toEntity(ingredientRequest);
        ingredient.setIngredientGroup(ingredientGroupRepository.findById(ingredientRequest.getIngredientGroupId()).get());
        return ingredient;
    }

    private List<AllowedMeasurementUnit> getAllowedMeasurementUnits(IngredientRequest request, Ingredient ingredient) {
        List<AllowedMeasurementUnit> allowedMeasurementUnits = new ArrayList<>();

        for (MeasurementDto allowedMeasurement : request.getAllowedMeasurements()) {
            AllowedMeasurementUnit allowedMeasurementUnit = new AllowedMeasurementUnit();
            allowedMeasurementUnit.setMeasurementUnit(measurementUnitRepository.findById(allowedMeasurement.getMeasurementId()).get());
            allowedMeasurementUnit.setIngredient(ingredient);
            allowedMeasurementUnits.add(allowedMeasurementUnit);
        }
        return allowedMeasurementUnits;
    }

    public List<IngredientInfo> getAllIngredients() {
        //List<Ingredient> ingredients = ingredientRepository.findAll();
      //  ingredientMapper.toDtos(ingredients);
        return ingredientMapper.toAwesomeDtos(ingredientRepository.findAll());

     //   return ingredientInfo;
    }
}
