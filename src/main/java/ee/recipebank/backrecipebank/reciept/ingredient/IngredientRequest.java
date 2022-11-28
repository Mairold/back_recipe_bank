package ee.recipebank.backrecipebank.reciept.ingredient;

import lombok.Data;

import java.util.List;

@Data
public class IngredientRequest {

    private String ingredientName;
    private Integer ingredientGroupId;
    private List<MeasurementDto> allowedMeasurements;


}
