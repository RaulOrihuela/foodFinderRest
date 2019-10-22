package mx.tec.foodFinder.util;

import mx.tec.foodFinder.bean.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeSearcherMemory {
    private static RecipeSearcherMemory instance = null;

    HashMap<String, Recipe> knownRecipes;
    ArrayList<Recipe> newRecipes;

    private RecipeSearcherMemory(){
        knownRecipes = new HashMap<>();
        newRecipes = ServiceManager.getInstance().getRecipeService().recipe_RA();
        for (int i = 0; i<newRecipes.size();i++){
            knownRecipes.put(newRecipes.get(i).getName(),newRecipes.get(i));
        }
        newRecipes.clear();
    }

    public static synchronized RecipeSearcherMemory getInstance(){
        if (instance == null) instance = new RecipeSearcherMemory();
        return instance;
    }

    public HashMap<String, Recipe> getKnownRecipes() {
        return knownRecipes;
    }

    public ArrayList<Recipe> getNewRecipes() {
        return newRecipes;
    }

    public void addNewRecipe(Recipe recipe){
        newRecipes.add(recipe);
    }

    public void saveNewRecipes(){
        for (int i =0; i<newRecipes.size(); i++){
            if (ServiceManager.getInstance().getRecipeService().recipe_C(newRecipes.get(i))){
                knownRecipes.put(newRecipes.get(i).getName(),newRecipes.get(i));
            }
        }
        newRecipes.clear();
    }
}
