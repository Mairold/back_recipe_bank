package ee.recipebank.backrecipebank.domain.recipe.recipeInSection;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TempEntity {
    private Integer ingredientId;
    private Integer ingredientGroupId;
    private Integer measurementUnitId;
    private BigDecimal finalQuantity;

}
