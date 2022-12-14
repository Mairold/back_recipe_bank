package ee.recipebank.backrecipebank.business.recipe.dto;

import ee.recipebank.backrecipebank.domain.recipe.recipe.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Recipe} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeInstructionsDto implements Serializable {
    @Size(max = 2000)
    @NotNull
    private String instructions;
}