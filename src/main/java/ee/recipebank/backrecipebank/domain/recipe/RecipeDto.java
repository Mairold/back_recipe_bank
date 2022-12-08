package ee.recipebank.backrecipebank.domain.recipe;

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
public class RecipeDto implements Serializable {
    private Integer recipeId;
    @Size(max = 2000)
    @NotNull
    private String recipeComment;

}