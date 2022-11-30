package ee.recipebank.backrecipebank.bussiness.recipe;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeMapper {
    @Mapping(source = "recipeId", target = "id")
    @Mapping(source = "categoryName", target = "recipeCategory.name")
    @Mapping(source = "prepTime", target = "preparationTime.prepTime")
    @Mapping(source = "recipeName", target = "name")
    Recipe recipeToListDtoToRecipe(RecipeToListDto recipeToListDto);

    @InheritInverseConfiguration(name = "recipeToListDtoToRecipe")
    RecipeToListDto recipeToRecipeToListDto(Recipe recipe);

    @InheritConfiguration(name = "recipeToListDtoToRecipe")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recipe updateRecipeFromRecipeToListDto(RecipeToListDto recipeToListDto, @MappingTarget Recipe recipe);
}
