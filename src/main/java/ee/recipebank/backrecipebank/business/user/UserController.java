package ee.recipebank.backrecipebank.business.user;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("")
    @Operation(summary = "Toob fronti kasutajanime")
    public String getUsername(@RequestParam Integer userId) {
        return userService.getUsername(userId);
    }

    @GetMapping("/login")
    @Operation(summary = "Kontrollib username ja parooli. Loob login teenuse.")
    public Integer login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @PostMapping("/login")
    @Operation(summary = "Kontrollib kasutajanime olemasolu ja loob uue kasutaja.")
    public void createUser(@RequestParam String username, @RequestParam String password) {
        userService.createUser(username, password);
    }
}
