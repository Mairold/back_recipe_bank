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
public class MainViewInfoRequest implements Serializable {
    private Integer shoppingListId;
    private Integer menuId;
    private Integer userId;
    @NotNull
    private String menuDate;
    @NotNull
    private String shoppingListDate;
    private String shoppingListComment;

}