package ee.recipebank.backrecipebank.business.shoppinglist;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/shopping-list")
public class ShoppingListController {

    @Resource
    private ShoppingListService shoppingListService;

    @PostMapping("")
    @Operation(summary = "See teenus loob uue shoppinglisti ja tagastab ID")
    public Integer saveNewShoppingList(@RequestParam Integer menuId) {
        return shoppingListService.saveNewShoppingList(menuId);
    }

    @GetMapping("/ingredients")
    @Operation(summary = "See teenus tagastab kõik ühe menüü komponendid shoppinglisti ID aluse.")
    public List<ShoppingListIngredientDto> getAllShoppingListIngredients(@RequestParam Integer shoppingListId) {
        return shoppingListService.getAllShoppingListIngredients(shoppingListId);
    }

}
