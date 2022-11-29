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
    @Operation(summary = "Selle teenuse abil tagastame fronti retseptide kategooriate valikud")
    public List<RecipeCategoryDto> getAllCategories() {
        return recipeService.getAllCategories();
    }

    @GetMapping("/prep-time")
    @Operation(summary = "Selle teenuse abil tagastame fronti toidu valmistamise ajakulu valikud")
    public List<PreparationTimeDto> getAllPrepTimes() {
        return recipeService.getAllPrepTimes();
    }


}


