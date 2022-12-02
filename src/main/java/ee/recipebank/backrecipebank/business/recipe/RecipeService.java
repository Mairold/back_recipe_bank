package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.business.recipe.recipeCategory.preparationTime.PreparationTimeDto;
import ee.recipebank.backrecipebank.business.recipe.recipeCategory.RecipeCategoryDto;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.*;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTime;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeMapper;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeService;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategory;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryService;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionServiceDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
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
    private RecipeServiceInDomain recipeServiceInDomain;
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
        List<Recipe> allRecipes = recipeServiceInDomain.getAllRecipes();
        return recipeMapper.toDtos(allRecipes);
    } // tagastab controllerisse kõik retseptid

    public List<RecipeToListDto> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        List<Recipe> filteredRecipes = recipeServiceInDomain.getFilteredRecipes(prepId, catId, name);
        return recipeMapper.toDtos(filteredRecipes);
//        return recipeMapper.toDtos(recipeRepository.findFilteredRecipesBy(prepId, catId, name));
    } // tagastab controllerisse filtreeritud retseptid

    public void saveRecipeInMenu(RecipeRequest request) {
        Recipe recipe = recipeServiceInDomain.findThisRecipeId(request); // selle küsin andmebaasist
        SectionInMenu section = sectionInMenuService.findThisSectionId(request); // selle küsin andmebaasist
        RecipeInSection recipeInSection = recipeInSectionMapper.toEntity(request); // mäpin 2 rida Entityks
        recipeInSection.setRecipe(recipe);
        recipeInSection.setSectionInMenu(section);
        recipeInSection.setDateTimeAdded(Instant.now());
        recipeInSectionServiceDomain.saveRecipeInSection(recipeInSection);
    }
// todo: teha ridadest 71-74 eraldi meetod siia samma publik meetodi sisse

}
