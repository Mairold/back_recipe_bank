package ee.recipebank.backrecipebank.bussiness.menu;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.domain.Menu;
import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.user.UserRepository;
import lombok.Data;

import javax.annotation.Resource;
import java.util.Optional;

@Data
public class MenuService {

    @Resource
    private UserRepository userRepository;

    public Integer addNewMenu(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Validation.validateUser(optionalUser);
        Menu menu = new Menu();
        menu.setUser(optionalUser.get());
        return menu.getId();
    }
}
