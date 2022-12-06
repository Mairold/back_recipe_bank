package ee.recipebank.backrecipebank.business.ingredient;

import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientGroupDto;
import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientInfo;
import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientRequest;
import ee.recipebank.backrecipebank.business.ingredient.dto.MeasurementDto;
import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredientDto;
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





}

