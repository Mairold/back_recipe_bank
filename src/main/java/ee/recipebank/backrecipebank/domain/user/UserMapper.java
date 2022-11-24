package ee.recipebank.backrecipebank.domain.user;

import ee.recipebank.backrecipebank.login.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);

    NewUser toNewUser (String username, String password);

//    @Mapping(source = "username", target = "username")
//    @Mapping(source = "password", target = "password")


}

