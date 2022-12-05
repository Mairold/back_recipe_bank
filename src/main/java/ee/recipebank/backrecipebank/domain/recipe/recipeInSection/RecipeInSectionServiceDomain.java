package ee.recipebank.backrecipebank.domain.recipe.recipeInSection;

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
        Optional<RecipeInSection> optionalRecipeInSection = recipeInSectionRepository.findById(recipeInSectionId); //siin saame paberi sees kommi
        RecipeInSection recipeInSection = optionalRecipeInSection.get(); // siin võtame kommi paberist lahti ja saame entity
        return recipeInSection; // tagastame eelmisesse meetodisse paberist väljavõetud kommi
    }

    public void updateRecipeInSection(RecipeInSection recipeInSection) {
        //Tegeleme siis, kui Rain sellest kõikidele räägib

    }
}
