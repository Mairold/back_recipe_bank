package ee.recipebank.backrecipebank.business.user;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/user")
    @Operation(summary = "Toob fronti kasutajanime")
    public String getUsername(@RequestParam Integer userId){
        String username = userService.getUsername(userId);
        return username;
    }
}
