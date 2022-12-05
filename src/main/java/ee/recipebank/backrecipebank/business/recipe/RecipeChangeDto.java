package ee.recipebank.backrecipebank.business.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeChangeDto extends RecipeInsertRequest {
    private Integer recipeInSectionId;
    private String recipeName;
    private Integer servingSize;
    private String commentToRecipe;
}
