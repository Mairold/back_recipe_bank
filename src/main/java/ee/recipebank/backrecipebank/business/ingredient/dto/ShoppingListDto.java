package ee.recipebank.backrecipebank.business.ingredient.dto;

import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link ShoppingList} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingListDto implements Serializable {
    private Integer shoppingListId;
    private Integer menuMenuId;
    @Size(max = 255)
    private String shoppingListComment;
}