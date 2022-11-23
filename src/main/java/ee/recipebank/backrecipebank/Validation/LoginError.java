package ee.recipebank.backrecipebank.Validation;

import lombok.Getter;

@Getter
public enum LoginError {
    INCORRECT_CREDENTIALS("Sellist kasutajanime või parooli ei leitud", "333");

    private final String message;
    private final String errorCode;

    LoginError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
