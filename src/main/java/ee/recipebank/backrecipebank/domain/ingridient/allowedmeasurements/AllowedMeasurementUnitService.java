package ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AllowedMeasurementUnitService {

    @Resource
    private AllowedMeasurementUnitRepository allowedMeasurementUnitRepository;

    public void saveAllMeasurementUnits(List<AllowedMeasurementUnit> allowedMeasurementUnits) {
        allowedMeasurementUnitRepository.saveAll(allowedMeasurementUnits);
    }

    public List<AllowedMeasurementUnit> findByIngredientId(Integer ingredientId) {
        return allowedMeasurementUnitRepository.findByIngredientId(ingredientId);
    }
}
