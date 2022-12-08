package ee.recipebank.backrecipebank.domain.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceDomain {

    @Resource
    private UserRepository userRepository;

    public String getUserName(Integer userId) {
        return userRepository.findById(userId).get().getUsername();
//        otsime tabelist Id järgi username'i
    }
}
