package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.*;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeCategoryDto;
import ee.recipebank.backrecipebank.business.recipe.dto.PreparationTimeDto;
import ee.recipebank.backrecipebank.domain.recipe.recipe.Recipe;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeDto;
import ee.recipebank.backrecipebank.domain.recipe.recipe.RecipeMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipe.RecipeServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTime;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTimeMapper;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTimeService;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategory;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategoryMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class RecipeService {

    @Resource
    private RecipeCategoryMapper recipeCategoryMapper;
    @Resource
    private PreparationTimeMapper preparationTimeMapper;
    @Resource
    private PreparationTimeService preparationTimeService;
    @Resource
    private RecipeMapper recipeMapper;
    @Resource
    private RecipeCategoryService recipeCategoryService;
    @Resource
    private RecipeServiceDomain recipeServiceDomain;


    public List<RecipeCategoryDto> getAllCategories() {
        List<RecipeCategory> allCategories = recipeCategoryService.getAllCategories();
        return recipeCategoryMapper.toDtos(allCategories);
    } // Tagastab controllerisse kõik kategooriad DTO-na

    public List<PreparationTimeDto> getAllPrepTimes() {
        List<PreparationTime> allPrepTimes = preparationTimeService.getAllPrepTimes();
        return preparationTimeMapper.toDtos(allPrepTimes);
    } // Tagastab controllerisse kõik preptime'id DTO-na

    public List<RecipeToListDto> getAllRecipes() {
        List<Recipe> allRecipes = recipeServiceDomain.getAllRecipes();
        return recipeMapper.toDtos(allRecipes);
    } // tagastab controllerisse kõik retseptid

    public List<RecipeToListDto> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        List<Recipe> filteredRecipes = recipeServiceDomain.getFilteredRecipes(prepId, catId, name);
        return recipeMapper.toDtos(filteredRecipes);
    } // tagastab controllerisse filtreeritud retseptid


    public RecipeContentDto getRecipeContent(Integer recipeId) {
        Recipe recipe = recipeServiceDomain.findRecipeById(recipeId);
        return recipeMapper.toRecipeDto(recipe);
    } // tagastab controllerisse väljaotsitud retsepti

    public RecipeResponseDto addRecipe(RecipeRequestDto newRecipe) {
        Recipe recipe = getRecipe(newRecipe);
        recipeServiceDomain.saveRecipe(recipe);
        return recipeMapper.toResponseDto(recipe);
    }

    private Recipe getRecipe(RecipeRequestDto newRecipe) {
        Recipe recipe = recipeMapper.recipeRequestDtoToRecipe(newRecipe);
        recipe.setDateFrom(LocalDate.now());
        recipe.setRecipeCategory(recipeCategoryService.findCategoryBy(newRecipe.getRecipeCategoryId()));
        recipe.setPreparationTime(preparationTimeService.findPreparationTimeBy(newRecipe.getPreparationTimeId()));
        return recipe;
    }


//    public void saveRecipeComment(Integer recipeId, RecipeInstructionsDto request) {
//        Recipe recipe = recipeServiceDomain.findRecipeById(recipeId);
//        recipeMapper.updateRecipeWithInstructions(request, recipe);
//        recipeServiceDomain.save(recipe);
//    }

//    public void saveRecipeComment(Integer recipeId, RecipeInstructionsDto request) {
//        Recipe recipe = recipeServiceDomain.findRecipeById(recipeId);
//        recipeMapper.updateRecipeWithInstructions(request, recipe);
//        recipeServiceDomain.save(recipe);
//    }

    public void saveRecipeComment(RecipeDto recipeDto) {
        Recipe recipeById = recipeServiceDomain.findRecipeById(recipeDto.getRecipeId());
        Recipe recipe = recipeMapper.updateRecipeWithInstructions(recipeDto, recipeById);
        recipeServiceDomain.addInstructionsToRecipe(recipe);


    }

    public RecipeResponseDto getRecipeGeneralInfo(Integer recipeId) {
        return recipeMapper.toResponseDto(recipeServiceDomain.findRecipeById(recipeId));
    }
}