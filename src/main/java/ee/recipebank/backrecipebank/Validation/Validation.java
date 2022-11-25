package ee.recipebank.backrecipebank.Validation;

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

    public static void validateUserName(Optional<User> byUserName) {
        if (byUserName.isPresent()) {
            throw new BusinessException(LoginError.USER_TAKEN.getMessage(), LoginError.USER_TAKEN.getErrorCode());
            //tee siit edasi
        }
    }
}
