package ee.recipebank.backrecipebank.login;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//backendi värav frondi poole. Sarnane repositoryle. Controller klass kus info liigub frontendi poole ja vastupidi.

public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Kontrollib username ja parooli. Loob login teenuse.")
    /* Allolevas reas 'public Integer login' tähendab Integer klassi, kõikidel primitiivsetel muutujatel on olemas klass(Integer)*/
    public Integer login(@RequestParam String username, @RequestParam String password) {
        Integer id = loginService.login(username, password);
        return id;
        /* Liikumise järjekord: LoginController => LoginService => UserService => UserRepository ja validation
        Controlleri funktsioon - Java klass, mis võtab frondist vastu infot ja saadab backist välja infot.
        login on meetodi nimi, sulgudes selgitus, millega meetod login tegelema hakkab.
        loginService objekti abil kutsume välja meetodi login. */
    }

    @PostMapping("/login")
    @Operation(summary = "Kontrollib kasutajanime olemasolu ja loob uue kasutaja.")
    public void createUser(@RequestParam String username, @RequestParam String password) {
        loginService.createUser(username, password);
        // siin on suund ühesuunaline - saadame ainult info andmebaasi ja tagasi fronti ei saadeta midagi
        // v.a juhul, kui kasutaja on juba olemas aga siis läheb errormessage välja otse validation klassist.
        }
}


