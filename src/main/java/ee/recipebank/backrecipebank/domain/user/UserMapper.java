package ee.recipebank.backrecipebank.domain.user;

import ee.recipebank.backrecipebank.business.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {

    User toUser(String username, String password);


}

