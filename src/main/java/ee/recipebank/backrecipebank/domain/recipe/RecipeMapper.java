package ee.recipebank.backrecipebank.domain.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeRequestDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeToListDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeMapper {
    @Mapping(source = "recipeId", target = "id")
    @Mapping(source = "categoryName", target = "recipeCategory.name")
    @Mapping(source = "prepTime", target = "preparationTime.prepTime")
    @Mapping(source = "recipeName", target = "name")
    Recipe toEntity(RecipeToListDto recipeToListDto);

    List<Recipe> toEntities(List<RecipeToListDto> recipeToListDtos);

    @Mapping(source = "id", target = "recipeId")
    @Mapping(source = "recipeCategory.name", target = "categoryName")
    @Mapping(source = "preparationTime.prepTime", target = "prepTime")
    @Mapping(source = "name", target = "recipeName")
    RecipeToListDto toDto(Recipe recipe);

    List<RecipeToListDto> toDtos(List<Recipe> recipe);

//    @InheritInverseConfiguration(name = "toDto")
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Recipe updateRecipeFromRecipeToListDto(RecipeToListDto recipeToListDto, @MappingTarget Recipe recipe);

    @Mapping(source = "recipeName", target = "name") //RecipeRequestDtost võtame recipename, Targeti Recipe'st
    @Mapping(source = "recipeCategoryId", target = "recipeCategory.id")
    @Mapping(source = "preparationTimeId", target = "preparationTime.id")
    @Mapping(constant = "", target = "instructions")
    @Mapping(source = "servingSize", target = "servingSize")
    Recipe recipeRequestDtoToRecipe(RecipeRequestDto request);

    // Recipe
//    private LocalDate dateFrom;
//    private LocalDate dateTo;

}
