package ee.recipebank.backrecipebank.domain.recipe.recipeinsection;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeRequest;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInSectionDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeInSectionMapper {

    @Mapping(source = "id", target = "recipeInSectionId")
    @Mapping(source = "sectionInMenu.id", target = "sectionInMenuId")
    @Mapping(source = "recipe.id", target = "recipeId")
    @Mapping(source = "recipe.name", target = "recipeName")
    @Mapping(source = "plannedServingSize", target = "plannedServingSize")
    @Mapping(source = "comment", target = "comment")
    RecipeInSectionDto toRecipeInSectionDto(RecipeInSection recipeInSection);

    List<RecipeInSectionDto> toRecipeInSectionDtos(List<RecipeInSection> recipeInSections);

    @Mapping(source = "servingSize", target = "plannedServingSize")
    @Mapping(source = "commentToRecipe", target = "comment")
    RecipeInSection toEntity(RecipeInsertRequest request);

    @Mapping(source = "id", target = "recipeInSectionId")
    @Mapping(source = "recipe.name", target = "recipeName")
    @Mapping(source = "comment", target = "commentToRecipe")
    @Mapping(source = "plannedServingSize", target = "servingSize")
    RecipeChangeRequest toDto(RecipeInSection recipeInSection);


    @Mapping(source = "servingSize", target = "plannedServingSize")
    @Mapping(source = "commentToRecipe", target = "comment")
    RecipeInSection updateRecipeInSection(RecipeChangeRequest recipeChangeRequest, @MappingTarget RecipeInSection recipeInSection);
}
