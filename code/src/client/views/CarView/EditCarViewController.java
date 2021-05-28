package client.views.CarView;

import client.viewmodel.AddEditCarViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import shared.Reservation.Car;

/**
 * The Edit car view controller.
 * @author Oliver
 */
public class EditCarViewController {



    private AddEditCarViewModel addEditCarViewModel;


    @FXML
    private TextField makeTextField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField colorTextField;
    @FXML
    private TextField numberPlatesTextField;
    @FXML
    private TextField fuelTypeTextField;
    @FXML
    private TextField fuelConsumptionTextField;
    @FXML
    private TextField seatsTextField;
    @FXML
    private TextField engineTextField;
    @FXML
    private TextField transmissionTextField;
    @FXML
    private TextField equipmentTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField dailyPriceTextField;
    @FXML
    private ComboBox<String> branchComboBox;
    @FXML
    private Label messageLabel;
    @FXML
    private Text idText;

    /**
     * Init.
     *
     * @param addEditCarViewModel the add edit car view model
     * @param selectedCar         the selected car
     */
    public void init (AddEditCarViewModel addEditCarViewModel, Car selectedCar) {

        branchComboBox.setItems(addEditCarViewModel.getBranches());

        this.addEditCarViewModel = addEditCarViewModel;
        makeTextField.textProperty().bindBidirectional(addEditCarViewModel.makeProperty());
        modelTextField.textProperty().bindBidirectional(addEditCarViewModel.carModelProperty());
        colorTextField.textProperty().bindBidirectional(addEditCarViewModel.colorProperty());
        numberPlatesTextField.textProperty().bindBidirectional(addEditCarViewModel.numberPlatesProperty());
        fuelTypeTextField.textProperty().bindBidirectional(addEditCarViewModel.fuelTypeProperty());
        fuelConsumptionTextField.textProperty().bindBidirectional(addEditCarViewModel.fuelConsumptionProperty());
        seatsTextField.textProperty().bindBidirectional(addEditCarViewModel.seatsProperty());
        engineTextField.textProperty().bindBidirectional(addEditCarViewModel.engineProperty());
        transmissionTextField.textProperty().bindBidirectional(addEditCarViewModel.transmissionProperty());
        equipmentTextField.textProperty().bindBidirectional(addEditCarViewModel.equipmentProperty());
        descriptionTextField.textProperty().bindBidirectional(addEditCarViewModel.descriptionProperty());
        dailyPriceTextField.textProperty().bindBidirectional(addEditCarViewModel.dailyPriceProperty());
        branchComboBox.valueProperty().bindBidirectional(addEditCarViewModel.branchProperty());
        messageLabel.textProperty().bindBidirectional(addEditCarViewModel.messageProperty());

        idText.setText(String.valueOf(selectedCar.getId()));
        makeTextField.textProperty().set(selectedCar.getMake());
        modelTextField.textProperty().set(selectedCar.getModel());
        colorTextField.textProperty().set(selectedCar.getColor());
        numberPlatesTextField.textProperty().set(selectedCar.getNumberPlates());
        fuelTypeTextField.textProperty().set(selectedCar.getFuelType());
        fuelConsumptionTextField.textProperty().set(selectedCar.getFuelConsumption());
        seatsTextField.textProperty().set(selectedCar.getSeats());
        engineTextField.textProperty().set(selectedCar.getEngine());
        transmissionTextField.textProperty().set(selectedCar.getTransmission());
        equipmentTextField.textProperty().set(selectedCar.getEquipment());
        descriptionTextField.textProperty().set(selectedCar.getDescription());
        dailyPriceTextField.textProperty().set(String.valueOf(selectedCar.getDailyPrice()));
        branchComboBox.valueProperty().setValue(String.valueOf(selectedCar.getBranchId()));

    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        addEditCarViewModel.cancelAction();
    }

    /**
     * Edit action.
     */
    public void editAction () {
        addEditCarViewModel.editAction(Integer.parseInt(idText.getText()));
    }


}
