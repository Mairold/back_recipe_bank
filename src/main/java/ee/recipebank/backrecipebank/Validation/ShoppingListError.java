package ee.recipebank.backrecipebank.Validation;

import lombok.Getter;

@Getter
public enum ShoppingListError {
    SHOPPING_LIST_NOT_FOUND("Sellise id-ga shoppinglisti ei ole", "321");

    private final String message;
    private final String errorCode;
    ShoppingListError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
