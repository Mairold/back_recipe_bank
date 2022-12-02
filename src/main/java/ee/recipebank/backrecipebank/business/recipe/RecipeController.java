package ee.recipebank.backrecipebank.business.recipe;


import ee.recipebank.backrecipebank.business.recipe.recipeCategory.preparationTime.PreparationTimeDto;
import ee.recipebank.backrecipebank.business.recipe.recipeCategory.RecipeCategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RecipeController {

    @Resource
    private RecipeService recipeService;

    @Resource
    private RecipeInSectionService recipeInSectionService;

    @GetMapping("/category")
    @Operation(summary = "Selle teenuse abil tagastame retseptide kategooriate valikud frondi add-to-menu vaatesse")
    public List<RecipeCategoryDto> getAllCategories() {
        List<RecipeCategoryDto> allCategories = recipeService.getAllCategories();
        return allCategories;
    }

    @GetMapping("/prep-time")
    @Operation(summary = "Selle teenuse abil tagastame toidu valmistamise ajakulu valikud frondi add-to-menu vaatesse")
    public List<PreparationTimeDto> getAllPrepTimes() {
        return recipeService.getAllPrepTimes();
    }

    @GetMapping("/recipe")
    @Operation(summary = "Selle teenuse abil tagastame kõik retseptid frondi add-to-menu vaatesse")
    public List<RecipeToListDto> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("/recipe")
    @Operation(summary = "Selle teenuse abil lisame uue retsepti")
    public RecipeResponseDto addRecipe(@RequestBody RecipeRequestDto request) {
        return null;
//        return recipeService.addRecipe(request);
    }

    @GetMapping("/filter-recipes")
    @Operation(summary = "Selle teenuse abil tagastame filtreeritud retseptid frondi add-to-menu vaatesse")
    public List<RecipeToListDto> getFilteredRecipes(@RequestParam Integer prepTimeId, @RequestParam Integer categoryId, @RequestParam String searchBoxValue) {

        return recipeService.getFilteredRecipes(prepTimeId, categoryId, searchBoxValue);
    }

    @PostMapping("/add-recipe-to-section")
    @Operation(summary = "valitud retsepti salvestamine menüü sektsiooni")
    public void addRecipeToMenu(@RequestBody RecipeRequest recipeRequest) {
        recipeService.saveRecipeInMenu(recipeRequest);
    }

    @GetMapping("/recipe/inSection")
    @Operation(summary = "See teenus toob ära kõik retseptid, mis on seotud antud menüü plaani id-ga")
    public List<RecipeInSectionDto> getAllRecipeInSections(@RequestParam Integer menuId) {
        return recipeInSectionService.getAllSectionsInMenu(menuId);
    }
}









