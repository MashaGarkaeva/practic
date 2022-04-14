package sample;

import java.sql.*;

public class dataBaseHandler extends config{
    Connection dbConnection;
    public Connection getDbConnection()                                                    //метод подключения к базе данных (записывать В
            throws ClassNotFoundException, SQLException {                                  // нее, что-то считывать С нее)
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }
    public ResultSet getUser(User user){
        ResultSet resSet = null;
        String select = "SELECT * FROM " + constants.PRACTIC_TABLE + " WHERE " +
                constants.PRACTIC_LOGIN + "=? AND " + constants.PRACTIC_PASSWORD + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, String.valueOf(user.getLogin()));
            prst.setString(2, String.valueOf(user.getPassword()));

            resSet = prst.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }

}