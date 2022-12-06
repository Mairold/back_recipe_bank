package ee.recipebank.backrecipebank.domain.ingridient.recipeingredient;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeIngredientMapper {
//    @Mapping(source = "ingredientName", target = "ingredient.name")
//    @Mapping(source = "measureUnitName", target = "measureUnit.name")
//    RecipeIngredient recipeIngredientDtoToRecipeIngredient(RecipeIngredientDto recipeIngredientDto);

//    @InheritInverseConfiguration(name = "recipeIngredientDtoToRecipeIngredient")
//    RecipeIngredientDto recipeIngredientToRecipeIngredientDto(RecipeIngredient recipeIngredient);
//
//    @InheritConfiguration(name = "recipeIngredientDtoToRecipeIngredient")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    RecipeIngredient updateRecipeIngredientFromRecipeIngredientDto(RecipeIngredientDto recipeIngredientDto, @MappingTarget RecipeIngredient recipeIngredient);

    @Mapping(source = "ingredient.name", target = "ingredientName")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "measureUnit.name", target = "measureUnitName")
    RecipeIngredientDto toDto(RecipeIngredient recipeIngredient);

    List<RecipeIngredientDto> toDtos(List<RecipeIngredient> recipeIngredients);


}
