package client.views.Registration;

import client.Session;
import client.core.ViewHandler;
import client.viewmodel.RegistrationViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * The type Registration view controller.
 * @author Dan
 */
public class RegistrationViewController {

    @FXML
    private ComboBox<String> roleComboBox;
    @FXML
    private ComboBox<String> branchComboBox;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private Label registrationLabelMessage;
    @FXML
    private TextField emailTextField;


    private RegistrationViewModel registrationViewModel;
    private ViewHandler viewHandler;

    /**
     * Init. Called from viewHandler to load the view
     *
     * @param registrationViewModel the registration view model
     */
    public void init(RegistrationViewModel registrationViewModel) {

        branchComboBox.setItems(registrationViewModel.getBranches());
        roleComboBox.setItems(registrationViewModel.getRoles());

        this.registrationViewModel = registrationViewModel;
        firstnameTextField.textProperty().bindBidirectional(registrationViewModel.firstnameProperty());
        lastnameTextField.textProperty().bindBidirectional(registrationViewModel.lastnameProperty());
        usernameTextField.textProperty().bindBidirectional(registrationViewModel.usernameProperty());
        passwordTextField.textProperty().bindBidirectional(registrationViewModel.passwordProperty());
        confirmPasswordTextField.textProperty().bindBidirectional(registrationViewModel.confirmPasswordProperty());
        registrationLabelMessage.textProperty().bindBidirectional(registrationViewModel.registrationMessageLabelProperty());
        roleComboBox.valueProperty().bindBidirectional(registrationViewModel.roleProperty());
        branchComboBox.valueProperty().bindBidirectional(registrationViewModel.branchProperty());
        emailTextField.textProperty().bindBidirectional(registrationViewModel.emailProperty());

    }

    /**
     * Close on action.
     *
     * @param actionEvent the action event
     */
    public void closeOnAction(ActionEvent actionEvent) {
        registrationViewModel.home();
    }

    /**
     * Register button on action.
     *
     * @param actionEvent the action event
     */
    public void registerButtonOnAction(ActionEvent actionEvent) {
        registrationViewModel.register();
    }

    /**
     * Home.
     */
    public void home() {
        registrationViewModel.home();
    }
}
