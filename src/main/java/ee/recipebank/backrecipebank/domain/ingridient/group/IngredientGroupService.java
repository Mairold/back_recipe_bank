package ee.recipebank.backrecipebank.domain.ingridient.group;

import ee.recipebank.backrecipebank.business.ingredient.IngredientRequest;
import ee.recipebank.backrecipebank.domain.ingridient.Ingredient;
import ee.recipebank.backrecipebank.domain.ingridient.IngredientRepository;
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