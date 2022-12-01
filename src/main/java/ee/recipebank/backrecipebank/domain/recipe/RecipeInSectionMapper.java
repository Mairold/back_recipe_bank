package ee.recipebank.backrecipebank.domain.recipe;

import ee.recipebank.backrecipebank.business.recipe.RecipeInSectionDto;
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

}
