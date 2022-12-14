package ee.recipebank.backrecipebank.domain.recipe.recipeinsection;

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
        if (recipeInSectionRepository.findById(recipeInSectionId).isPresent()) {
            return recipeInSectionRepository.findById(recipeInSectionId).get();
        } else {
            throw new NullPointerException("RecipeInSection with id: " + recipeInSectionId + " does not exist");
        }
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
