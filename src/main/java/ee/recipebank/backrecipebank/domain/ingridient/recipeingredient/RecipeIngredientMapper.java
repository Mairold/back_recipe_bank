package ee.recipebank.backrecipebank.domain.ingridient.recipeIngredient;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeIngredientMapper {

    @Mapping(source = "recipeId", target = "recipe.id")
    @Mapping(source = "ingredientId", target = "ingredient.id")
    @Mapping(source = "measurementId", target = "measureUnit.id")
    RecipeIngredient recipeIngredientDtoToRecipeIngredient(RecipeIngredientDto recipeIngredientDto);

    @InheritInverseConfiguration(name = "recipeIngredientDtoToRecipeIngredient")
    RecipeIngredientDto recipeIngredientToRecipeIngredientDto(RecipeIngredient recipeIngredient);

    @InheritConfiguration(name = "recipeIngredientDtoToRecipeIngredient")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RecipeIngredient updateRecipeIngredientFromRecipeIngredientDto(RecipeIngredientDto recipeIngredientDto, @MappingTarget RecipeIngredient recipeIngredient);
}
