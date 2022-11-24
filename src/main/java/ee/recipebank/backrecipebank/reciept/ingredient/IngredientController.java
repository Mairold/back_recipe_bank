package ee.recipebank.backrecipebank.reciept.ingredient;

import ee.recipebank.backrecipebank.domain.ingridient.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
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
    public void getAllIngredientGroups() {

    }

    @PostMapping("addIngredient")
    @Operation(summary = "See teenus kontrollib toiduaine olemasolu andmebaasis ja lisab, kui ei ole")
    public void addIngredient(@RequestBody NewIngredient newIngredient) {

    }

}
