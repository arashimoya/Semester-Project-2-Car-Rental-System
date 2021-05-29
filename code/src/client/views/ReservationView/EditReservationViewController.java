package client.views.ReservationView;

//import client.viewmodel.AddEditReservationViewModel;

import client.viewmodel.AddEditReservationViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import shared.Reservation.Reservation;


/**
 * The Edit reservation view controller.
 * @author Tymon, Oliver
 */
public class EditReservationViewController {

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
    @FXML
    private Text idText;

    /**
     * Init.
     *
     * @param addEditReservationViewModel the add edit reservation view model
     * @param selectedReservation         the selected reservation
     */
    public void init (AddEditReservationViewModel addEditReservationViewModel, Reservation selectedReservation) {

        carComboBox.setItems(addEditReservationViewModel.getCars());
        startBranchComboBox.setItems(addEditReservationViewModel.getBranches());
        endBranchComboBox.setItems(addEditReservationViewModel.getBranches());

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
        nameTextField.textProperty().set(selectedReservation.getName());
        surnameTextField.textProperty().set(selectedReservation.getSurname());
        driversLicenceTextField.textProperty().set(selectedReservation.getDriversLicence());
        streetTextField.textProperty().set(selectedReservation.getAddress().getStreet());
        cityTextField.textProperty().set(selectedReservation.getAddress().getCity());
        zipTextField.textProperty().set(selectedReservation.getAddress().getZip());
        countryTextField.textProperty().set(selectedReservation.getAddress().getCountry());
        priceTextField.textProperty().set(String.valueOf(selectedReservation.getPrice()));
        emailTextField.textProperty().set(selectedReservation.getEmail());
        carComboBox.setValue(String.valueOf(selectedReservation.getCarId()));
        phoneNumberTextField.textProperty().set(selectedReservation.getPhoneNumber());
        startBranchComboBox.setValue(String.valueOf(selectedReservation.getStartBranchId()));
        endBranchComboBox.setValue(String.valueOf(selectedReservation.getEndBranchId()));
        startDateDatePicker.setValue(selectedReservation.getStartDate().toLocalDate());
        endDateDatePicker.setValue(selectedReservation.getEndDate().toLocalDate());
        idText.setText(String.valueOf(selectedReservation.getId()));
        messageLabel.textProperty().bindBidirectional(addEditReservationViewModel.messageProperty());
    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        addEditReservationViewModel.cancelAction();
    }

    /**
     * Edit action.
     */
    public void editAction() {
        addEditReservationViewModel.editAction(Integer.parseInt(idText.getText()));
    }

    /**
     * on calculate press
     */
    public void calculateAction () {
        addEditReservationViewModel.calculatePrice();
    }





}
