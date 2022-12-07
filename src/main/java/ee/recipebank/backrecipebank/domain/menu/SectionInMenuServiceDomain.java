package ee.recipebank.backrecipebank.domain.menu;

import ee.recipebank.backrecipebank.Validation.Validation;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.user.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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
