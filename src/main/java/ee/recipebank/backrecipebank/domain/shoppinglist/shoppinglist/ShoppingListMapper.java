package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import ee.recipebank.backrecipebank.business.shoppinglist.dto.MainViewInfoRequest;
import ee.recipebank.backrecipebank.business.shoppinglist.dto.ShoppingListDto;
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
    @Mapping(source = "dateTimeAdded", target = "shoppingListTimeAdded")
    @Mapping(source = "comment", target = "shoppingListComment")
    ShoppingListDto toDto(ShoppingList shoppingList);

    @Mapping(source = "id", target = "shoppingListId")
    @Mapping(source = "menu.id", target = "menuId")
    @Mapping(source = "menu.user.id", target = "userId")
    @Mapping(source = "menu.dateTimeAdded", target = "menuDate")
    @Mapping(source = "dateTimeAdded", target = "shoppingListDate")
    MainViewInfoRequest toMainViewInfoRequest(ShoppingList allShoppingListsByUserId);

    List<MainViewInfoRequest> toMainViewInfoRequests(List<ShoppingList> allShoppingListsByUserId);
}



