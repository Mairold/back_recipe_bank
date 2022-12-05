package ee.recipebank.backrecipebank.business.ingredient.dto;

import lombok.Data;

import java.util.List;

@Data
public class IngredientRequest {

    private String ingredientName;
    private Integer ingredientGroupId;
    private List<MeasurementDto> allowedMeasurements;


}
