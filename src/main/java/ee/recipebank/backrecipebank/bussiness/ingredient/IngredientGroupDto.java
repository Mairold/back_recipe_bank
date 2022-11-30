package ee.recipebank.backrecipebank.bussiness.ingredient;

import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroup;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link IngredientGroup} entity
 */
@Data
public class IngredientGroupDto implements Serializable {
    private final Integer ingredientGroupId;
    @Size(max = 255)
    @NotNull
    private final String ingredientGroupName;
}