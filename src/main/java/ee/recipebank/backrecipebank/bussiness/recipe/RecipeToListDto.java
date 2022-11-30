package ee.recipebank.backrecipebank.bussiness.recipe;

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
public class RecipeToListDto implements Serializable {
    private Integer recipeId;
    @Size(max = 50)
    @NotNull
    private String categoryName;
    @Size(max = 50)
    @NotNull
    private String prepTime;
    @Size(max = 255)
    @NotNull
    private String recipeName;
}