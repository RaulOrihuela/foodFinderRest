package mx.tec.foodFinder.util;

import mx.tec.foodFinder.service.RecipeService;

public class ServiceManager {

    private static ServiceManager instance = null;
    private RecipeService recipeService;

    public RecipeService getRecipeService() {
        return recipeService;
    }

    private ServiceManager(){
       recipeService = new RecipeService();
    }
    public static synchronized ServiceManager getInstance(){
        if (instance == null) instance = new ServiceManager();
        return instance;
    }
}
