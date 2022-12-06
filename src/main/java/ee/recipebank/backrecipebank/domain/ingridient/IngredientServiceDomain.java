package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceDomain {
    @Resource
    private IngredientRepository ingredientRepository;

    public Optional<Ingredient> getOptionalIngredient(IngredientRequest ingredientRequest) {
        return ingredientRepository.findByName(ingredientRequest.getIngredientName());
    }

    public void saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }


    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientBy(Integer ingredientId) {
        return ingredientRepository.findById(ingredientId).get();
    }

}

