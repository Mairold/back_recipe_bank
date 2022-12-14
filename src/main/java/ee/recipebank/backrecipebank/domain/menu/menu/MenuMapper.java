package ee.recipebank.backrecipebank.domain.menu.menu;

import ee.recipebank.backrecipebank.business.menu.dto.MenuResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MenuMapper {

    @Mapping(source = "id", target = "menuId")
    @Mapping(source = "dateTimeAdded", target = "menuDate")
    MenuResponse toDto(Menu menuByUserId);
    List<MenuResponse> toMenuResponse(List<Menu> allMenusByUserId);
}


