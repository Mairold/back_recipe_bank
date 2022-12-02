package ee.recipebank.backrecipebank.domain.recipe.recipeinsection;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeInSectionServiceDomain {

    @Resource
    private RecipeInSectionRepository recipeInSectionRepository;

    public List<RecipeInSection> getAllRecipes(Integer menuId)
    {
        return recipeInSectionRepository.findBy(menuId);
    }

    public void saveRecipeInSection(RecipeInSection recipeInSection) {
        recipeInSectionRepository.save(recipeInSection);
    }
}
