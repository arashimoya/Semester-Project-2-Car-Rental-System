package client.views.BranchView;

import client.viewmodel.BranchViewModel;
import client.viewmodel.ReservationViewModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.Branch.Branch;

import java.beans.PropertyChangeEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The  Branch view controller.
 * @author Oliver, Tymon
 */
public class BranchViewController {
    @FXML
    private Label messageLabel;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    TableView<Branch> tableView;
    @FXML
    TableColumn<Branch, Number> idCol;
    @FXML
    TableColumn<Branch, String> idName;
    @FXML
    TableColumn<Branch, String> idLocation;
    BranchViewModel branchViewModel;

    /**
     * Init. Called from viewHandler to load the view
     *
     * @param branchViewModel the branch view model
     */
    public void init(BranchViewModel branchViewModel) {
        this.branchViewModel = branchViewModel;
        tableView.getItems().clear();
        idName.setCellValueFactory(cellData -> (cellData.getValue().nameProperty()));
        idCol.setCellValueFactory(cellData -> (cellData.getValue().idProperty()));
        idLocation.setCellValueFactory(cellData -> (cellData.getValue().locationProperty()));
        tableView.setItems(branchViewModel.getBranches());
        messageLabel.textProperty().bindBidirectional(branchViewModel.messageProperty());
    }


    /**
     * Open add view.
     *
     * @param actionEvent the action event
     */
    public void openAddView(ActionEvent actionEvent) {
        branchViewModel.getAddBranchView();
    }

    /**
     * Delete action.
     */
    public void deleteAction () {
        if (tableView.getSelectionModel().getSelectedItems().get(0) != null) {
            branchViewModel.deleteAction(tableView.getSelectionModel().getSelectedItems().get(0).getId());
        }

    }

    /**
     * Open edit view.
     *
     * @param actionEvent the action event
     */
    public void openEditView(ActionEvent actionEvent) {
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            Branch selectedBranch = tableView.getSelectionModel().getSelectedItems().get(0);
            branchViewModel.openEditView(selectedBranch);
        }
    }

    /**
     * Go back.
     *
     * @param actionEvent the action event
     */
    public void goBack(ActionEvent actionEvent) {
        branchViewModel.home();
    }


}
