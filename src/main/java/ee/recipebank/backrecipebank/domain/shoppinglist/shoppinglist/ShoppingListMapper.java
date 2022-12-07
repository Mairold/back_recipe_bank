package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import ee.recipebank.backrecipebank.business.ingredient.dto.ShoppingListDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShoppingListMapper {

    @Mapping(source = "shoppingListComment", target = "comment")
    void updateEntity(ShoppingListDto shoppingListDto, @MappingTarget ShoppingList shoppingList);



    @Mapping(source = "id", target = "shoppingListId")
    @Mapping(source = "dateTimeAdded", target = "shoppingListDate")

    ShoppingListRequest toShoppingListResponse(ShoppingList shoppingList);
    List<ShoppingListRequest> toShoppingListResponses(List<ShoppingList> allShoppingLists);
}
