package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeRequest;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeContentDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeToListDto;
import ee.recipebank.backrecipebank.business.recipe.dto.recipeCategory.preparationTime.PreparationTimeDto;
import ee.recipebank.backrecipebank.business.recipe.dto.recipeCategory.RecipeCategoryDto;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.*;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTime;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeMapper;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeService;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategory;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryService;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionServiceDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    @Resource
    private SectionInMenuServiceDomain sectionInMenuService;
    @Resource
    private RecipeInSectionMapper recipeInSectionMapper;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;


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

    public void changeRecipeInMenu(RecipeChangeRequest request) {
        // muudatused on vaja teha recipe-in-section tabelis. Vaja on üle kirjutada senine retsept.


//        RecipeInSection recipeInSection = recipeInSectionMapper.toChangeEntity(request);

    }

    public RecipeContentDto getRecipeContent(Integer recipeId) {
        Recipe recipe = recipeServiceDomain.findRecipeById(recipeId);
        return recipeMapper.toRecipeDto(recipe);
    } // tagastab controllerisse väljaotsitud retsepti
}
