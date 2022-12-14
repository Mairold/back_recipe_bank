package ee.recipebank.backrecipebank.domain.recipe.recipecategory;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeCategoryService {

    @Resource
    private RecipeCategoryRepository recipeCategoryRepository;

    public List<RecipeCategory> getAllCategories() {
        return recipeCategoryRepository.findAll();
    }

    public RecipeCategory findCategoryBy(Integer recipeCategoryId) {
        Validation.validateRecipeGategory(recipeCategoryRepository.findById(recipeCategoryId));
        return recipeCategoryRepository.findById(recipeCategoryId).get();
    }
}
