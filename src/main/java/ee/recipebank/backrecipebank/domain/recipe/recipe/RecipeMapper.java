package ee.recipebank.backrecipebank.domain.recipe.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeMapper {

    @Mapping(source = "id", target = "recipeId")
    @Mapping(source = "recipeCategory.name", target = "categoryName")
    @Mapping(source = "preparationTime.prepTime", target = "prepTime")
    @Mapping(source = "name", target = "recipeName")
    RecipeToListDto toDto(Recipe recipe);

    List<RecipeToListDto> toDtos(List<Recipe> recipe);

    @Mapping(source = "id", target = "recipeId")
    @Mapping(source = "name", target = "recipeName")
    RecipeResponseDto toResponseDto(Recipe recipe);

    @Mapping(source = "recipeName", target = "name")
    @Mapping(constant = "", target = "instructions")
    Recipe toEntity(RecipeRequestDto request);

    @Mapping(source = "name", target = "recipeName")
    @Mapping(source = "recipeCategory.name", target = "categoryName")
    @Mapping(source = "preparationTime.prepTime", target = "prepTime")
    RecipeContentDto toRecipeDto(Recipe recipe);

    @Mapping(source = "recipeName", target = "name")
    @Mapping(constant = "", target = "instructions")
    @Mapping(source = "servingSize", target = "servingSize")
    Recipe recipeRequestDtoToRecipe(RecipeRequestDto request);

    @Mapping(source = "recipeComment", target = "instructions")
    Recipe updateRecipeWithInstructions(RecipeDto recipeDto, @MappingTarget Recipe recipe);
}