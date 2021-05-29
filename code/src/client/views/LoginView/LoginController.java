package client.views.LoginView;

import client.viewmodel.LoginViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

/**
 * The  Login controller.
 * @author Tymon, Oliver
 */
public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label loginResultMessage;

    private LoginViewModel loginVM;

    /**
     * Init. Called from viewHandler to load the view
     *
     * @param loginViewModel the login view model
     */
    public void init(LoginViewModel loginViewModel) {
        this.loginVM = loginViewModel;
        usernameField.textProperty().bindBidirectional(loginVM.usernameProperty());
        passwordField.textProperty().bindBidirectional(loginVM.passwordProperty());
        loginResultMessage.textProperty().bindBidirectional(loginVM.loginResponseProperty());

        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                loginViewModel.login();
            }
        });
    }

    /**
     * On login button.
     *
     * @param actionEvent the action event
     */
    public void onLoginButton(ActionEvent actionEvent) {
        loginVM.login();
    }
}
