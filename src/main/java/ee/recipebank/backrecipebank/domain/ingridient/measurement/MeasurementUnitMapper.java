package ee.recipebank.backrecipebank.domain.ingridient.measurement;

import ee.recipebank.backrecipebank.business.ingredient.MeasurementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MeasurementUnitMapper {

    @Mapping(source = "name", target = "measurementName")
    MeasurementDto toDto(MeasurementUnit measurementUnit);

}
