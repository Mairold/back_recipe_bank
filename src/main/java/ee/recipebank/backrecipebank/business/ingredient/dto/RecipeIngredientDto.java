package ee.recipebank.backrecipebank.business.ingredient.dto;

import ee.recipebank.backrecipebank.domain.ingridient.recipeingredient.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link RecipeIngredient} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDto implements Serializable {
    private Integer recipeId;
    private String ingredientName;
    private String measureUnitName;
    @NotNull
    private BigDecimal quantity; // Kas peaks jätma alles ainult selle Quantity rea?
}

