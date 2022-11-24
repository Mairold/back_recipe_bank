package ee.recipebank.backrecipebank.login;

import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.user.UserMapper;
import ee.recipebank.backrecipebank.domain.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    public Integer login(String username, String password) {
        User user = userService.getValidUser(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        Integer id = loginResponse.getUserId();
        return id;
    }
}
/* klass, mis defineerib ära  login service funktsionaalsuse
 *
 *User on entity. Entity klass, kuhu salvestame andmebaasi infot
 * userService on objekt ja .getValidUser on meetod, mille abil ..valideerime kasutaja */

