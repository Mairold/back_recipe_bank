package ee.recipebank.backrecipebank.bussiness.recipe.recipeCategory;

import ee.recipebank.backrecipebank.domain.recipe.recipeCategory.RecipeCategory;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link RecipeCategory} entity
 */
@Data
public class RecipeCategoryDto implements Serializable {
    private final Integer categoryId;
    @Size(max = 50)
    @NotNull
    private final String categoryName;
}