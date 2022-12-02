package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionServiceDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeInSectionService {

    @Resource
    private RecipeInSectionServiceDomain sectionRecipeService;
    @Resource
    private RecipeInSectionMapper recipeInSectionMapper;

    public List<RecipeInSectionDto> getAllSectionsInMenu(Integer menuId) {
        return recipeInSectionMapper.toRecipeInSectionDtos(sectionRecipeService.getAllRecipes(menuId));
    }
}
