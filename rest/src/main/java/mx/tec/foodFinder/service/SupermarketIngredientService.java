package mx.tec.foodFinder.service;

import mx.tec.foodFinder.bean.SupermarketIngredient;
import mx.tec.foodFinder.util.MySQLConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupermarketIngredientService implements ISupermarketIngredientService{
    private static SupermarketIngredientService instance = null;
    private SupermarketIngredientService(){}
    public static synchronized SupermarketIngredientService getInstance(){
        if (instance == null) instance = new SupermarketIngredientService();
        return instance;
    }


    @Override
    public ArrayList<SupermarketIngredient> supermarketIngredient_RA(String ingredient) {
        ArrayList<SupermarketIngredient> ingredients = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL supermarketIngredient_RA(?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_ingredient",ingredient);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                SupermarketIngredient temp = new SupermarketIngredient();
                temp.setIngredient(ingredient);
                temp.setSupermarket(result.getString("supermarket"));
                temp.setPrice(result.getDouble("price"));
                ingredients.add(temp);
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredients;
    }

    @Override
    public ArrayList<SupermarketIngredient> supermarketIngredient_RA(int idIngredient) {
        ArrayList<SupermarketIngredient> ingredients = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL supermarketIngredient_RA_id(?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setInt("in_ingredient",idIngredient);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                SupermarketIngredient temp = new SupermarketIngredient();
                temp.setIngredient(result.getString("ingredient"));
                temp.setSupermarket(result.getString("supermarket"));
                temp.setPrice(result.getDouble("price"));
                ingredients.add(temp);
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredients;
    }

    @Override
    public ArrayList<SupermarketIngredient> supermarketIngredient_RA_text(String ingredient) {
        ArrayList<SupermarketIngredient> ingredients = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL supermarketIngredient_RA_text(?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_ingredient",ingredient);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                SupermarketIngredient temp = new SupermarketIngredient();
                temp.setIngredient(result.getString("ingredient"));
                temp.setSupermarket(result.getString("supermarket"));
                temp.setPrice(result.getDouble("price"));
                ingredients.add(temp);
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingredients;
    }

    @Override
    public boolean supermarketIngredient_C_id(SupermarketIngredient ingredient, int idIngredient) {

        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL supermarketIngredient_C_id(?,?,?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_supermarket", ingredient.getSupermarket());
            statement.setInt("in_ingredient",idIngredient);
            statement.setDouble("in_price", ingredient.getPrice());
            statement.execute();
            //CLOSING
            statement.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
