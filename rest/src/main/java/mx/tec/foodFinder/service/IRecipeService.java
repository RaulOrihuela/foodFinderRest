package mx.tec.foodFinder.service;

import mx.tec.foodFinder.bean.Recipe;

import java.util.ArrayList;

public interface IRecipeService {
    boolean recipe_C(Recipe recipe);
    Recipe recipe_R(int id);
    ArrayList<Recipe> recipe_RA();
    ArrayList<Recipe> recipeFav_RA(int id);
    ArrayList<Recipe> recipeFav_U(int user, int recipe);
}
