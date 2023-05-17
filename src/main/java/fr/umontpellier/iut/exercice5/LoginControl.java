package fr.umontpellier.iut.exercice5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button okBtn;

    private void createBindings() {
        pwd.disableProperty().bind(userId.textProperty().length().lessThan(6));
        cancelBtn.disableProperty().bind(userId.textProperty().isEmpty());
        cancelBtn.disableProperty().bind(pwd.textProperty().isEmpty());
        okBtn.disableProperty().bind(pwd.textProperty().length().greaterThan(7));
        //desactive le btn ok tant que le mot de passe ne contient pas au moins une majuscule et un chiffre
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }

    public void initialize() {
        createBindings();
    }
}