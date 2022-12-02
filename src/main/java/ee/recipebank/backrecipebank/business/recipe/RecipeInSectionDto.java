package ee.recipebank.backrecipebank.business.recipe;

import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link RecipeInSection} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeInSectionDto implements Serializable {
    private Integer id;
    private Integer sectionInMenuId;
    @Size(max = 255)
    @NotNull
    private String recipeName;
    @NotNull
    private Integer plannedServingSize;
    @Size(max = 255)
    private String comment;
}