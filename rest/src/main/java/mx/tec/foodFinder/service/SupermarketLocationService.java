package mx.tec.foodFinder.service;

import mx.tec.foodFinder.bean.SupermarketLocation;
import mx.tec.foodFinder.util.MySQLConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupermarketLocationService implements ISupermarketLocationService {
    private static SupermarketLocationService instance = null;
    private SupermarketLocationService(){}
    public static synchronized SupermarketLocationService getInstance(){
        if (instance == null) instance = new SupermarketLocationService();
        return instance;
    }

    @Override
    public ArrayList<SupermarketLocation> supermarketLocation_RA(String supermarket) {
        ArrayList<SupermarketLocation> supermarkets = new ArrayList<>();
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL supermarketLocation_RA(?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_supermarket",supermarket);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                SupermarketLocation temp = new SupermarketLocation();
                //user.setIdUser(result.getInt("idUser"));
                temp.setSupermarket(supermarket);
                temp.setLatitude(result.getDouble("latitude"));
                temp.setLongitude(result.getDouble("longitude"));
                supermarkets.add(temp);
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return supermarkets;
    }
}
