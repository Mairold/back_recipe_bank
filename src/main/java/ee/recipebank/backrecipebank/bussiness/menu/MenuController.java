package ee.recipebank.backrecipebank.bussiness.menu;

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

}
