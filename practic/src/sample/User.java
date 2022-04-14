package sample;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class User {
    public TextField Login;
    public PasswordField Password;

    public User(TextField login, PasswordField password){
        this.Login = login;
        this.Password = password;
    }

    public TextField getLogin() {
        return Login;
    }

    public void setLogin(TextField login) {
        Login = login;
    }

    public PasswordField getPassword() {
        return Password;
    }

    public void setPassword(PasswordField password) {
        Password = password;
    }

}
