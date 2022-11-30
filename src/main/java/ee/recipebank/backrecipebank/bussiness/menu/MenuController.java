package ee.recipebank.backrecipebank.bussiness.menu;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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


}
