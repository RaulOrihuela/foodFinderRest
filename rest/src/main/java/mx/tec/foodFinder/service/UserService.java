package mx.tec.foodFinder.service;

import mx.tec.foodFinder.bean.User;
import mx.tec.foodFinder.util.MySQLConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService implements IUserService {
    private static UserService instance = null;
    private UserService(){}
    public static synchronized UserService getInstance(){
        if (instance == null) instance = new UserService();
        return instance;
    }

    @Override
    public User User_C(User user) {
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder","root","5th1ra5ukham45anam");
            String query = "CALL user_C(?,?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_name",user.getName());
            statement.setString("in_password",user.getPassword());
            ResultSet result = statement.executeQuery();

            if(result.next()){
                user.setIdUser(result.getInt("idUser"));
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
            return user;
        }
    }

    @Override
    public User User_V(User user) {
        try {
            Connection connection = MySQLConnection.getConnection("foodFinder", "root", "5th1ra5ukham45anam");
            String query = "CALL user_V(?,?)";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString("in_name", user.getName());
            statement.setString("in_password", user.getPassword());
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                user.setIdUser(result.getInt("idUser"));
            }
            //CLOSING
            result.close();
            statement.close();
            connection.close();
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(RecipeService.class.getName()).log(Level.SEVERE, null, ex);
            return user;
        }
    }
}
