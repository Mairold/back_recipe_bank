package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.CustomShoppingListItem;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientChange;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListIngredientDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShoppingListIngredientMapper {

    @Mapping(source = "shoppingListIngredientName", target = "name")
    @Mapping(source = "shoppingListIngredientIsCustom", target = "isCustom")
    @Mapping(source = "quantity", target = "quantity")
    ShoppingListIngredient toEntity(CustomShoppingListItem customItem);

    @Mapping(source = "customIngredientName", target = "name")
    @Mapping(source = "quantity", target = "quantity")
    ShoppingListIngredient changeRequestToEntity(ShoppingListIngredientChange request, @MappingTarget ShoppingListIngredient ingredient);

    @Mapping(source = "id", target = "shoppingListIngredientId")
    @Mapping(source = "name", target = "customIngredientName")
    @Mapping(source = "ingredient.name", target = "shoppingListIngredientName")
    @Mapping(source = "ingredientGroup.name", target = "ingredientGroupName")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "measurementUnit.name", target = "measurementName")
    @Mapping(source = "isCustom", target = "shoppingListIngredientIsCustom")
    ShoppingListIngredientDto toDto(ShoppingListIngredient shoppingListIngredient);

    List<ShoppingListIngredientDto> toDtos(List<ShoppingListIngredient> shoppingListIngredients);

    @Mapping(source = "id", target = "shoppingListIngredientId")
    @Mapping(source = "name", target = "customIngredientName")
    @Mapping(source = "ingredientGroup.id", target = "ingredientGroupId")
    @Mapping(source = "ingredient.name", target = "shoppingListIngredientName")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "measurementUnit.id", target = "ingredientMeasurementId")
    ShoppingListIngredientChange toChangeDto(ShoppingListIngredient shoppingListIngredient);

}
