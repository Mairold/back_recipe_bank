package ee.recipebank.backrecipebank.login;

import org.springframework.stereotype.Service;

@Service // määrab ära, et see on service class ja annab lisafunktsionaalsuse selelle klassile.

public class LoginService {
    public LoginResponse login(String username, String password) {
        LoginResponse loginResponse = new LoginResponse(); // siia objekti paneme user ID. Ja selle id saadame tagasi front endile
        return loginResponse;
    }
}


/* siin loome login repsonsi ja paneme selle muutujasse, mille nimi on loginResponse. PÕHITÕDE!: Me ei saa kunagi anda edasi
ühte asja. Alati on mingi asi, mis annab edasi ja midagi, mis võtab vastu. Teisel pool peab ka olema ka sama klassi asi, mis võtab vastu
ja salvestab. Nt siin on loginResponse klassi loginresponse, selle saadame selle sisse. ja teisel pool controlleris on see, mis võtab vastu.


 */