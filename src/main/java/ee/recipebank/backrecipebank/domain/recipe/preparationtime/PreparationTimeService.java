package ee.recipebank.backrecipebank.domain.recipe.preparationtime;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PreparationTimeService {

    @Resource
    private PreparationTimeRepository preparationTimeRepository;

    public List<PreparationTime> getAllPrepTimes() {
        return preparationTimeRepository.findAll();
    }

    public PreparationTime findPreparationTimeBy(Integer preparationTimeId) {
        Validation.validatePrepTime(preparationTimeRepository.findById(preparationTimeId));
        return preparationTimeRepository.findById(preparationTimeId).get();
    }
}
