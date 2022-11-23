package ee.recipebank.backrecipebank.Validation;

import ee.recipebank.backrecipebank.infrastructure.exception.BusinessException;
import ee.recipebank.backrecipebank.user.User;

import java.util.Optional;

public class Validation {
    public static void validateUserCredentials(Optional<User> byUsernameAndPassword) {
        if (byUsernameAndPassword.isEmpty()) {
            throw new BusinessException(LoginError.INCORRECT_CREDENTIALS.getMessage(), LoginError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }
}
