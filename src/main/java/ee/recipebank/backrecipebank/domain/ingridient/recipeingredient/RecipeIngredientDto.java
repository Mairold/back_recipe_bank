package ee.recipebank.backrecipebank.domain.ingridient.recipeingredient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link RecipeIngredient} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDto implements Serializable {
    @Size(max = 20)
    @NotNull
    private String ingredientName;
    @Size(max = 50)
    @NotNull
    private String measureUnitName;
    @NotNull
    private BigDecimal quantity;
}