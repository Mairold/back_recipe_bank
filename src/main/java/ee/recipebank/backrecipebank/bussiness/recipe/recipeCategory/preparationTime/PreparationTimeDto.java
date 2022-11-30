package ee.recipebank.backrecipebank.bussiness.recipe.recipeCategory.preparationTime;

import ee.recipebank.backrecipebank.domain.recipe.preparationTime.PreparationTime;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link PreparationTime} entity
 */
@Data
public class PreparationTimeDto implements Serializable {
    private final Integer prepTimeId;
    @Size(max = 50)
    @NotNull
    private final String prepTime;
}