package ee.recipebank.backrecipebank.Validation;

import ee.recipebank.backrecipebank.domain.ingridient.Ingredient;
import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.infrastructure.exception.BusinessException;

import java.util.Optional;

public class Validation {
    public static void validateUserCredentials(Optional<User> byUsernameAndPassword) {
        if (byUsernameAndPassword.isEmpty()) {
            throw new BusinessException(LoginError.INCORRECT_CREDENTIALS.getMessage(), LoginError.INCORRECT_CREDENTIALS.getErrorCode());
            //byUsernameANdPassword on entity objekt
            // throw <- selline omadus, et katkestab kogu selle meetodi
        }
    }

    public static void validateUser(boolean userExists) {
        if (userExists) {
            throw new BusinessException(LoginError.USER_TAKEN.getMessage(), LoginError.USER_TAKEN.getErrorCode());
        }
    }

    public static void validateIngredient(Optional<Ingredient> byIngredientName) {
        if (byIngredientName.isPresent()) {
            throw new BusinessException(RecipeError.INGREDIENT_EXISTS.getMessage(),RecipeError.INGREDIENT_EXISTS.getErrorCode());
        }
    }
    public static void validateUser(Optional<User> byUserId) {
        if (byUserId.isEmpty()) {
            throw new BusinessException(LoginError.INCORRECT_CREDENTIALS.getMessage(), LoginError.INCORRECT_CREDENTIALS.getErrorCode());
            //byUsernameANdPassword on entity objekt
            // throw <- selline omadus, et katkestab kogu selle meetodi
        }
    }
}
