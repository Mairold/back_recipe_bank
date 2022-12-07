package ee.recipebank.backrecipebank.business.ingredient.dto;

import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link AllowedMeasurementUnit} entity
 */
@Data
public class AllowedMeasurementUnitDto implements Serializable {
    private final Integer allowedMeasurementUnitId;
    private final Integer measurementUnitId;
    @Size(max = 50)
    @NotNull
    private final String allowedMeasurementName;
}