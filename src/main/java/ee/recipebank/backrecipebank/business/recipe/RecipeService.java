package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeToListDto;
import ee.recipebank.backrecipebank.business.recipe.dto.recipecategory.preparationTime.PreparationTimeDto;
import ee.recipebank.backrecipebank.business.recipe.dto.recipecategory.RecipeCategoryDto;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.*;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTime;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTimeMapper;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTimeService;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategory;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategoryMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategoryService;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionServiceDomain;
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

    public void changeRecipeInMenu(RecipeChangeDto request) {
        // muudatused on vaja teha recipe-in-section tabelis. Vaja on üle kirjutada senine retsept.



//        RecipeInSection recipeInSection = recipeInSectionMapper.toChangeEntity(request);

    }

}
