package ee.recipebank.backrecipebank.business.recipe.dto;

import ee.recipebank.backrecipebank.domain.recipe.Recipe;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Recipe} entity
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