package ee.recipebank.backrecipebank.bussiness.reciept.ingredient;

import lombok.Data;

import java.util.List;

@Data
public class IngredientRequest {

    private String ingredientName;
    private Integer ingredientGroupId;
    private List<MeasurementDto> allowedMeasurements;


}
