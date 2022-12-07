package ee.recipebank.backrecipebank.domain.ingridient.recipeIngredient;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link RecipeIngredient} entity
 */
@Data
public class RecipeIngredientDto implements Serializable {
    private final Integer recipeId;
    private final Integer ingredientId;
    private final Integer measurementId;
    @NotNull
    private final BigDecimal ingredientQuantity; // Kas peaks jätma alles ainult selle Quantity rea?
}

