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
import ee.recipebank.backrecipebank.business.user.UserService;
import ee.recipebank.backrecipebank.domain.user.UserServiceDomain;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Data
@Service
public class MenuService {
    @Resource
    private SectionInMenuServiceDomain sectionInMenuServiceDomain;
    @Resource
    private MenuServiceDomain menuServiceDomain;
    @Resource
    private SectionInMenuMapper sectionInMenuMapper;
    @Resource
    private UserServiceDomain userServiceDomain;
    @Resource
    private RecipeServiceDomain recipeServiceDomain;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;
    @Resource
    private RecipeInSectionMapper recipeInSectionMapper;
    @Resource
    private MenuMapper menuMapper;

    public Integer addNewMenu(Integer userId) {
        Menu menu = getMenu(userServiceDomain.getValidUser(userId));
        return menuServiceDomain.saveMenu(menu);
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
        return sectionInMenuServiceDomain.saveSectionInMenu(sectionInMenu);
    }

    private SectionInMenu getSectionInMenu(Integer menuId, String sectionInMenuName) {
        SectionInMenu sectionInMenu = new SectionInMenu();
        sectionInMenu.setMenu(menuServiceDomain.getValidMenuBy(menuId));
        sectionInMenu.setName(sectionInMenuName);
        return sectionInMenu;
    }

    public List<SectionInMenuDto> getAllSectionsInMenu(Integer menuId) {
        return sectionInMenuMapper.toSectionInMenuDtos(sectionInMenuServiceDomain.getAllSectionsInMenu(menuId));
    }

    public List<RecipeInSectionDto> getAllRecipeInSectionsInMenu(Integer menuId) {
        return recipeInSectionMapper.toRecipeInSectionDtos(recipeInSectionServiceDomain.getAllRecipes(menuId));
    }

    public void saveRecipeInMenu(RecipeInsertRequest request) {
        Recipe recipe = recipeServiceDomain.findRecipeById(request.getRecipeId()); // selle küsib andmebaasist
        SectionInMenu section = sectionInMenuServiceDomain.findThisSectionId(request); // selle küsib andmebaasist
        RecipeInSection recipeInSection = recipeInSectionMapper.toEntity(request); // mäpib 2 ülejäänud rida Entityks
        recipeInSection.setRecipe(recipe); // lisab entityle andmebaasist küsitud retsepti Id
        recipeInSection.setSectionInMenu(section); // lisab entityle andmebaasist küsitud section'i id
        recipeInSection.setDateTimeAdded(Instant.now()); // lisab entityle Date&Time'i
        recipeInSectionServiceDomain.saveRecipeInSection(recipeInSection); // salvestab retsepti andmebaasi tabelisse recipeInSection
        // todo: teha ridadest 71-74 eraldi meetod siia samma publik meetodi sisse
    }

    public RecipeChangeRequest getRecipeInMenuById(Integer recipeInSectionId) {
        RecipeInSection recipeInSection = recipeInSectionServiceDomain.findRecipeInSectionById(recipeInSectionId);
        RecipeChangeRequest recipeChangeRequest = recipeInSectionMapper.toDto(recipeInSection); // saadame kommi mäpperisse ja teeme sellest RecipeChangeRequest klassi objekti
        return recipeChangeRequest; // tagastame mäpitud Dto kontrollerisse
    }

    public void changeRecipeInMenu(RecipeChangeRequest recipeChangeRequest) {
        RecipeInSection recipeInSectionById = recipeInSectionServiceDomain.findRecipeInSectionById(recipeChangeRequest.getRecipeInSectionId());
        // Objekt, mida hakkan üle kirjutama, tuleb kõigepealt RecipeInSection tabelist kätte saada. Dto'st Id kättesaamiseks kasutan getterit:
        RecipeInSection recipeInSection = recipeInSectionMapper.updateRecipeInSection(recipeChangeRequest, recipeInSectionById);
        // Sissetuleva dto muutmine entity'ks:
        recipeInSectionServiceDomain.updateRecipeInSection(recipeInSection);
        // suunan edasi domeeni servicesse

    }

    public void deleteRecipeInSection(Integer recipeInSectionId) {
        recipeInSectionServiceDomain.deleteRecipeInSection(recipeInSectionId);
    }

    public void deleteSection(Integer menuSectionId) {
        recipeInSectionServiceDomain.deleteRecipesInSectionBy(menuSectionId);
        sectionInMenuServiceDomain.deleteSectionBy(menuSectionId);
    }

    public List<MenuResponse> getAllMenusByUserId(Integer userId) {
        List<Menu> allMenusByUserId = menuServiceDomain.getAllMenusByUserId(userId);
        List<MenuResponse> menuResponses = menuMapper.toMenuResponse(allMenusByUserId);
        return menuResponses;
    }
}
