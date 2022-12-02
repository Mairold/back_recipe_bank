package ee.recipebank.backrecipebank.domain.recipe.recipeCategory;

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
}
