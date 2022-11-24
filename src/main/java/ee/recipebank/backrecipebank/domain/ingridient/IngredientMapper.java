package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.reciept.ingredient.MeasurementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IngredientMapper {

    @Mapping(source = "id", target = "measurementId")
    @Mapping(source = "name", target = "measurementName")
    MeasurementDto toDto(MeasurementUnit measurementUnit);

    List<MeasurementDto> toDtos(List<MeasurementUnit> measurements);

}
