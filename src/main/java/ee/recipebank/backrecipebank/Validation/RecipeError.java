package ee.recipebank.backrecipebank.Validation;

import lombok.Getter;

@Getter
public enum RecipeError {
    INGREDIENT_EXISTS("Sellise nimega toiduaine on juba olemas", "123");

    private final String message;
    private final String errorCode;
    RecipeError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
