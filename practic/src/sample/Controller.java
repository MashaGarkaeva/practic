package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller extends MessageCode{
    @FXML
    public Label error;
    @FXML
    public TextField login;
    @FXML
    public PasswordField password;
    @FXML
    public TextField code;
    @FXML
    public Button update;
    @FXML
    public Button exit;
    @FXML
    public Button enter;
    @FXML
    public void initialize(){
        enter.setOnAction(event -> {
            String nomer = login.getText().trim();
            String pass = password.getText().trim();
            String codene = code.getText().trim();
            if (!nomer.equals("") && !pass.equals("") && !codene.equals("")){
                loginUser(nomer, pass);
            } else {
                error.setText("Поля не заполнены");
            }
        });

        update.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("messageCode.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String nomer, String pass) {
        dataBaseHandler dbHandler = new dataBaseHandler();
        User user = new User(login, password);
        user.setLogin(login);
        user.setPassword(password);
        ResultSet resultSet = dbHandler.getUser(user);

        int count = 0;
        try {
            while (resultSet.next()){
                count++;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        if ((count>=1)) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("userScreen.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
        if (count==0) {
            error.setText("Неверные данные, либо такого пользователя нет в системе");
        }
        else {
            error.setText("Успешно");
        }
    }
}
