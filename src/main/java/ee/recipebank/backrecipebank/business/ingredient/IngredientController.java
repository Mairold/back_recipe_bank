package ee.recipebank.backrecipebank.business.ingredient;

import ee.recipebank.backrecipebank.business.ingredient.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Resource
    private IngredientService ingredientService;

    @GetMapping("/measurements")
    @Operation(summary = "Selle teenuse abil tagastame fronti mõõteühikud")
    public List<MeasurementDto> getAllMeasurements() {
        return ingredientService.getAllMeasurements();
    }

    @GetMapping("/group")
    @Operation(summary = "Selle teenuse abil tagastame fronti toiduainegrupid")
    public List<IngredientGroupDto> getAllIngredientGroups() {
        return ingredientService.getAllGroups();
    }

    @PostMapping("")
    @Operation(summary = "See teenus kontrollib toiduaine olemasolu andmebaasis ja lisab, kui ei ole")
    public void addIngredient(@RequestBody IngredientRequest ingredientRequest) {
        ingredientService.addIngredient(ingredientRequest);
    }

    @GetMapping("/recipeIngredient")
    @Operation(summary = "See teenus tagastab kõik toiduained")
    public List<IngredientInfo> getAllIngredients() {return ingredientService.getAllIngredients(); }

    @GetMapping("/in-recipe")
    @Operation(summary = "Tagastab fronti konkreetse retsepti koostisosad koos koguste ja ühikutega")
    public List<RecipeIngredientDto> getRecipeIngredients(@RequestParam Integer recipeId){
        return ingredientService.getRecipeIngredients(recipeId);
    }

    @DeleteMapping("/in-recipe")
    @Operation(summary = "See teenus kustutab lisatud koostisosa retsepti lisamise ajal")
    public void deleteRecipeIngredient(@RequestParam Integer recipeIngredientId) {
        ingredientService.deleteRecipeIngredient(recipeIngredientId);
    }

    @PostMapping("/ingredientToRecipe")
    @Operation(summary = "See teenus salvestab/püüab kinni valitud ingredienti.")
    public void addRecipeIngredientToRecipe(@RequestBody RecipeIngredientRequest recipeIngredient) {
        ingredientService.addRecipeIngredientToRecipe(recipeIngredient);
    }

    @GetMapping("/recipeAllowedMeasurement")
    @Operation(summary = "See teenus kuvab valitud ingredienti allowed measurementsid.")
    public List<AllowedMeasurementUnitDto> getAllowedMeasurementUnits(@RequestParam Integer ingredientId) {
        return ingredientService.getAllowedMeasurementUnits(ingredientId);
    }
}

