package ee.recipebank.backrecipebank.bussiness.menu;

import ee.recipebank.backrecipebank.domain.menu.Menu;
import ee.recipebank.backrecipebank.domain.menu.MenuRepository;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.user.MenuPlanService;
import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.user.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;

@Data
@Service
public class MenuService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private MenuRepository menuRepository;
    @Resource
    private MenuPlanService menuPlanService;

    public Integer addNewMenu(Integer userId) {
        Menu menu = getMenu(menuPlanService.getValidUser(userId));
        return menuPlanService.saveMenu(menu);
    }

    private Menu getMenu(User validUser) {
        Menu menu = new Menu();
        menu.setUser(validUser);
        menu.setDateTimeAdded(Instant.now());
        menu.setStatus("A");
        return menu;
    }

    public Integer addNewSectionInMenu(Integer menuId, String sectionInMenuName) {
        SectionInMenu sectionInMenu = getSectionInMenu(menuId, sectionInMenuName);
         return menuPlanService.saveSectionInMenu(sectionInMenu);
    }

    private SectionInMenu getSectionInMenu(Integer menuId, String sectionInMenuName) {
        SectionInMenu sectionInMenu = new SectionInMenu();
        sectionInMenu.setMenu(menuPlanService.getValidMenuBy(menuId));
        sectionInMenu.setName(sectionInMenuName);
        return sectionInMenu;
    }
}
