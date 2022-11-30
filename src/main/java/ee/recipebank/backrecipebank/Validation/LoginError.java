package ee.recipebank.backrecipebank.Validation;

import lombok.Getter;

@Getter
public enum LoginError {
    INCORRECT_CREDENTIALS("Sellist kasutajanime või parooli ei leitud", "333"),
    USER_TAKEN("Selline kasutajanimi on juba võetud, palun vali uus", "444"),
    USER_DOES_NOT_EXIST("Sellist kasutajat ei ole", "555"),
    MENU_DOES_NOT_EXIST("Sellist Menüü plaani ei ole", "666");


    private final String message;
    private final String errorCode;

    LoginError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
