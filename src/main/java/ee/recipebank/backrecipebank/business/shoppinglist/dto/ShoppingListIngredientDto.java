package ee.recipebank.backrecipebank.business.shoppinglist.dto;

import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link ShoppingListIngredient} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListIngredientDto implements Serializable {
    private Integer id;
    @Size(max = 255)
    @NotNull
    private String customIngredientName;
    @NotNull
    private Boolean isCustom = false;
    @Size(max = 20)
    @NotNull
    private String ingredientName;
    @Size(max = 255)
    @NotNull
    private String ingredientGroupName;
    @Size(max = 50)
    @NotNull
    private String measurementUnitName;
    private BigDecimal quantity;
}