package ee.recipebank.backrecipebank.domain.ingridient;

import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientInfo;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnit;
import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientRequest;
import ee.recipebank.backrecipebank.business.ingredient.dto.MeasurementDto;
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


    @Mapping(source = "name", target = "ingredientName")
    @Mapping(source = "id", target = "ingredientId")
    IngredientInfo toDto(Ingredient ingredient);
    List<IngredientInfo> toAwesomeDtos(List<Ingredient> ingredients);
}
