package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.reciept.ingredient.MeasurementDto;
import ee.recipebank.backrecipebank.reciept.ingredient.NewIngredient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public List<MeasurementDto> getAllMeasurements() {
        return ingredientMapper.toDtos(measurementUnitRepository.findAll());
    }

    public List<IngredientGroupDto> getAllGroups() {
        return ingredientGroupMapper.toDtos(ingredientGroupRepository.findAll());
    }

    public void addIngredient(NewIngredient newIngredient) {


    }
}
