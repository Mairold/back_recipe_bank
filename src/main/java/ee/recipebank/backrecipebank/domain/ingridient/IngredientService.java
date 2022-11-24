package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.reciept.ingredient.MeasurementDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IngredientService {

    @Resource
    private IngredientMapper ingredientMapper;
    @Resource
    private MeasurementUnitRepository measurementUnitRepository;

    public List<MeasurementDto> getAllMeasurements() {
        return ingredientMapper.toDtos(measurementUnitRepository.findAll());
    }
}
