package ee.recipebank.backrecipebank.business.recipe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeInsertRequest {
    private Integer sectionInMenuId;
    private Integer recipeId;
    private Integer servingSize;
    private String commentToRecipe;

}
