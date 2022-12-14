package ee.recipebank.backrecipebank.domain.ingridient.recipeingredient;

import ee.recipebank.backrecipebank.business.ingredient.dto.RecipeIngredientDto;
import ee.recipebank.backrecipebank.business.ingredient.dto.RecipeIngredientRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RecipeIngredientMapper {

    @Mapping(source = "ingredient.name", target = "ingredientName")
    @Mapping(source = "id", target = "recipeIngredientId")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "measureUnit.name", target = "measureUnitName")
    RecipeIngredientDto toDto(RecipeIngredient recipeIngredient);

    List<RecipeIngredientDto> toDtos(List<RecipeIngredient> recipeIngredients);

    @Mapping(source = "ingredientQuantity", target = "quantity")
    RecipeIngredient toEntity(RecipeIngredientRequest recipeIngredient);
}
