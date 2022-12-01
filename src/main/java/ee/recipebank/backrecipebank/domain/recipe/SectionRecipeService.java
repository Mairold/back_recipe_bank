package ee.recipebank.backrecipebank.domain.recipe;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SectionRecipeService {

    @Resource
    private RecipeInSectionRepository recipeInSectionRepository;

    public List<RecipeInSection> getAllRecipes(Integer menuId) {
        return recipeInSectionRepository.findBy(menuId);
    }
}
