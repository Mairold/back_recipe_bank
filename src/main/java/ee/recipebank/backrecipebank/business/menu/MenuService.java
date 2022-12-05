package ee.recipebank.backrecipebank.business.menu;

import ee.recipebank.backrecipebank.business.recipe.RecipeChangeDto;
import ee.recipebank.backrecipebank.business.recipe.RecipeInSectionDto;
import ee.recipebank.backrecipebank.business.recipe.RecipeInsertRequest;
import ee.recipebank.backrecipebank.domain.menu.Menu;
import ee.recipebank.backrecipebank.domain.menu.MenuRepository;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuMapper;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.RecipeServiceInDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionServiceDomain;
import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.user.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class MenuService {


    @Resource
    private SectionInMenuServiceDomain menuPlanService;
    @Resource
    private SectionInMenuMapper sectionInMenuMapper;

    @Resource
    private RecipeServiceInDomain recipeServiceInDomain;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;
    @Resource
    private RecipeInSectionMapper recipeInSectionMapper;

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

    public List<SectionInMenuDto> getAllSectionsInMenu(Integer menuId) {
        return sectionInMenuMapper.toSectionInMenuDtos(menuPlanService.getAllSectionsInMenu(menuId));


    }

    public List<RecipeInSectionDto> getAllRecipeInSectionsInMenu(Integer menuId) {
        return recipeInSectionMapper.toRecipeInSectionDtos(recipeInSectionServiceDomain.getAllRecipes(menuId));
    }

    public void changeRecipeInMenu(RecipeChangeDto recipeUnderChangeDto) {

    }

    public void saveRecipeInMenu(RecipeInsertRequest recipeRequest) {

    }

    public RecipeChangeDto getRecipeInMenuById(Integer recipeInSectionId) {
        RecipeInSection recipeInSection = recipeInSectionServiceDomain.findRecipeInSectionById(recipeInSectionId);
        RecipeChangeDto recipeChangeDto = recipeInSectionMapper.toDto(recipeInSection);
        return recipeChangeDto;
    }

}
