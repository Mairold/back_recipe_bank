package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnitRepository;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupMapper;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroupRepository;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnitRepository;
import ee.recipebank.backrecipebank.reciept.ingredient.IngredientGroupDto;
import ee.recipebank.backrecipebank.reciept.ingredient.MeasurementDto;
import ee.recipebank.backrecipebank.reciept.ingredient.NewIngredient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public void addIngredient(NewIngredient newIngredient) {
        checkForDatabaseExistence(newIngredient);
        Ingredient ingredient = getIngredient(newIngredient);
        ingredientRepository.save(ingredient);

        List<AllowedMeasurementUnit> allowedMeasurementUnits = getAllowedMeasurementUnits(newIngredient, ingredient);
        allowedMeasurementUnitRepository.saveAll(allowedMeasurementUnits);
    }

    private void checkForDatabaseExistence(NewIngredient newIngredient) {
        Validation.validateIngredient(ingredientRepository.findByName(newIngredient.getIngredientName()));
    }

    private Ingredient getIngredient(NewIngredient newIngredient) {
        Ingredient ingredient = ingredientMapper.toEntity(newIngredient);
        ingredient.setIngredientGroup(ingredientGroupRepository.findById(newIngredient.getSelectedIngredientGroupId()).get());
        ingredient.setStatus("A");
        return ingredient;
    }

    private List<AllowedMeasurementUnit> getAllowedMeasurementUnits(NewIngredient newIngredient, Ingredient ingredient) {
        List<AllowedMeasurementUnit> allowedMeasurementUnits = new ArrayList<>();

        for (MeasurementDto allowedMeasurement : newIngredient.getAllowedMeasurements()) {
            AllowedMeasurementUnit allowedMeasurementUnit = new AllowedMeasurementUnit();
            allowedMeasurementUnit.setMeasurementUnit(measurementUnitRepository.findById(allowedMeasurement.getMeasurementId()).get());
            allowedMeasurementUnit.setIngredient(ingredient);
            allowedMeasurementUnits.add(allowedMeasurementUnit);
        }
        return allowedMeasurementUnits;
    }
}
