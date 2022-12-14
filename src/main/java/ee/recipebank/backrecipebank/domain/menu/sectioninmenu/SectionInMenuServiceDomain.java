package ee.recipebank.backrecipebank.domain.menu.sectioninmenu;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import ee.recipebank.backrecipebank.domain.menu.menu.MenuRepository;
import ee.recipebank.backrecipebank.domain.user.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Data
@Service
public class SectionInMenuServiceDomain {
    @Resource
    private UserRepository userRepository;
    @Resource
    private MenuRepository menuRepository;
    @Resource
    SectionInMenuRepository sectionInMenuRepository;


    public Integer saveSectionInMenu(SectionInMenu sectionInMenu) {
        sectionInMenuRepository.save(sectionInMenu);
        return sectionInMenu.getId();
    }

    public List<SectionInMenu> getAllSectionsInMenu(Integer menuId) {
        return sectionInMenuRepository.findBy(menuId);
    }

    public SectionInMenu findThisSectionId(RecipeInsertRequest request) {
        return sectionInMenuRepository.findById(request.getSectionInMenuId()).get();
    }

    public void deleteSectionBy(Integer menuSectionId) {
        sectionInMenuRepository.deleteById(menuSectionId);
    }
}