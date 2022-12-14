package ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements;

import ee.recipebank.backrecipebank.business.ingredient.dto.AllowedMeasurementUnitDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AllowedMeasurementUnitMapper {

    @Mapping(source = "measurementUnit.name", target = "allowedMeasurementName")
    @Mapping(source = "id", target = "allowedMeasurementUnitId")
    @Mapping(source = "measurementUnit.id", target = "measurementUnitId")
    AllowedMeasurementUnitDto toDto(AllowedMeasurementUnit allowedMeasurementUnit);

    List<AllowedMeasurementUnitDto> toDtos(List<AllowedMeasurementUnit> allowedMeasurementUnits);
}
