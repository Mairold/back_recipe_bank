package ee.recipebank.backrecipebank.domain.user;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User getValidUser(String username, String password) {
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);
        Validation.validateUserCredentials(byUsernameAndPassword);
        User user = byUsernameAndPassword.get();
        return user;

    }

}
