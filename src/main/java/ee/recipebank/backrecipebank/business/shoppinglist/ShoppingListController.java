package ee.recipebank.backrecipebank.business.shoppinglist;

import ee.recipebank.backrecipebank.business.ingredient.dto.ShoppingListDto;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.CustomShoppingListItem;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientDto;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/shopping-list")
public class ShoppingListController {

    @Resource
    private ShoppingListService shoppingListService;

    @GetMapping("")
    @Operation(summary = "See teenus tagastab shoppilisti")
    public ShoppingListDto getShoppingList(@RequestParam Integer shoppingListId) {
        return shoppingListService.getShoppingList(shoppingListId);
    }

    @PostMapping("")
    @Operation(summary = "See teenus loob uue shoppinglisti ja tagastab ID")
    public Integer saveNewShoppingList(@RequestParam Integer menuId) {
        return shoppingListService.generateNewShoppingList(menuId);
    }

    @GetMapping("/ingredients")
    @Operation(summary = "See teenus tagastab kõik ühe menüü komponendid shoppinglisti ID alusel.")
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
        shoppingListService.updateShoppingList(shoppingListId, shoppingListComment);
    }

    @GetMapping("/menus")
    @Operation(summary = "See teenus toob fronti kõik kasutaja shoppinglistid ja menüüd.")
    public List<ShoppingListRequest> getAllShoppingListsByUserId(@RequestParam Integer userId) {
        List<ShoppingListRequest> aLlShoppingListsByUserId = shoppingListService.getALlShoppingListsByUserId(userId);
        return aLlShoppingListsByUserId;
    }

}
