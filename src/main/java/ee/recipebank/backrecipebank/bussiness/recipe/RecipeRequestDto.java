package ee.recipebank.backrecipebank.bussiness.recipe;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link ee.recipebank.backrecipebank.domain.recipe.Recipe} entity
 */
@Data
public class RecipeRequestDto implements Serializable {
    private Integer recipeCategoryId;
    private Integer preparationTimeId;
    @Size(max = 255)
    @NotNull
    private String recipeName;
    @NotNull
    private Integer servingSize;
}