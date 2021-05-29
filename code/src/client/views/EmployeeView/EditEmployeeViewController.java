package client.views.EmployeeView;

import client.Session;
import client.core.ViewHandler;
import client.viewmodel.RegistrationViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import shared.personel.Employee;

/**
 * The Edit employee view controller.
 * @author Oliver, Tymon
 */
public class EditEmployeeViewController {

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
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmPasswordTextField;
    @FXML
    private Label registrationLabelMessage;
    @FXML
    private TextField emailTextField;
    @FXML
    private Label idText;


    private RegistrationViewModel registrationViewModel;
    private ViewHandler viewHandler;

    /**
     * Init. Called from viewHandler to load the view
     *
     * @param registrationViewModel the registration view model
     * @param selectedEmployee      the selected employee
     */
    public void init(RegistrationViewModel registrationViewModel, Employee selectedEmployee) {

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

        idText.setText(String.valueOf(selectedEmployee.getId()));
        firstnameTextField.textProperty().set(selectedEmployee.getName());
        lastnameTextField.textProperty().set(selectedEmployee.getSurname());
        usernameTextField.textProperty().set(selectedEmployee.usernameProperty().get());
        emailTextField.textProperty().set(selectedEmployee.emailProperty().get());
        roleComboBox.valueProperty().setValue(String.valueOf(selectedEmployee.roleProperty().get()));
        branchComboBox.valueProperty().setValue(String.valueOf(selectedEmployee.getBranchId()));

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
     * On edit action.
     */
    public void onEditAction () {
        registrationViewModel.onEdit(Integer.parseInt(idText.getText()));
    }

    /**
     * Home.
     */
    public void home() {
        registrationViewModel.home();
    }
}
