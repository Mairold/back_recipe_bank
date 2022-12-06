package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShoppingListIngredientMapper {
    @Mapping(source = "shoppingListIngredientName", target = "ingredient.name")
    @Mapping(source = "ingredientGroupName", target = "ingredientGroup.name")
    @Mapping(source = "measurementName", target = "measurementUnit.name")
    ShoppingListIngredient shoppingListIngredientDtoToShoppingListIngredient(ShoppingListIngredientDto shoppingListIngredientDto);

    @Mapping(source = "id", target = "shoppingListIngredientId")
    @Mapping(source = "name", target = "customIngredientName")
    @Mapping(source = "ingredient.name", target = "shoppingListIngredientName")
    @Mapping(source = "ingredientGroup.name", target = "ingredientGroupName")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "measurementUnit.name", target = "measurementName")
    @Mapping(source = "isCustom", target = "shoppingListIngredientIsCustom")
    ShoppingListIngredientDto toDto(ShoppingListIngredient shoppingListIngredient);

    List<ShoppingListIngredientDto> toDtos(List<ShoppingListIngredient> shoppingListIngredients);
}
