package ee.recipebank.backrecipebank.domain.recipe.recipeinsection;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeInSectionServiceDomain {

    @Resource
    private RecipeInSectionRepository recipeInSectionRepository;

    public List<RecipeInSection> getAllRecipes(Integer menuId)
    {
        return recipeInSectionRepository.findBy(menuId);
    }

    public void saveRecipeInSection(RecipeInSection recipeInSection) {
        recipeInSectionRepository.save(recipeInSection);
    }

    public Optional<RecipeInSection> getRecipeInfo(Integer recipeInSectionId) {
       return recipeInSectionRepository.findById(recipeInSectionId);

    }

    public RecipeInSection findRecipeInSectionById(Integer recipeInSectionId) {
        Optional<RecipeInSection> optionalRecipeInSection = recipeInSectionRepository.findById(recipeInSectionId);
        RecipeInSection recipeInSection = optionalRecipeInSection.get();
        return recipeInSection;
    }

    public List<RecipeInSection> findRecipeInSectionBy(Integer menuId) {
        return recipeInSectionRepository.findRecipeInSectionBy(menuId);
    }
}
