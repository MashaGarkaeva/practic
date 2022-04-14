package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Random;

public class MessageCode {
    @FXML
    public TextField code;
    @FXML
    public void initialize(){
        String simCode = "qwertyuiopasdfghjkzxcvbnmQWERTYUOASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();
        char sim;
        String codee = "";
        int index;
        for (int i = 0; i < 8; i++){
            index = random.nextInt(simCode.length());
            sim = simCode.charAt(index);
            codee += sim;
        }
        code.setText(codee);
    }
}
