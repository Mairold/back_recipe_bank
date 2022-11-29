package ee.recipebank.backrecipebank.bussiness.recipe;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link RecipeCategory} entity
 */
@Data
public class RecipeCategoryDto implements Serializable {
    private final Integer id;
    @Size(max = 50)
    @NotNull
    private final String name;
}