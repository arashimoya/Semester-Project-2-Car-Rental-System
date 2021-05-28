package client.views.ReservationView;


import client.viewmodel.ReservationViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.Reservation.Car;
import shared.Reservation.Reservation;


import java.io.IOException;

/**
 * The type Reservation view controller.
 * @author Dan
 */
public class ReservationViewController {
    @FXML
    private Button homeButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    /**
     * The Table view.
     */
    @FXML
    TableView<Reservation> tableView;
    @FXML
    private TableColumn<Reservation, Number> idCol;
    @FXML
    private TableColumn<Reservation, String> nameCol;
    @FXML
    private TableColumn<Reservation, String> surnameCol;
    @FXML
    private TableColumn<Reservation, String> driversLicenceCol;
    @FXML
    private TableColumn<Reservation, String> addressCol;
    @FXML
    private TableColumn<Reservation, Number> carCol;
    @FXML
    private TableColumn<Reservation, Number> startBranchCol;
    @FXML
    private TableColumn<Reservation, Number> endBranchCol;
    @FXML
    private TableColumn<Reservation, String> startDateCol;
    @FXML
    private TableColumn<Reservation, String> endDateCol;
    @FXML
    private TableColumn<Reservation, Number> priceCol;
    @FXML
    private TableColumn<Reservation, String> emailCol;
    @FXML
    private TableColumn<Reservation, String> phoneNumberCol;
    /**
     * The Reservation view model.
     */
    ReservationViewModel reservationViewModel;

    /**
     * Init. Called from viewHandler to load the view
     *
     * @param reservationViewModel the reservation view model
     */
    public void init(ReservationViewModel reservationViewModel) {
        tableView.getItems().clear();
        this.reservationViewModel = reservationViewModel;
        idCol.setCellValueFactory(cellData -> (cellData.getValue().idProperty()));
        nameCol.setCellValueFactory(cellData -> (cellData.getValue().nameProperty()));
        surnameCol.setCellValueFactory((cellData -> (cellData.getValue().surnameProperty())));
        driversLicenceCol.setCellValueFactory(cellData -> (cellData.getValue().driversLicenseProperty()));
        addressCol.setCellValueFactory(cellData -> (cellData.getValue().addressProperty()));
        startBranchCol.setCellValueFactory((cellData -> (cellData.getValue().startBranchProperty())));
        endBranchCol.setCellValueFactory(cellData -> (cellData.getValue().endBranchProperty()));
        startDateCol.setCellValueFactory(cellData -> (cellData.getValue().startDateProperty()));
        endDateCol.setCellValueFactory(cellData -> (cellData.getValue().endDateProperty()));
        priceCol.setCellValueFactory(cellData -> (cellData.getValue().priceProperty()));
        emailCol.setCellValueFactory(cellData -> (cellData.getValue().emailProperty()));
        phoneNumberCol.setCellValueFactory(cellData -> (cellData.getValue().phoneNumberProperty()));
        carCol.setCellValueFactory(cellData -> (cellData.getValue().carProperty()));
        tableView.setItems(reservationViewModel.getReservations());
    }


    /**
     * Delete action.
     *
     * @param actionEvent the action event
     */
    public void deleteAction(ActionEvent actionEvent) {
        if (tableView.getSelectionModel().getSelectedItems().get(0) != null)
        reservationViewModel.deleteAction(tableView.getSelectionModel().getSelectedItems().get(0).getId());
    }

    /**
     * Open edit view.
     *
     * @param actionEvent the action event
     */
    public void openEditView(ActionEvent actionEvent) {

        if (tableView.getSelectionModel().getSelectedItems().get(0) != null) {
            Reservation selectedReservation = tableView.getSelectionModel().getSelectedItems().get(0);
            reservationViewModel.openEditView(selectedReservation);
        }

    }

    /**
     * On add button.
     *
     * @param actionEvent the action event
     */
    public void onAddButton(ActionEvent actionEvent) {
        reservationViewModel.getAddReservationView();
    }

    /**
     * Home.
     *
     * @param actionEvent the action event
     */
    public void home(ActionEvent actionEvent) {
        reservationViewModel.home();
    }


}
