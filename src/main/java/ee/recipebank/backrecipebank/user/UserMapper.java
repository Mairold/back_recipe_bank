package ee.recipebank.backrecipebank.user;

import ee.recipebank.backrecipebank.login.LoginResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);
}
