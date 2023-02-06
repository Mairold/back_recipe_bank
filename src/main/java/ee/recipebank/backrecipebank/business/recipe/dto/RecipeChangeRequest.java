package ee.recipebank.backrecipebank.business.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeChangeRequest {
    private Integer recipeInSectionId;
    private String recipeName;
    private Integer servingSize;
    private String commentToRecipe;
}
