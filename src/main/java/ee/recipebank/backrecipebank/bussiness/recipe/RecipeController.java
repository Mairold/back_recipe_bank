package ee.recipebank.backrecipebank.bussiness.recipe;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RecipeController {

    @Resource
    private RecipeService recipeService;

    @GetMapping("/category")
    @Operation(summary = "Selle teenuse abil tagastame retseptide kategooriate valikud frondi add-to-menu vaatesse")
    public List<RecipeCategoryDto> getAllCategories() {
        return recipeService.getAllCategories();
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
    @GetMapping("/filter-recipes")
    @Operation(summary = "Selle teenuse abil tagastame filtreeritud retseptid frondi add-to-menu vaatesse")
    public List<RecipeToListDto> getFilteredRecipes(@RequestParam Integer prepTimeId, @RequestParam Integer categoryId, @RequestParam String searchBoxValue) {
        return recipeService.getFilteredRecipes(prepTimeId, categoryId, searchBoxValue);

    }



}


