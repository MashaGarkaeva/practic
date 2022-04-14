package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Телеком");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/practic";
        String nameUser = "root";
        String passwordUser = "Yfcnzmasha1*";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, nameUser, passwordUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null){
            System.out.println("The database is connected");
        }
        else {
            System.out.println("The database is not connected");
        }
    }
}
