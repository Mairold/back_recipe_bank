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
public class RecipeContentDto implements Serializable {
    @Size(max = 50)
    @NotNull
    private String categoryName;
    @Size(max = 50)
    @NotNull
    private String prepTime;
    @Size(max = 255)
    @NotNull
    private String recipeName;
    @NotNull
    private Integer servingSize;
    @Size(max = 2000)
    @NotNull
    private String instructions;
}