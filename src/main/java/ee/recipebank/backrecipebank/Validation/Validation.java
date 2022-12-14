package ee.recipebank.backrecipebank.Validation;

import ee.recipebank.backrecipebank.domain.menu.menu.Menu;
import ee.recipebank.backrecipebank.domain.ingridient.ingredient.Ingredient;
import ee.recipebank.backrecipebank.domain.menu.sectioninmenu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTime;
import ee.recipebank.backrecipebank.domain.recipe.recipe.Recipe;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategory;
import ee.recipebank.backrecipebank.domain.recipe.recipeinsection.RecipeInSection;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import ee.recipebank.backrecipebank.domain.user.User;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient.ShoppingListIngredient;
import ee.recipebank.backrecipebank.infrastructure.exception.BusinessException;

import java.util.List;
import java.util.Optional;

public class Validation {
    public static void validateUserCredentials(Optional<User> byUsernameAndPassword) {
        if (byUsernameAndPassword.isEmpty()) {
            throw new BusinessException(LoginError.INCORRECT_CREDENTIALS.getMessage(), LoginError.INCORRECT_CREDENTIALS.getErrorCode());
            //byUsernameANdPassword on entity objekt
            // throw <- selline omadus, et katkestab kogu selle meetodi
        }
    }
    public static void validateUser(boolean userExists) {
        if (userExists) {
            throw new BusinessException(LoginError.USER_TAKEN.getMessage(), LoginError.USER_TAKEN.getErrorCode());
        }
    }
    public static void validateIngredient(Optional<Ingredient> byIngredientName) {
        if (byIngredientName.isPresent()) {
            throw new BusinessException(RecipeError.INGREDIENT_EXISTS.getMessage(),RecipeError.INGREDIENT_EXISTS.getErrorCode());
        }
    }
    public static void validateSection(Optional<SectionInMenu> bySectionInMenuId) {
        if (bySectionInMenuId.isEmpty()) {
            throw new BusinessException(RecipeError.SECTION_DOES_NOT_EXISTS.getMessage(),RecipeError.SECTION_DOES_NOT_EXISTS.getErrorCode());
        }
    }
    public static void validateUser(Optional<User> byUserId) {
        if (byUserId.isEmpty()) {
            throw new BusinessException(LoginError.USER_DOES_NOT_EXIST.getMessage(), LoginError.USER_DOES_NOT_EXIST.getErrorCode());
        }
    }
    public static void validateMenu(Optional<Menu> byMenuId) {
        if (byMenuId.isEmpty()) {
            throw new BusinessException(LoginError.MENU_DOES_NOT_EXIST.getMessage(), LoginError.MENU_DOES_NOT_EXIST.getErrorCode());
        }
    }
    public static void validateShoppingList(Optional<ShoppingList> shoppingList) {
        if (shoppingList.isEmpty()) {
            throw new BusinessException(ShoppingListError.SHOPPING_LIST_NOT_FOUND.getMessage(), ShoppingListError.SHOPPING_LIST_NOT_FOUND.getErrorCode());
        }
    }
    public static void validateShoppingListIngredient(Optional<ShoppingListIngredient> shoppingListItem) {
        if (shoppingListItem.isEmpty()) {
            throw new BusinessException(ShoppingListError.SHOPPING_LIST_ITEM_NOT_FOUND.getMessage(), ShoppingListError.SHOPPING_LIST_ITEM_NOT_FOUND.getErrorCode());
        }
    }

    public static void validateRecipe(Optional<Recipe> RecipeById) {
        if (RecipeById.isEmpty()) {
            throw new BusinessException(RecipeError.RECIPE_DOES_NOT_EXISTS.getMessage(),RecipeError.RECIPE_DOES_NOT_EXISTS.getErrorCode());
        }
    }

    public static void validateRecipeInSection(Optional<RecipeInSection> RecipeInSectionById) {
        if (RecipeInSectionById.isEmpty()) {
            throw new BusinessException(RecipeError.RECIPEINSECTION_DOES_NOT_EXISTS.getMessage(),RecipeError.RECIPEINSECTION_DOES_NOT_EXISTS.getErrorCode());
        }
    }

    public static void validatePrepTime(Optional<PreparationTime> prepTimeById) {
        if (prepTimeById.isEmpty()) {
            throw new BusinessException(RecipeError.PREPTIME_DOES_NOT_EXISTS.getMessage(),RecipeError.PREPTIME_DOES_NOT_EXISTS.getErrorCode());
        }
    }

    public static void validateRecipeGategory(Optional<RecipeCategory> recipeCategoryById) {
        if (recipeCategoryById.isEmpty()) {
            throw new BusinessException(RecipeError.RECIPECATEGORY_DOES_NOT_EXISTS.getMessage(),RecipeError.RECIPECATEGORY_DOES_NOT_EXISTS.getErrorCode());
        }
    }
}
