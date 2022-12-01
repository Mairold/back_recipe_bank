package ee.recipebank.backrecipebank.business.recipe;

import lombok.Data;

@Data
public class RecipeRequest {
    private Integer sectionInMenuId;
    private Integer recipeId;
    private Integer servingSize;
    private String commentToRecipe;

}