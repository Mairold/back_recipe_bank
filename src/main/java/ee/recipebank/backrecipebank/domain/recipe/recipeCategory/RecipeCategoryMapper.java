package ee.recipebank.backrecipebank.domain.recipe.recipeCategory;

import ee.recipebank.backrecipebank.business.recipe.dto.recipeCategory.RecipeCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeCategoryMapper {

    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "name", target = "categoryName")
    RecipeCategoryDto toDto(RecipeCategory recipeCategory);

    List<RecipeCategoryDto> toDtos(List<RecipeCategory> recipeCategories);


}
