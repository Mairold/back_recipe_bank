package ee.recipebank.backrecipebank.bussiness.recipe;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeCategoryMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    RecipeCategoryDto toDto(RecipeCategory recipeCategory);

    List<RecipeCategoryDto> toDtos(List<RecipeCategory> recipeCategories);


}
