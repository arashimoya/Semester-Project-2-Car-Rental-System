package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

/**
 * ViewModel for logging in
 */
public class LoginViewModel {

    private Model model;
    private StringProperty username, password, loginResponse;
    private PropertyChangeListener listener;
    private ViewHandler viewHandler;


    /**
     * Instantiates a new Login view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public LoginViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        loginResponse = new SimpleStringProperty();
        model.addListener(this::loggedIn, "login");
        this.viewHandler = viewHandler;
    }

    /**
     * Logged in.
     *
     * @param event the event
     */
    public void loggedIn(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            ArrayList<String> session = (ArrayList<String>) event.getNewValue();
            int role_id = Integer.parseInt(session.get(0));
            if (role_id == 0) {
                loginResponse.setValue("Incorrect information");
            } else {
                username.set("");
                password.set("");
                viewHandler.openFrontPageView();
            }
        });


    }

    /**
     * Username property string property.
     *
     * @return the string property
     */
    public StringProperty usernameProperty() {
        return username;
    }

    /**
     * Password property string property.
     *
     * @return the string property
     */
    public StringProperty passwordProperty() {
        return password;
    }

    /**
     * Login response property string property.
     *
     * @return the string property
     */
    public StringProperty loginResponseProperty() {
        return loginResponse;
    }

    /**
     * Login.
     */
    public void login() {
        model.login(username.get(), password.get());
    }

    /**
     * Open front page view.
     */
    public void openFrontPageView() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../client/views/LoginView/Login.fxml"));

    }
}
