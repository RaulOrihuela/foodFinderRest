package mx.tec.foodFinder.service;

import mx.tec.foodFinder.bean.Recipe;

import java.util.ArrayList;

public interface IRecipeService {
    boolean recipe_C(Recipe recipe);
    boolean recipe_C_text(Recipe recipe);
    Recipe recipe_R(int id);
    ArrayList<Recipe> recipe_RA();
    ArrayList<Recipe> recipeFav_RA(int id);
    boolean recipeFav_U(int user, int recipe);
}
