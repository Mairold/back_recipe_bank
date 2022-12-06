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


    public MeasurementUnit getAllowedMeasurementUnit(MeasurementDto unit) { //unit asemel võib olla ükskõik mis nimi
        return measurementUnitRepository.findById(unit.getMeasurementId()).get();
    }

    public MeasurementUnit getMeasurementUnitBy(Integer measurementUnitId) {
        return measurementUnitRepository.findById(measurementUnitId).get();
    }
}
