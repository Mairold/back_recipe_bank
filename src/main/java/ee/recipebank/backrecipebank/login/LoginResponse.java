package ee.recipebank.backrecipebank.login;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginResponse implements Serializable {
 private Integer userId;

}


/* mida me tahame frontendis saada. Ainus asi, mille siin tahame edasi saata on user id.*/