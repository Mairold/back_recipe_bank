package ee.recipebank.backrecipebank.domain.recipe;

import ee.recipebank.backrecipebank.business.recipe.dto.RecipeRequestDto;
import ee.recipebank.backrecipebank.business.recipe.dto.RecipeResponseDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class RecipeServiceDomain {

    @Resource
    private RecipeRepository recipeRepository;

    @Resource
    private RecipeMapper recipeMapper;


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public List<Recipe> getFilteredRecipes(Integer prepId, Integer catId, String name) {
        return recipeRepository.findFilteredRecipesBy(prepId, catId, name);
    }

    public Recipe findRecipeById(Integer recipeId) {
        return recipeRepository.findById(recipeId).get();
    }


    public RecipeResponseDto addRecipe(RecipeRequestDto newRecipe) {
        Recipe recipe = recipeMapper.recipeRequestDtoToRecipe(newRecipe);
        //sammude järjekord:
        //recipeMapper.recipeRequestDtoToRecipe(newRecipe);
        //siis "introduce local variable ctrl+enter
        // ja siis tekib:  Recipe recipe = recipeMapper.recipeRequestDtoToRecipe(newRecipe);
        recipe.setDateFrom(LocalDate.now()); // kuna see on NotNull, siis paneme niiviisi kaasa
        recipeRepository.save(recipe); //selle liigutusega on see retsept andmebaasi lisatud.
        return recipeMapper.toResponseDto(recipe);
        //sammud samamoodi, alguses         new RecipeResponseDto(); ja siis introduce local variable.
    }

    public Recipe getRecipeById(Integer recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).get();
        return recipe;
    }

    public void addInstructionsToRecipe(Recipe recipe) {
        recipeRepository.save(recipe);

    }
}
