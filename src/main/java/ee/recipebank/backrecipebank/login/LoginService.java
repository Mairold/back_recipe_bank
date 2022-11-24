package ee.recipebank.backrecipebank.login;

import ee.recipebank.backrecipebank.domain.user.*;
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
        /* klass, mis defineerib ära login service funktsionaalsuse
        User on entity. Entity klass, kuhu salvestame andmebaasi infot
        UserService on objekt ja .getValidUser on meetod, mille abil ..valideerime kasutaja
        LoginResponse on klassi nimetus. loginResponse on objekt LoginResponse klassist
*/
    }

    public void createUser(String username, String password) {
        NewUser newUser = userMapper.toNewUser(username, password); // kõigepealt mäpping ja seejärel getUsername meetod
        userService.getUserName(newUser); // siit saadame edasi
    }
}


   

