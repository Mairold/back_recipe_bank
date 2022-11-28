package ee.recipebank.backrecipebank.bussiness.reciept.ingredient;

import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link AllowedMeasurementUnit} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllowedMeasurementUnitDto implements Serializable {
    private Integer id;
    @NotNull
    private IngredientDto ingredient;
    @NotNull
    private MeasurementDto measurementUnit;
}