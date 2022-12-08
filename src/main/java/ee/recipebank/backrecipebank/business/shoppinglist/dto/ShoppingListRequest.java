package ee.recipebank.backrecipebank.business.shoppinglist.dto;

import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link ShoppingList} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListRequest implements Serializable {
    private Integer shoppingListId;
    private Integer menuId;
    private Integer userId;
    @NotNull
    private Instant menuDate;
    @NotNull
    private Instant shoppingListDate;
}