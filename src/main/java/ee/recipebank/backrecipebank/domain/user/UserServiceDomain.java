package ee.recipebank.backrecipebank.domain.user;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceDomain {

    @Resource
    private UserRepository userRepository;

    public String getUserName(Integer userId) {
        Validation.validateUser(userRepository.findById(userId));
        return userRepository.findById(userId).get().getUsername();
    }

    public User getValidUserBy(String username, String password) {
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);
        Validation.validateUserCredentials(byUsernameAndPassword);
        return byUsernameAndPassword.get();
    }

    public void validateAndSaveUser(User user) {
        Validation.validateUser(userRepository.existsBy(user.getUsername()));
        userRepository.save(user);
    }

    public User getValidUser(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Validation.validateUser(optionalUser);
        return optionalUser.get();
    }
}
