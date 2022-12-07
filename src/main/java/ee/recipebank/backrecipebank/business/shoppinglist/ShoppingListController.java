package ee.recipebank.backrecipebank.business.shoppinglist;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.CustomShoppingListItem;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientDto;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingListRequest;
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
        return shoppingListService.generateNewShoppingList(menuId);
    }

    @GetMapping("/ingredients")
    @Operation(summary = "See teenus tagastab kõik ühe menüü komponendid shoppinglisti ID aluse.")
    public List<ShoppingListIngredientDto> getAllShoppingListIngredients(@RequestParam Integer shoppingListId) {
        return shoppingListService.getAllShoppingListIngredients(shoppingListId);
    }

    @PostMapping("/ingredient")
    @Operation(summary = "See salvestab poenimekirja vaates lisatud tooted shoppinglisti nimekirja.")
    public void saveCustomShoppingListItem(@RequestBody CustomShoppingListItem customItem) {
        shoppingListService.saveCustomShoppingListItem(customItem);
    }

    @DeleteMapping("/ingredient")
    @Operation(summary = "See teenus kustutab ingredienti")
    public void deleteShoppingListItem(@RequestParam Integer ingredientId) {
//        shoppingListService.deleteShoppingListItem(ingredientId);
    }
    @PutMapping("")
    @Operation(summary = "See lisab kommentaari shoppiListi alla")
    public void updateShoppingList(@RequestParam Integer shoppingListId, @RequestParam String shoppingListComment) {
         shoppingListService.updateShoppingList(shoppingListId,shoppingListComment);
    }

    @GetMapping("")
    @Operation(summary = "Toob kõik kasutaja ostunimekirjad")
    public List<ShoppingListRequest> getAllShoppingLists(@RequestParam Integer menuId) {
        List<ShoppingListRequest> allShoppingLists = shoppingListService.getAllShoppingLists(menuId);
        return allShoppingLists;
    }


}
