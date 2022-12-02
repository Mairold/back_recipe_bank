package ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements;

import ee.recipebank.backrecipebank.domain.ingridient.IngredientRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllowedMeasurementUnitService {

    @Resource
    private IngredientRepository ingredientRepository;

    @Resource
    private AllowedMeasurementUnitRepository allowedMeasurementUnitRepository;

    public void saveAllMeasurementUnits(List<AllowedMeasurementUnit> allowedMeasurementUnits) {
        allowedMeasurementUnitRepository.saveAll(allowedMeasurementUnits);
    }
}
