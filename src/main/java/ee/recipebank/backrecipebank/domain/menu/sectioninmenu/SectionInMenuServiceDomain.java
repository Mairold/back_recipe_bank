package ee.recipebank.backrecipebank.domain.menu.sectioninmenu;

import ee.recipebank.backrecipebank.Validation.Validation;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Data
@Service
public class SectionInMenuServiceDomain {

    @Resource
    SectionInMenuRepository sectionInMenuRepository;

    public Integer saveSectionInMenu(SectionInMenu sectionInMenu) {
        sectionInMenuRepository.save(sectionInMenu);
        return sectionInMenu.getId();
    }

    public List<SectionInMenu> getAllSectionsInMenu(Integer menuId) {
        return sectionInMenuRepository.findBy(menuId);
    }

    public SectionInMenu findSectionById(Integer sectionId) {
        Validation.validateSection(sectionInMenuRepository.findById(sectionId));
        return sectionInMenuRepository.findById(sectionId).get();
    }

    public void deleteSectionBy(Integer menuSectionId) {
        sectionInMenuRepository.deleteById(menuSectionId);
    }
}
