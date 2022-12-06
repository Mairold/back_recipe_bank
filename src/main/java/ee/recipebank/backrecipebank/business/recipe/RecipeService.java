package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.*;
import ee.recipebank.backrecipebank.business.recipe.dto.recipeCategory.RecipeCategoryDto;
import ee.recipebank.backrecipebank.business.recipe.dto.recipeCategory.preparationTime.PreparationTimeDto;
import ee.recipebank.backrecipebank.domain.ingridient.recipeIngredient.RecipeIngredient;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.Recipe;
import ee.recipebank.backrecipebank.domain.recipe.RecipeMapper;
import ee.recipebank.backrecipebank.domain.recipe.RecipeServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTime;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeMapper;
import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTimeService;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategory;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategoryService;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionServiceDomain;
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

    public void saveRecipeInMenu(RecipeInsertRequest request) {
        Recipe recipe = recipeServiceDomain.findThisRecipeId(request); // selle küsib andmebaasist
        SectionInMenu section = sectionInMenuService.findThisSectionId(request); // selle küsib andmebaasist
        RecipeInSection recipeInSection = recipeInSectionMapper.toEntity(request); // mäpib 2 ülejäänud rida Entityks
        recipeInSection.setRecipe(recipe); // lisab entityle andmebaasist küsitud retsepti Id
        recipeInSection.setSectionInMenu(section); // lisab entityle andmebaasist küsitud section'i id
        recipeInSection.setDateTimeAdded(Instant.now()); // lisab entityle Date&Time'i
        recipeInSectionServiceDomain.saveRecipeInSection(recipeInSection); // salvestab retsepti andmebaasi tabelisse recipeInSection
        // todo: teha ridadest 71-74 eraldi meetod siia samma publik meetodi sisse
    }

    public void changeRecipeInMenu(RecipeChangeDto request) {
        // muudatused on vaja teha recipe-in-section tabelis. Vaja on üle kirjutada senine retsept.
//        RecipeInSection recipeInSection = recipeInSectionMapper.toChangeEntity(request);


    }

    //Hetkel add recipe andmebaasi, sest ta ei näita inspectis id'd.
    public RecipeResponseDto addRecipe(RecipeRequestDto newRecipe) {
        RecipeResponseDto suvalineNimi = recipeServiceDomain.addRecipe(newRecipe);

        //  recipeServiceDomain.addRecipe(newRecipe); //recipeService domain siin tagastab RecipeResponseDto, teha
        // sellest muutuja
        return suvalineNimi;
    }
}
