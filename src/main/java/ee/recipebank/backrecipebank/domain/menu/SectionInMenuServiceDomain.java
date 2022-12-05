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
    public User getValidUser(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Validation.validateUser(optionalUser);
        return optionalUser.get();
    }

    public Integer saveMenu(Menu menu) {
        menuRepository.save(menu);
        return menu.getId();
    }

    public Menu getValidMenuBy(Integer menuId) {
        Optional<Menu> menuById = menuRepository.findById(menuId);
        Validation.validateMenu(menuById);
        return menuById.get();
    }

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
}
