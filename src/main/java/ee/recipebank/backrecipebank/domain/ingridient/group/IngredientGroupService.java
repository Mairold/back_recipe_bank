package ee.recipebank.backrecipebank.domain.ingridient.group;

import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IngredientGroupService {

    @Resource
    private IngredientGroupRepository ingredientGroupRepository;


    public IngredientGroup getIngredientGroup(IngredientRequest ingredientRequest) {
        return ingredientGroupRepository.findById(ingredientRequest.getIngredientGroupId()).get();
    }

    public List<IngredientGroup> getAllGroups() {
        return ingredientGroupRepository.findAll();
    }



}