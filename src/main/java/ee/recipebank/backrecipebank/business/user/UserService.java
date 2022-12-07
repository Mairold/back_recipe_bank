package ee.recipebank.backrecipebank.business.user;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.business.user.User;
import ee.recipebank.backrecipebank.domain.user.UserRepository;
import ee.recipebank.backrecipebank.domain.user.UserServiceDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserServiceDomain userServiceDomain;

    public Integer getValidUserId(String username, String password) {
       return getValidUser(username, password).getId();
    }

    public User getValidUser(String username, String password) {
        Optional<User> byUsernameAndPassword = userRepository.findByUsernameAndPassword(username, password);
        Validation.validateUserCredentials(byUsernameAndPassword);
        User user = byUsernameAndPassword.get(); //User entity võetakse .get ehk get funktsiooni abil Optionali seest välja.//
        return user;
    }
    //meetodil'getValidUser' alati sulud lõpus. Kas on tühjad seest või mitte, sellest sõltub, kas sinna läheb midagi veel sisse või mitte.//
    // meetodil on alati keha.
    //findByUsernameAndPassowrdi meetod, millega kaasa antakse username, password suglustest ja selle abil otsib/ tagastab useri.

    public void getUserName(User user) {
        boolean userExists = userRepository.existsBy(user.getUsername());
        Validation.validateUser(userExists); //see on username'i kontrollimise meetod
        userRepository.save(user); //see on useri andmebaasi lisamise meetod
    }

    public User getValidUser(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Validation.validateUser(optionalUser);
        return optionalUser.get();
    }

    public String getUsername(Integer userId) {
       String userName = userServiceDomain.getUserName(userId);
        return userName;
    }
}
