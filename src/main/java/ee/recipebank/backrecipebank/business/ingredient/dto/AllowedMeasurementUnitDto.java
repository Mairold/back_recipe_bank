package ee.recipebank.backrecipebank.business.ingredient.dto;

import ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements.AllowedMeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link AllowedMeasurementUnit} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllowedMeasurementUnitDto implements Serializable {
    private  Integer allowedMeasurementUnitId;
    private Integer measurementUnitId;
    @Size(max = 50)
    @NotNull
    private String allowedMeasurementName;
}