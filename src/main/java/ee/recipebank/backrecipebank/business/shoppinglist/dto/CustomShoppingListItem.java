package ee.recipebank.backrecipebank.business.shoppinglist.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomShoppingListItem {
    private String shoppingListIngredientName;
    private Boolean shoppingListIngredientIsCustom;
    private Integer ingredientGroupId;
    private Integer measurementId;
    private Integer shoppingListId;
    private BigDecimal quantity;
}
