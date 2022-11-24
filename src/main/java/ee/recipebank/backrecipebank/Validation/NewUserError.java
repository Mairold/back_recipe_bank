package ee.recipebank.backrecipebank.Validation;

import lombok.Getter;

@Getter
public enum NewUserError {

    INCORRECT_CREDENTIALS("Selline kasutajanimi on juba võetud, palun vali uus", "444");

    private final String message;
    private final String errorCode;

    NewUserError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }


}
