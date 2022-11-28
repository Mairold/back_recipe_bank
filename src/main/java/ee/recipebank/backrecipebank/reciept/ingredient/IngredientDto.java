package ee.recipebank.backrecipebank.reciept.ingredient;

import ee.recipebank.backrecipebank.domain.ingridient.Ingredient;
import ee.recipebank.backrecipebank.reciept.ingredient.IngredientGroupDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Ingredient} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDto implements Serializable {
    private Integer id;
    @NotNull
    private IngredientGroupDto ingredientGroup;
    @Size(max = 20)
    @NotNull
    private String name;
    @Size(max = 1)
    @NotNull
    private String status;
}