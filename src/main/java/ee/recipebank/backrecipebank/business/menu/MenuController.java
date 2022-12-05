package ee.recipebank.backrecipebank.business.menu;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeRequest;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInSectionDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @PostMapping("")
    @Operation(summary = "Selle meetodi alusel salvestame uue Menüü plaani ja tagastame loodud kande id")
    public Integer addNewMenu(@RequestParam Integer userId) {
        return menuService.addNewMenu(userId);
    }

    @PostMapping("/section")
    @Operation(summary = "Selle meetodi alusel salvestame uue Menüü plaani ja tagastame loodud kande id")
    public Integer addNewSectionInMenu(@RequestParam Integer menuId, @RequestParam String sectionInMenuName) {
        return menuService.addNewSectionInMenu(menuId, sectionInMenuName);
    }

    @GetMapping("/section")
    @Operation(summary = "See teenus otsib kõik menüü plaani sektsioonid menüü plaani id järgi ja tagastab fronti")
    public List<SectionInMenuDto> getAllSectionsInMenu(@RequestParam Integer menuId) {
        return menuService.getAllSectionsInMenu(menuId);
    }

    @GetMapping("/recipe-in-menu") // töötab
    @Operation(summary = "Toob fronti menüü sektsiooni salvestatud muudetava retsepti nime, sööjate arvu ja kommentaarid")
    public RecipeChangeRequest getRecipeInMenuById(@RequestParam Integer recipeInSectionId) {
        return menuService.getRecipeInMenuById(recipeInSectionId); // tagastame Dto fronti
    }
    @PutMapping("/change-recipe-in-menu")
    @Operation(summary = "Salvestab sektsioonist valitud retsepti juures tehtud muudatused")
    public void changeRecipeInMenu(@RequestBody RecipeChangeRequest recipeChangeRequest) {
        //Tegeleme lõpuni siis, kui Rain sellest kõikidele räägib
        menuService.changeRecipeInMenu(recipeChangeRequest);
    }

    @PostMapping("/add-recipe-to-section")
    @Operation(summary = "Valitud retsepti salvestamine menüü sektsiooni")
    public void addRecipeToMenu(@RequestBody RecipeInsertRequest recipeRequest) {
        menuService.saveRecipeInMenu(recipeRequest);
    }
    @GetMapping("/recipe/inSection")
    @Operation(summary = "See teenus toob ära kõik retseptid, mis on seotud antud menüü plaani id-ga")
    public List<RecipeInSectionDto> getAllRecipeInSectionsInMenu(@RequestParam Integer menuId) {
        return menuService.getAllRecipeInSectionsInMenu(menuId);
    }
}
