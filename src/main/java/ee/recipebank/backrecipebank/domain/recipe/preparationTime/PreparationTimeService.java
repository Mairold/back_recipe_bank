package ee.recipebank.backrecipebank.domain.recipe.preparationTime;

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
}
