package client.views.CarView;

import client.viewmodel.AddEditCarViewModel;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The type Add car view controller.
 * @author Adam
 */
public class AddCarViewController {

    private AddEditCarViewModel addEditCarViewModel;

    /**
     * Init. Called from viewHandler to load the view
     *
     * @param addEditCarViewModel the add edit car view model
     */
    public void init (AddEditCarViewModel addEditCarViewModel) {

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
    }

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

    /**
     * Cancel action.
     */
    public void cancelAction () {
        addEditCarViewModel.cancelAction();
    }

    /**
     * Add action.
     */
    public void addAction () {
        addEditCarViewModel.addAction();
    }


}
