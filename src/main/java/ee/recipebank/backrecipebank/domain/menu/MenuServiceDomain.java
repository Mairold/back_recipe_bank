package ee.recipebank.backrecipebank.domain.menu;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class MenuServiceDomain {
    @Resource
    private MenuRepository menuRepository;

    public Integer saveMenu(Menu menu) {
        menuRepository.save(menu);
        return menu.getId();
    }

    public Menu getValidMenuBy(Integer menuId) {
        Optional<Menu> menuById = menuRepository.findById(menuId);
        Validation.validateMenu(menuById);
        return menuById.get();
    }
}
