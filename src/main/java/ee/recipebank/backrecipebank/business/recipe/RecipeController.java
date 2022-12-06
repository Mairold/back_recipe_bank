package ee.recipebank.backrecipebank.business.recipe;


import ee.recipebank.backrecipebank.business.recipe.dto.RecipeContentDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeRequestDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeResponseDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeToListDto;
import ee.recipebank.backrecipebank.business.recipe.dto.recipeCategory.preparationTime.PreparationTimeDto;
import ee.recipebank.backrecipebank.business.recipe.dto.recipeCategory.RecipeCategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RecipeController {

    @Resource
    private RecipeService recipeService;

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

    @GetMapping("/filter-recipes") // urli nimes ei tohi olla tegusõna, vaja ära parandada
    @Operation(summary = "Selle teenuse abil tagastame filtreeritud retseptid frondi add-to-menu vaatesse")
    public List<RecipeToListDto> getFilteredRecipes(@RequestParam Integer prepTimeId, @RequestParam Integer categoryId, @RequestParam String searchBoxValue) {
        return recipeService.getFilteredRecipes(prepTimeId, categoryId, searchBoxValue);
    }

    @GetMapping("/recipe/content")
    @Operation(summary = "Toob fronti retsepti sisu")
    public RecipeContentDto getRecipeContent(@RequestParam Integer recipeId){
      return recipeService.getRecipeContent(recipeId);
    }






}









