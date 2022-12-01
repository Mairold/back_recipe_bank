package ee.recipebank.backrecipebank.bussiness.reciept;

import ee.recipebank.backrecipebank.bussiness.menu.SectionInMenuDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Resource
    private RecipeService recipeService;
    @GetMapping("/inSection")
    @Operation(summary = "See teenus toob ära kõik retseptid, mis on seotud antud menüü plaani id-ga")
    public List<RecipeInSectionDto> getAllRecipeInSections(@RequestParam Integer menuId) {
        return recipeService.getAllSectionsInMenu(menuId);
    }
}
