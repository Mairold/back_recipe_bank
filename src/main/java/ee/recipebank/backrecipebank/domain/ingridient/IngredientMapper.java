package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnit;
import ee.recipebank.backrecipebank.bussiness.ingredient.IngredientRequest;
import ee.recipebank.backrecipebank.bussiness.ingredient.MeasurementDto;
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

    @Mapping(source = "ingredientName", target = "name")
    @Mapping(constant = "A", target = "status")
    Ingredient toEntity(IngredientRequest ingredientRequest);

}
