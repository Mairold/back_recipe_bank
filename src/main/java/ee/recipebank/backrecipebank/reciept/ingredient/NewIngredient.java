package ee.recipebank.backrecipebank.reciept.ingredient;

import lombok.Data;

import java.util.List;

@Data
public class NewIngredient {

    private String ingredientName;
    private Integer selectedIngredientGroupId;
    private List<MeasurementDto> allowedMeasurements;


}
