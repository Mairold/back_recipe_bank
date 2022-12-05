package ee.recipebank.backrecipebank.domain.recipe.recipeInSection;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInSectionDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeInSectionMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "sectionInMenu.id", target = "sectionInMenuId")
    @Mapping(source = "recipe.name", target = "recipeName")
    @Mapping(source = "plannedServingSize", target = "plannedServingSize")
    @Mapping(source = "comment", target = "comment")
    RecipeInSectionDto toRecipeInSectionDto(RecipeInSection recipeInSection);

    List<RecipeInSectionDto> toRecipeInSectionDtos(List<RecipeInSection> recipeInSections);

    @Mapping(source = "servingSize", target = "plannedServingSize")
    @Mapping(source = "commentToRecipe", target = "comment")
    RecipeInSection toEntity(RecipeInsertRequest request);

    @Mapping(source = "recipeInSectionId", target = "id")
    @Mapping(source = "servingSize", target = "plannedServingSize")
    @Mapping(source = "commentToRecipe", target = "comment")
    RecipeInSection toChangeEntity(RecipeChangeDto request);
    @Mapping(source = "id", target = "recipeInSectionId")
    @Mapping(source = "recipe.name", target = "recipeName")
    @Mapping(source = "comment", target = "commentToRecipe")
    @Mapping(source = "plannedServingSize", target = "servingSize")
    RecipeChangeDto toDto(RecipeInSection recipeInSection);
}
