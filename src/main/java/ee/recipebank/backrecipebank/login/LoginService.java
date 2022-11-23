package ee.recipebank.backrecipebank.login;

import ee.recipebank.backrecipebank.user.User;
import ee.recipebank.backrecipebank.user.UserMapper;
import ee.recipebank.backrecipebank.user.UserService;
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

