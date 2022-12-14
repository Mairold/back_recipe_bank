package ee.recipebank.backrecipebank.domain.menu.sectioninmenu;

import ee.recipebank.backrecipebank.business.menu.dto.SectionInMenuDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SectionInMenuMapper {

    @Mapping(source = "name", target = "sectionName")
    @Mapping(source = "id", target = "sectionId")
    SectionInMenuDto toSectionInMenuDto(SectionInMenu sectionInMenu);

    List<SectionInMenuDto> toSectionInMenuDtos(List<SectionInMenu> sectionInMenus);
}
