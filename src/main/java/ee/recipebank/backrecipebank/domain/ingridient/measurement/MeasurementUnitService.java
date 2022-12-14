package ee.recipebank.backrecipebank.domain.ingridient.measurement;

import ee.recipebank.backrecipebank.business.ingredient.dto.MeasurementDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MeasurementUnitService {

    @Resource
    private MeasurementUnitRepository measurementUnitRepository;

    public List<MeasurementUnit> getAllMeasurements() {
        return measurementUnitRepository.findAll();
    }

    public MeasurementUnit getAllowedMeasurementUnit(MeasurementDto unit) {
        return measurementUnitRepository.findById(unit.getMeasurementId()).isPresent() ?
                measurementUnitRepository.findById(unit.getMeasurementId()).get() : null;
    }

    public MeasurementUnit getMeasurementUnitBy(Integer measurementUnitId) {
        if (measurementUnitId == null) {
            return null;
        }
        return measurementUnitRepository.findById(measurementUnitId).isPresent() ?
                measurementUnitRepository.findById(measurementUnitId).get() : null;
    }
}
