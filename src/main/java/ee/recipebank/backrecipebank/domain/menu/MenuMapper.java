package ee.recipebank.backrecipebank.domain.menu;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MenuMapper {

    @Mapping(source = "id", target = "menuId")
    @Mapping(source = "dateTimeAdded", target = "menuDate")
    MenuResponse toDto(Menu menuByUserId);
    List<MenuResponse> toMenuRequest(List<Menu> allMenusByUserId);
}


