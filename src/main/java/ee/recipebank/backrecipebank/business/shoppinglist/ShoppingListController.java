package ee.recipebank.backrecipebank.business.shoppinglist;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.*;
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

    @GetMapping("/ingredient")
    @Operation(summary = "See teenus tagastab ühe menüü ühe komponendid  ID alusel.")
    public ShoppingListIngredientChange getShoppingListItem(@RequestParam Integer shoppingListItemId) {
        return shoppingListService.getShoppingListItem(shoppingListItemId);
    }

    @DeleteMapping("/ingredient")
    @Operation(summary = "See teenus kustutab ingredienti")
    public void deleteShoppingListItem(@RequestParam Integer ingredientId) {
        shoppingListService.deleteShoppingListItem(ingredientId);
    }

    @PutMapping("")
    @Operation(summary = "See lisab kommentaari shoppiListi alla")
    public void updateShoppingList(@RequestParam Integer shoppingListId, @RequestParam String shoppingListComment) {
        shoppingListService.updateShoppingList(shoppingListId, shoppingListComment);
    }

    @GetMapping("/menus")
    @Operation(summary = "See teenus toob fronti kõik kasutaja shoppinglistid ja menüüd.")
    public List<MainViewInfoRequest> getALlShoppingListsAndMenusBy(@RequestParam Integer userId) {
        return shoppingListService.getALlShoppingListsAndMenusBy(userId);
    }

    @PutMapping("/ingredient")
    @Operation(summary = "See teenus uuendab poenimekirja komponendi infot")
    public void updateShoppingListItem(@RequestBody ShoppingListIngredientChange request) {
        shoppingListService.updateShoppingItem(request);
    }
}
