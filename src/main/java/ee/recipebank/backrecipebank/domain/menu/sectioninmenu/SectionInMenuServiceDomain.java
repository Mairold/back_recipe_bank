package ee.recipebank.backrecipebank.domain.menu.sectioninmenu;

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
        if (sectionInMenuRepository.findById(sectionId).isPresent()) {
            return sectionInMenuRepository.findById(sectionId).get();
        } else {
            throw new NullPointerException("Section with id: " + sectionId + " does not exist");
        }
    }

    public void deleteSectionBy(Integer menuSectionId) {
        sectionInMenuRepository.deleteById(menuSectionId);
    }
}
