package ee.recipebank.backrecipebank.login;

import org.springframework.stereotype.Service;

@Service

public class LoginService {
    public LoginResponse login(String username, String password) {
        LoginResponse loginResponse = new LoginResponse();
        return loginResponse;
    }
}

