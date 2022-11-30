package ee.recipebank.backrecipebank.bussiness.recipe;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PreparationTimeMapper {
// pusserdasin käsitsi, ei kasutanud JPA-d
    @Mapping(source = "id", target = "prepTimeId")
    @Mapping(source = "prepTime", target = "prepTime")

    PreparationTimeDto toDto(PreparationTime preparationTime);

    List<PreparationTimeDto> toDtos(List<PreparationTime> preparationTimes);


}
