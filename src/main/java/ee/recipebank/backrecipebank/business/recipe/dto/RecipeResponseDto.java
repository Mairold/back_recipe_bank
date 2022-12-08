package ee.recipebank.backrecipebank.business.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponseDto {
    private Integer recipeId;
    private String recipeName;
}
