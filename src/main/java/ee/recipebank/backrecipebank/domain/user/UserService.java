package ee.recipebank.backrecipebank.domain.user;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

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

}
