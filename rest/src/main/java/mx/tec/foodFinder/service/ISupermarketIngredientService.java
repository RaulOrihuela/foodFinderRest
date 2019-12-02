package mx.tec.foodFinder.service;

import mx.tec.foodFinder.bean.SupermarketIngredient;

import java.util.ArrayList;

public interface ISupermarketIngredientService {
    ArrayList<SupermarketIngredient> supermarketIngredient_RA(String ingredient);
    ArrayList<SupermarketIngredient> supermarketIngredient_RA(int idIngredient);
    ArrayList<SupermarketIngredient> supermarketIngredient_RA_text(String ingredient);

    boolean supermarketIngredient_C_id(SupermarketIngredient ingredient,int idIngredient);
}
