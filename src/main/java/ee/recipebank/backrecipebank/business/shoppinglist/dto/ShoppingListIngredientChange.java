package ee.recipebank.backrecipebank.business.shoppinglist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListIngredientChange implements Serializable {
    private Integer shoppingListIngredientId;
    private String customIngredientName;
    private String shoppingListIngredientName;
    private Integer ingredientGroupId;
    private Integer ingredientMeasurementId;
    private BigDecimal quantity;
}
