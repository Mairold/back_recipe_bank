package ee.recipebank.backrecipebank.bussiness.recipe;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RecipeService {

    @Resource
    private RecipeCategoryMapper recipeCategoryMapper;
    @Resource
    private RecipeCategoryRepository recipeCategoryRepository;
    @Resource
    private PreparationTimeMapper preparationTimeMapper;
    @Resource
    private PreparationTimeRepository preparationTimeRepository;
    @Resource
    private RecipeMapper recipeMapper;
    @Resource
    private RecipeRepository recipeRepository;


    public List<RecipeCategoryDto> getAllCategories() {
        return recipeCategoryMapper.toDtos(recipeCategoryRepository.findAll());
    } // Tagastab controllerisse kõik kategooriad DTO-na

    public List<PreparationTimeDto> getAllPrepTimes() {
        return preparationTimeMapper.toDtos(preparationTimeRepository.findAll());
    } // Tagastab controllerisse kõik preptime'id DTO-na

    public List<RecipeToListDto> getAllRecipes() {
        return recipeMapper.toDtos(recipeRepository.findAll());
    }
}
