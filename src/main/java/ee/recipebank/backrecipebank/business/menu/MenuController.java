package ee.recipebank.backrecipebank.business.menu;

import ee.recipebank.backrecipebank.business.recipe.RecipeChangeDto;
import ee.recipebank.backrecipebank.business.recipe.RecipeInSectionDto;
import ee.recipebank.backrecipebank.business.recipe.RecipeInsertRequest;
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


    @GetMapping("/recipe-in-menu")
    @Operation(summary = "Toob fronti menüü sektsiooni salvestatud muudetava retsepti nime, sööjate arvu ja kommentaarid")
    public RecipeChangeDto getRecipeInMenuById(@RequestParam Integer recipeInSectionId) {
        return menuService.getRecipeInMenuById(recipeInSectionId);
    }
    @PutMapping("/change-recipe-in-menu")
    @Operation(summary = "Salvestab valitud retsepti juures tehtud muudatused")
    public void changeRecipeInMenu(@RequestBody RecipeChangeDto recipeUnderChangeDto) {
        menuService.changeRecipeInMenu(recipeUnderChangeDto);
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
