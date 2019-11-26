package mx.tec.foodFinder.service;

import mx.tec.foodFinder.bean.Recipe;
import mx.tec.foodFinder.util.MySQLConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecipeService implements IRecipeService {

    @Override
    public boolean recipe_C(Recipe recipe) {
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL recipe_C(?,?,?,?,?,?,?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_name",recipe.getName());
            statement.setString("in_difficulty",recipe.getDifficulty());
            statement.setString("in_portions",recipe.getPortions());
            statement.setString("in_preparationTime",recipe.getPreparationTime());
            statement.setString("in_procedure", recipe.getProcedure());
            statement.setString("in_imageLink",recipe.getImageLink());
            statement.setInt("in_image",0);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                recipe.setIdRecipe(result.getInt("idRecipe"));
                String nestedQuery = "CALL recipeIngredient_C(?,?,?,?)";
                CallableStatement nestedStatement = connection.prepareCall(nestedQuery);
                for (int i = 0; i < recipe.getIngredients().size(); i++){
                    nestedStatement.setInt("in_id", recipe.getIdRecipe());
                    nestedStatement.setString("in_ingredient",recipe.getIngredients().get(i));
                    nestedStatement.setString("in_measureUnit", "unidad");
                    nestedStatement.setString("in_amount", "1");
                    nestedStatement.execute();
                }
                nestedStatement.close();
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public boolean recipe_C_text(Recipe recipe) {
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL recipe_C(?,?,?,?,?,?,?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_name",recipe.getName());
            statement.setString("in_difficulty",recipe.getDifficulty());
            statement.setString("in_portions",recipe.getPortions());
            statement.setString("in_preparationTime",recipe.getPreparationTime());
            statement.setString("in_procedure", recipe.getProcedure());
            statement.setString("in_imageLink",recipe.getImageLink());
            statement.setInt("in_image",0);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                recipe.setIdRecipe(result.getInt("idRecipe"));
                String nestedQuery = "CALL recipeIngredient_C_text(?,?)";
                CallableStatement nestedStatement = connection.prepareCall(nestedQuery);
                for (int i = 0; i < recipe.getIngredients().size(); i++){
                    nestedStatement.setInt("in_id", recipe.getIdRecipe());
                    nestedStatement.setString("in_text",recipe.getIngredients().get(i));
                    nestedStatement.execute();
                }
                nestedStatement.close();
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    @Override
    public Recipe recipe_R(int id) {
        Recipe temp = new Recipe();
        try{
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL recipe_R(?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setInt("in_id",id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                setRecipeAtributes(temp, connection, resultSet);
            }
            //CLOSING
            resultSet.close();
            statement.close();
            connection.close();
            return temp;

        }catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private void setRecipeAtributes(Recipe temp, Connection connection, ResultSet resultSet) throws SQLException {
        temp.setIdRecipe(resultSet.getInt("idRecipe"));
        temp.setName(resultSet.getString("name"));
        temp.setDifficulty(resultSet.getString("difficulty"));
        temp.setPortions(resultSet.getString("portions"));
        temp.setPreparationTime(resultSet.getString("preparationTime"));
        temp.setProcedure(resultSet.getString("procedure"));
        temp.setImageLink(resultSet.getString("imageLink"));

        ArrayList<String> ingredients = new ArrayList<>();
        String nestedQuery = "CALL recipeIngredient_RA(?)";
        CallableStatement nestedStatement = connection.prepareCall(nestedQuery);
        nestedStatement.setInt("in_id", temp.getIdRecipe());
        ResultSet nestedResult = nestedStatement.executeQuery();
        while(nestedResult.next()){
            String tempIngredient = nestedResult.getString("amount") + " ";
            if (!nestedResult.getString("measureUnit").equals("")){
                tempIngredient+=nestedResult.getString("measureUnit") + " de ";
            }
            tempIngredient+=nestedResult.getString("ingredient");
            ingredients.add(tempIngredient);
        }
        nestedResult.close();
        nestedStatement.close();
        temp.setIngredients(ingredients);
    }

    @Override
    public ArrayList<Recipe> recipe_RA() {
        ArrayList<Recipe> result = new ArrayList<>();
        try{
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL recipe_RA()";
            CallableStatement statement = connection.prepareCall(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Recipe temp = new Recipe();
                setRecipeAtributes(temp, connection, resultSet);
                result.add(temp);
            }
            //CLOSING
            resultSet.close();
            statement.close();
            connection.close();


        }catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    @Override
    public ArrayList<Recipe> recipeFav_RA(int id) {
        ArrayList<Recipe> result = new ArrayList<>();
        try{
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL recipeFav_RA(?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setInt("in_id",id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Recipe temp = new Recipe();
                setRecipeAtributes(temp, connection, resultSet);
                result.add(temp);
            }
            //CLOSING
            resultSet.close();
            statement.close();
            connection.close();


        }catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    @Override
    public ArrayList<Recipe> recipeFav_U(int user, int recipe) {
        ArrayList<Recipe> result = new ArrayList<>();
        try{
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL recipeFav_U(?,?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setInt("in_id",user);
            statement.setInt("in_recipe",recipe);
            statement.execute();
            statement.close();
            connection.close();
        }catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
