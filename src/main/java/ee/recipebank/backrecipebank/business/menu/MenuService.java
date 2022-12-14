package ee.recipebank.backrecipebank.business.menu;

import ee.recipebank.backrecipebank.business.menu.dto.MenuResponse;
import ee.recipebank.backrecipebank.business.menu.dto.SectionInMenuDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeRequest;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInSectionDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import ee.recipebank.backrecipebank.domain.menu.menu.Menu;
import ee.recipebank.backrecipebank.domain.menu.menu.MenuMapper;
import ee.recipebank.backrecipebank.domain.menu.menu.MenuServiceDomain;
import ee.recipebank.backrecipebank.domain.menu.sectioninmenu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.menu.sectioninmenu.SectionInMenuMapper;
import ee.recipebank.backrecipebank.domain.menu.sectioninmenu.SectionInMenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipe.Recipe;
import ee.recipebank.backrecipebank.domain.recipe.recipe.RecipeServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSectionServiceDomain;
import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.user.UserServiceDomain;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Service
public class MenuService {
    @Resource
    private SectionInMenuServiceDomain sectionInMenuServiceDomain;
    @Resource
    private MenuServiceDomain menuServiceDomain;
    @Resource
    private UserServiceDomain userServiceDomain;
    @Resource
    private RecipeServiceDomain recipeServiceDomain;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;
    @Resource
    private SectionInMenuMapper sectionInMenuMapper;
    @Resource
    private RecipeInSectionMapper recipeInSectionMapper;
    @Resource
    private MenuMapper menuMapper;

    public Integer addNewMenu(Integer userId) {
        return menuServiceDomain.saveMenu(getMenu(userServiceDomain.getValidUser(userId)));
    }

    public Integer addNewSectionInMenu(Integer menuId, String sectionInMenuName) {
        return sectionInMenuServiceDomain.saveSectionInMenu(getSectionInMenu(menuId, sectionInMenuName));
    }

    public List<SectionInMenuDto> getAllSectionsInMenu(Integer menuId) {
        return sectionInMenuMapper.toSectionInMenuDtos(sectionInMenuServiceDomain.getAllSectionsInMenu(menuId));
    }

    public List<RecipeInSectionDto> getAllRecipeInSectionsInMenu(Integer menuId) {
        return recipeInSectionMapper.toRecipeInSectionDtos(recipeInSectionServiceDomain.getAllRecipes(menuId));
    }

    public void saveRecipeInMenu(RecipeInsertRequest request) {
        recipeInSectionServiceDomain.saveRecipeInSection(getRecipeInSection(request));
    }

    public RecipeChangeRequest getRecipeInMenuById(Integer recipeInSectionId) {
        return recipeInSectionMapper.toDto(recipeInSectionServiceDomain.findRecipeInSectionById(recipeInSectionId));
    }

    public void changeRecipeInMenu(RecipeChangeRequest request) {
        RecipeInSection recipeInSectionById = recipeInSectionServiceDomain.findRecipeInSectionById(request.getRecipeInSectionId());
        recipeInSectionServiceDomain.updateRecipeInSection(recipeInSectionMapper.updateRecipeInSection(request, recipeInSectionById));
    }

    public void deleteRecipeInSection(Integer recipeInSectionId) {
        recipeInSectionServiceDomain.deleteRecipeInSection(recipeInSectionId);
    }

    public void deleteSection(Integer menuSectionId) {
        recipeInSectionServiceDomain.deleteRecipesInSectionBy(menuSectionId);
        sectionInMenuServiceDomain.deleteSectionBy(menuSectionId);
    }

    public List<MenuResponse> getAllMenusByUserId(Integer userId) {
        return menuMapper.toMenuResponse(menuServiceDomain.getAllMenusByUserId(userId));
    }

    private Menu getMenu(User validUser) {
        Menu menu = new Menu();
        menu.setUser(validUser);
        menu.setDateTimeAdded(Date.from(Instant.now()));
        menu.setStatus("A");
        return menu;
    }

    private SectionInMenu getSectionInMenu(Integer menuId, String sectionInMenuName) {
        SectionInMenu sectionInMenu = new SectionInMenu();
        sectionInMenu.setMenu(menuServiceDomain.getValidMenuBy(menuId));
        sectionInMenu.setName(sectionInMenuName);
        return sectionInMenu;
    }

    private RecipeInSection getRecipeInSection(RecipeInsertRequest request) {
        Recipe recipe = recipeServiceDomain.findRecipeById(request.getRecipeId());
        SectionInMenu section = sectionInMenuServiceDomain.findSectionById(request.getSectionInMenuId());
        RecipeInSection recipeInSection = recipeInSectionMapper.toEntity(request);
        recipeInSection.setRecipe(recipe);
        recipeInSection.setSectionInMenu(section);
        recipeInSection.setDateTimeAdded(Instant.now());
        return recipeInSection;
    }
}
