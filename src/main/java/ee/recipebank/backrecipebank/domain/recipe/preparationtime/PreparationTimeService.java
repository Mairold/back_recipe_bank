package ee.recipebank.backrecipebank.domain.recipe.preparationtime;

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
        if (preparationTimeRepository.findById(preparationTimeId).isPresent()) {
            return preparationTimeRepository.findById(preparationTimeId).get();
        } else {
            throw new NullPointerException("Prep Time with id: " + preparationTimeId + " does not exist");
        }
    }
}
