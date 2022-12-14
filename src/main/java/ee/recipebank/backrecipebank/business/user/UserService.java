package ee.recipebank.backrecipebank.business.user;

import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.user.UserMapper;
import ee.recipebank.backrecipebank.domain.user.UserServiceDomain;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserServiceDomain userServiceDomain;
    @Resource
    private UserMapper userMapper;

    private Integer getValidUserId(String username, String password) {
        return userServiceDomain.getValidUserBy(username, password).getId();
    }

    public String getUsername(Integer userId) {
        return userServiceDomain.getUserName(userId);
    }

    public Integer login(String username, String password) {
        return getValidUserId(username, password);
    }

    public void createUser(String username, String password) {
        User user = userMapper.toUser(username, password);
        userServiceDomain.validateAndSaveUser(user);
    }
}
