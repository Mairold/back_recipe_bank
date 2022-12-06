package ee.recipebank.backrecipebank.business.menu;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeChangeRequest;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInSectionDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeInsertRequest;
import ee.recipebank.backrecipebank.domain.menu.Menu;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuMapper;
import ee.recipebank.backrecipebank.domain.menu.SectionInMenuServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.Recipe;
import ee.recipebank.backrecipebank.domain.recipe.RecipeServiceDomain;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionMapper;
import ee.recipebank.backrecipebank.domain.recipe.recipeInSection.RecipeInSectionServiceDomain;
import ee.recipebank.backrecipebank.domain.user.User;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

@Data
@Service
public class MenuService {
    @Resource
    private SectionInMenuServiceDomain menuPlanService;
    @Resource
    private SectionInMenuMapper sectionInMenuMapper;

    @Resource
    private RecipeServiceDomain recipeServiceDomain;
    @Resource
    private RecipeInSectionServiceDomain recipeInSectionServiceDomain;
    @Resource
    private RecipeInSectionMapper recipeInSectionMapper;
    @Resource
    private SectionInMenuServiceDomain sectionInMenuServiceDomain;

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
        //Tegeleme siis, kui Rain sellest kõikidele räägib
        RecipeInSection recipeInSection = recipeInSectionMapper.toChangeEntity(recipeChangeRequest);
        recipeInSectionServiceDomain.updateRecipeInSection(recipeInSection);
    }

}
