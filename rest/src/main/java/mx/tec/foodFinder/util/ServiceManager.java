package mx.tec.foodFinder.util;

import mx.tec.foodFinder.service.RecipeService;
import mx.tec.foodFinder.service.UserService;

public class ServiceManager {

    private static ServiceManager instance = null;
    private RecipeService recipeService;
    private UserService userService;

    public RecipeService getRecipeService() {
        return recipeService;
    }
    public UserService getUserService(){return  userService;}

    private ServiceManager(){
        recipeService = new RecipeService();
        userService = new UserService();
    }
    public static synchronized ServiceManager getInstance(){
        if (instance == null) instance = new ServiceManager();
        return instance;
    }
}
