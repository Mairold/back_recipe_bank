package ee.recipebank.backrecipebank.domain.recipe;

import ee.recipebank.backrecipebank.bussiness.recipe.RecipeRequest;
import ee.recipebank.backrecipebank.bussiness.recipe.RecipeToListDto;
import ee.recipebank.backrecipebank.bussiness.recipe.recipeCategory.preparationTime.PreparationTimeDto;
import ee.recipebank.backrecipebank.bussiness.recipe.recipeCategory.RecipeCategoryDto;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeMapper;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeRepository;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeService {

    @Resource
    private RecipeCategoryMapper recipeCategoryMapper;
    @Resource
    private RecipeCategoryRepository recipeCategoryRepository;
    @Resource
    private PreparationTimeMapper preparationTimeMapper;
    @Resource
    private PreparationTimeRepository preparationTimeRepository;
    @Resource
    private RecipeMapper recipeMapper;
    @Resource
    private RecipeRepository recipeRepository;


    public List<RecipeCategoryDto> getAllCategories() {
        return recipeCategoryMapper.toDtos(recipeCategoryRepository.findAll());
    } // Tagastab controllerisse kõik kategooriad DTO-na

    public List<PreparationTimeDto> getAllPrepTimes() {
        return preparationTimeMapper.toDtos(preparationTimeRepository.findAll());
    } // Tagastab controllerisse kõik preptime'id DTO-na

    public List<RecipeToListDto> getAllRecipes() {
        return recipeMapper.toDtos(recipeRepository.findAll());
    } // tagastab controllerisse kõik retseptid

    public List<RecipeToListDto> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        return recipeMapper.toDtos(recipeRepository.findFilteredRecipesBy(prepId, catId, name));
    } // tagastab controllerisse filtreeritud retseptid

    public void saveRecipeInMenu(RecipeRequest request) {
        Recipe recipe = recipeRepository.findById(request.getRecipeId()).get();
        SectionInMenu sectionInMenu = sectionInMenuRepository.findById(request.getSectionInMenuId()).get();
//        recipeInSectionRepository.save(recipe);
    }
}
