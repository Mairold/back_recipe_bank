package ee.recipebank.backrecipebank.domain.menu;

import ee.recipebank.backrecipebank.bussiness.menu.SectionInMenuDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SectionInMenuMapper {
    SectionInMenu sectionInMenuDtoToSectionInMenu(SectionInMenuDto sectionInMenuDto);

    SectionInMenuDto sectionInMenuToSectionInMenuDto(SectionInMenu sectionInMenu);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SectionInMenu updateSectionInMenuFromSectionInMenuDto(SectionInMenuDto sectionInMenuDto, @MappingTarget SectionInMenu sectionInMenu);
}
