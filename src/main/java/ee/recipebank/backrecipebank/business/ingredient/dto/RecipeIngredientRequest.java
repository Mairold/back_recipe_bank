package ee.recipebank.backrecipebank.business.ingredient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientRequest {
    private Integer recipeId;
    private Integer ingredientId;
    private BigDecimal ingredientQuantity;
    private Integer measurementUnitId;
}
