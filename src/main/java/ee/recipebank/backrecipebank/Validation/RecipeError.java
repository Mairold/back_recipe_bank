package ee.recipebank.backrecipebank.Validation;

import lombok.Getter;

@Getter
public enum RecipeError {
    INGREDIENT_EXISTS("Sellise nimega toiduaine on juba olemas", "123"),
    SECTION_DOES_NOT_EXISTS("Sellist sektsiooni ei ole olemas", "258"),
    RECIPE_DOES_NOT_EXISTS("Sellist retsepti ei ole olemas", "456"),
    RECIPEINSECTION_DOES_NOT_EXISTS("Sellist retsepti sektsioonis ei ole olemas", "333"),
    PREPTIME_DOES_NOT_EXISTS("Sellist PrepTime ei ole olemas", "654"),
    RECIPECATEGORY_DOES_NOT_EXISTS("Sellist retsepti kategooriat ei ole olemas", "456");

    private final String message;
    private final String errorCode;
    RecipeError(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
