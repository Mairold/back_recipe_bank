package ee.recipebank.backrecipebank.business.recipe.dto.recipecategory.preparationTime;

import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTime;
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