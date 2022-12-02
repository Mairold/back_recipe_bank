package ee.recipebank.backrecipebank.business.ingredient;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.business.ingredient.IngredientInfo;
import ee.recipebank.backrecipebank.domain.ingridient.Ingredient;
import ee.recipebank.backrecipebank.domain.ingridient.IngredientMapper;
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

    public List<MeasurementDto> getAllMeasurements() { // Kristiina
        return ingredientMapper.toDtos(measurementUnitRepository.findAll());
    }

    public List<IngredientGroupDto> getAllGroups() { // Helen
        return ingredientGroupMapper.toDtos(ingredientGroupRepository.findAll());
    }

    @Transactional
    public void addIngredient(IngredientRequest request) { // Kristiina
        checkForDatabaseExistence(request);
        Ingredient ingredient = getIngredient(request);
        ingredientRepository.save(ingredient);

        List<AllowedMeasurementUnit> allowedMeasurementUnits = getAllowedMeasurementUnits(request, ingredient);
        allowedMeasurementUnitRepository.saveAll(allowedMeasurementUnits);
    }

    private void checkForDatabaseExistence(IngredientRequest ingredientRequest) { // Helen
        Validation.validateIngredient(ingredientRepository.findByName(ingredientRequest.getIngredientName()));
    }

    private Ingredient getIngredient(IngredientRequest ingredientRequest) { // Kristiina
        Ingredient ingredient = ingredientMapper.toEntity(ingredientRequest);
        ingredient.setIngredientGroup(ingredientGroupRepository.findById(ingredientRequest.getIngredientGroupId()).get());
        return ingredient;
    }

    private List<AllowedMeasurementUnit> getAllowedMeasurementUnits(IngredientRequest request, Ingredient ingredient) { // Helen
        List<AllowedMeasurementUnit> allowedMeasurementUnits = new ArrayList<>();

        for (MeasurementDto allowedMeasurement : request.getAllowedMeasurements()) {
            AllowedMeasurementUnit allowedMeasurementUnit = new AllowedMeasurementUnit();
            allowedMeasurementUnit.setMeasurementUnit(measurementUnitRepository.findById(allowedMeasurement.getMeasurementId()).get());
            allowedMeasurementUnit.setIngredient(ingredient);
            allowedMeasurementUnits.add(allowedMeasurementUnit);
        }
        return allowedMeasurementUnits;
    }

    public List<IngredientInfo> getAllIngredients() { // Kristiina
        //List<Ingredient> ingredients = ingredientRepository.findAll();
      //  ingredientMapper.toDtos(ingredients);
        return ingredientMapper.toAwesomeDtos(ingredientRepository.findAll());

     //   return ingredientInfo;
    }
}
