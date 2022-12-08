package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import ee.recipebank.backrecipebank.business.ingredient.dto.ShoppingListDto;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShoppingListMapper {

    @Mapping(source = "shoppingListComment", target = "comment")
    void updateEntity(ShoppingListDto shoppingListDto, @MappingTarget ShoppingList shoppingList);

    @Mapping(source = "id", target = "shoppingListId")
    @Mapping(source = "menu.id", target = "menuId")
    @Mapping(source = "menu.user.id", target = "userId")
    @Mapping(source = "menu.dateTimeAdded", target = "menuDate")
    @Mapping(source = "dateTimeAdded", target = "shoppingListDate")
    ShoppingListRequest toShoppingListRequest1(ShoppingList allShoppingListsByUserId);

    List<ShoppingListRequest> toShoppingListRequests1(List<ShoppingList> allShoppingListsByUserId);


}
