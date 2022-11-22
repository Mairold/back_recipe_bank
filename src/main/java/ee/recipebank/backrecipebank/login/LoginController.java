package ee.recipebank.backrecipebank.login;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
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

    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(username, password);
        return loginResponse;

        //public - mis on meetodi tüüp ? // LoginResponse - Mis on tagastuse tüüp ( võib olla ka void, kui ei tagasta midagi, v int, boolean ja meil see objeks
        //<- meil võbi olla mitmeid objekte ja kuidagi peame neid koondada.. Ja see ongi klassinimi, ühisnimetaja.
        // sellekst, et näha, mis omadused sellel objektil on, siis avame LoginResponse enda klassi. Mis fieldid,mis asjad, meetodid, kons.seal on.
        // login väikese algusega on meetodi nimi
        // sulgudes meetodi parameetrid.. ehk siis mida see meetod tööle hakkab. Sulgudes võib olla ka tühjus - sõltub mida me meetodi sees teha tahame ja mis selleks vaja on.
// rida 21: Kutsume objekti "loginService" abil välja meetodi login.
//vasakule paneb sisse def. muutuja.
        // peab annab vastuse loginresponse.  <- annab frondile teele. // oleme kontrolleris, mis siin sisse tuleb ja mis sellega tehakse ja return siis
        // saadab frondile. Rida 22 tuleb frondist. 23 läheb fronti. Controll klass võtab vastu ja saadab välja asju. Siin klassis muud ei tehta.

    }


}


