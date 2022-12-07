package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

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
    @NotNull
    private Instant shoppingListDate;
}