package client.views.ReservationView;

import client.viewmodel.AddEditReservationViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shared.Reservation.Car;

import java.awt.event.ActionEvent;


/**
 * The Add reservation view controller.
 * @author Adam
 */
public class AddReservationViewController {

    private AddEditReservationViewModel addEditReservationViewModel;

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField surnameTextField;
    @FXML
    private TextField driversLicenceTextField;
    @FXML
    private TextField streetTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField zipTextField;
    @FXML
    private TextField countryTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private ComboBox<String> carComboBox;
    @FXML
    private ComboBox<String> startBranchComboBox;
    @FXML
    private ComboBox<String> endBranchComboBox;
    @FXML
    private DatePicker startDateDatePicker;
    @FXML
    private DatePicker endDateDatePicker;
    @FXML
    private Label messageLabel;

    /**
     * Init.
     *
     * @param addEditReservationViewModel the add edit reservation view model
     */
    public void init (AddEditReservationViewModel addEditReservationViewModel) {



        this.addEditReservationViewModel = addEditReservationViewModel;
        nameTextField.textProperty().bindBidirectional(addEditReservationViewModel.nameProperty());
        surnameTextField.textProperty().bindBidirectional(addEditReservationViewModel.surnameProperty());
        driversLicenceTextField.textProperty().bindBidirectional(addEditReservationViewModel.driversLicenceProperty());
        streetTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressStreetProperty());
        cityTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressCityProperty());
        zipTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressZipProperty());
        countryTextField.textProperty().bindBidirectional(addEditReservationViewModel.addressCountryProperty());
        priceTextField.textProperty().bindBidirectional(addEditReservationViewModel.priceProperty());
        emailTextField.textProperty().bindBidirectional(addEditReservationViewModel.emailProperty());
        phoneNumberTextField.textProperty().bindBidirectional(addEditReservationViewModel.phoneNumberProperty());
        carComboBox.valueProperty().bindBidirectional(addEditReservationViewModel.carProperty());
        startBranchComboBox.valueProperty().bindBidirectional(addEditReservationViewModel.startBranchProperty());
        endBranchComboBox.valueProperty().bindBidirectional(addEditReservationViewModel.endBranchProperty());
        startDateDatePicker.valueProperty().bindBidirectional(addEditReservationViewModel.startDateProperty());
        endDateDatePicker.valueProperty().bindBidirectional(addEditReservationViewModel.endDateProperty());
        messageLabel.textProperty().bindBidirectional(addEditReservationViewModel.messageProperty());
        startBranchComboBox.setItems(addEditReservationViewModel.getBranches());
        endBranchComboBox.setItems(addEditReservationViewModel.getBranches());
        carComboBox.setItems(addEditReservationViewModel.getCars());
    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        addEditReservationViewModel.cancelAction();
    }

    /**
     * Add action.
     */
    public void addAction() {
        addEditReservationViewModel.addAction();
    }

    public void calculateAction () {
        addEditReservationViewModel.calculatePrice();
    }



}
