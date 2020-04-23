package DBmanager;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    public Database(){ }

    private Connection connection;


    public void addPerson(String name , int age) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/arsu", "root", "");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO arsu.chaikin(id , name , age , Date)"
                        + "VALUES(NULL  , ? , ? , ? ) ");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, age);
        Date date = new Date();
        preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    //////////////////////
    public void registration(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/arsu", "root", "");

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO arsu.registration(id , login , password , name)"
                        + "VALUES(NULL  , ? , ? , ? ) ");
        preparedStatement.setString(1, user.getLogin());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }
    ////////
    public boolean authorization(String login , String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/arsu", "root", "");

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT registration.login , registration.password FROM arsu.registration");
        while (resultSet.next()){
            String log = resultSet.getString(1);
            String pass = resultSet.getString(2);
            if(log.equals(login) && pass.equals(password)){
                return true ;
            }
        }
        return false ;
    }
    public ArrayList<String> getImageNegri() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/arsu", "root", "");
        ArrayList<String> arrayList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT  *FROM arsu.check");
        while (resultSet.next()){
            String desc = resultSet.getString(1);
            String url = resultSet.getString(2);
            arrayList.add(url);
        }
        return arrayList;
    }


}
