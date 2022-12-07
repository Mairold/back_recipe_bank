package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import ee.recipebank.backrecipebank.business.ingredient.dto.ShoppingListDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ShoppingListMapper {

    @Mapping(source = "shoppingListComment", target = "comment")
    void updateEntity(ShoppingListDto shoppingListDto, @MappingTarget ShoppingList shoppingList);

    @Mapping(source = "id", target = "shoppingListId")
    @Mapping(source = "dateTimeAdded", target = "shoppingListTimeAdded")
    @Mapping(source = "comment", target = "shoppingListComment")
    ShoppingListDto toDto(ShoppingList shoppingList);
}
