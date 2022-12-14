package ee.recipebank.backrecipebank.domain.recipe.recipeinsection;

import ee.recipebank.backrecipebank.Validation.Validation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeInSectionServiceDomain {

    @Resource
    private RecipeInSectionRepository recipeInSectionRepository;

    public List<RecipeInSection> getAllRecipes(Integer menuId) {
        return recipeInSectionRepository.findBy(menuId);
    }

    public void saveRecipeInSection(RecipeInSection recipeInSection) {
        recipeInSectionRepository.save(recipeInSection);
    }

    public RecipeInSection findRecipeInSectionById(Integer recipeInSectionId) {
            Validation.validateRecipeInSection(recipeInSectionRepository.findById(recipeInSectionId));
            return recipeInSectionRepository.findById(recipeInSectionId).get();
    }

    public void updateRecipeInSection(RecipeInSection recipeInSection) {
        recipeInSectionRepository.save(recipeInSection);
    }

    public List<RecipeInSection> findRecipeInSectionBy(Integer menuId) {
        return recipeInSectionRepository.findRecipeInSectionBy(menuId);
    }

    public void deleteRecipeInSection(Integer recipeInSectionId) {
        recipeInSectionRepository.deleteById(recipeInSectionId);
    }

    public void deleteRecipesInSectionBy(Integer menuSectionId) {
        recipeInSectionRepository.deleteBy(menuSectionId);
    }
}
