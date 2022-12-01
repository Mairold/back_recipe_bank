package ee.recipebank.backrecipebank.bussiness.reciept;

import ee.recipebank.backrecipebank.domain.menu.SectionInMenuMapper;
import ee.recipebank.backrecipebank.domain.recipe.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.SectionRecipeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeService {

    @Resource
    private SectionRecipeService sectionRecipeService;
    @Resource
    private RecipeInSectionMapper recipeInSectionMapper;

    public List<RecipeInSectionDto> getAllSectionsInMenu(Integer menuId) {
        return recipeInSectionMapper.toRecipeInSectionDtos(sectionRecipeService.getAllRecipes(menuId));
    }
}
