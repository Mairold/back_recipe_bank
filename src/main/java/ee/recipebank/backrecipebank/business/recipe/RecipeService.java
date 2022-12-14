package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.*;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTimeMapper;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTimeService;
import ee.recipebank.backrecipebank.domain.recipe.recipe.Recipe;
import ee.recipebank.backrecipebank.domain.recipe.recipe.RecipeMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipe.RecipeServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategoryMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class RecipeService {

    @Resource
    private PreparationTimeService preparationTimeService;
    @Resource
    private RecipeCategoryService recipeCategoryService;
    @Resource
    private RecipeServiceDomain recipeServiceDomain;
    @Resource
    private RecipeCategoryMapper recipeCategoryMapper;
    @Resource
    private PreparationTimeMapper preparationTimeMapper;
    @Resource
    private RecipeMapper recipeMapper;


    public List<RecipeCategoryDto> getAllCategories() {
        return recipeCategoryMapper.toDtos(recipeCategoryService.getAllCategories());
    }

    public List<PreparationTimeDto> getAllPrepTimes() {
        return preparationTimeMapper.toDtos(preparationTimeService.getAllPrepTimes());
    }

    public List<RecipeToListDto> getAllRecipes() {
        return recipeMapper.toDtos(recipeServiceDomain.getAllRecipes());
    }

    public List<RecipeToListDto> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        return recipeMapper.toDtos(recipeServiceDomain.getFilteredRecipes(prepId, catId, name));
    }

    public RecipeContentDto getRecipeContent(Integer recipeId) {
        return recipeMapper.toRecipeDto(recipeServiceDomain.findRecipeById(recipeId));
    }

    public RecipeResponseDto addRecipe(RecipeRequestDto newRecipe) {
        Recipe recipe = getRecipe(newRecipe);
        recipeServiceDomain.saveRecipe(recipe);
        return recipeMapper.toResponseDto(recipe);
    }

    public void saveRecipeInstructions(RecipeDto recipeDto) {
        Recipe recipeById = recipeServiceDomain.findRecipeById(recipeDto.getRecipeId());
        Recipe recipe = recipeMapper.updateRecipeWithInstructions(recipeDto, recipeById);
        recipeServiceDomain.saveInstructionsToRecipe(recipe);
    }

    public RecipeResponseDto getRecipeGeneralInfo(Integer recipeId) {
        return recipeMapper.toResponseDto(recipeServiceDomain.findRecipeById(recipeId));
    }

    private Recipe getRecipe(RecipeRequestDto newRecipe) {
        Recipe recipe = recipeMapper.recipeRequestDtoToRecipe(newRecipe);
        recipe.setDateFrom(LocalDate.now());
        recipe.setRecipeCategory(recipeCategoryService.findCategoryBy(newRecipe.getRecipeCategoryId()));
        recipe.setPreparationTime(preparationTimeService.findPreparationTimeBy(newRecipe.getPreparationTimeId()));
        return recipe;
    }
}