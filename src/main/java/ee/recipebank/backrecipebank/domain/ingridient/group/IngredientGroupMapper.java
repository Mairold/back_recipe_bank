package ee.recipebank.backrecipebank.domain.ingridient.group;

import ee.recipebank.backrecipebank.business.ingredient.dto.IngredientGroupDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IngredientGroupMapper {

    @Mapping(source = "id", target = "ingredientGroupId")
    @Mapping(source = "name", target = "ingredientGroupName")
    IngredientGroupDto toDto(IngredientGroup ingredientGroup);

    List<IngredientGroupDto> toDtos(List<IngredientGroup> ingredientGroups);


}
