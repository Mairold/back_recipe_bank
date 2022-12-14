package ee.recipebank.backrecipebank.domain.recipe.recipecategory;

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
        if (recipeCategoryRepository.findById(recipeCategoryId).isPresent()) {
            return recipeCategoryRepository.findById(recipeCategoryId).get();
        } else {
            throw new NullPointerException("Recipe category with id: " + recipeCategoryId + " does not exist");
        }
    }
}
