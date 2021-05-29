package client.views.BranchView;

import client.viewmodel.AddEditBranchViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


/**
 * The Add branch view controller.
 * @author Oliver, Tymon
 */
public class AddBranchViewController {

    private AddEditBranchViewModel addEditBranchViewModel;

    @FXML
    private javafx.scene.control.TextField nameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private Label messageLabel;


    /**
     * Init. Called from viewHandler to load the view
     *
     * @param addEditBranchViewModel the add edit branch view model
     */
    public void init (AddEditBranchViewModel addEditBranchViewModel) {
        this.addEditBranchViewModel = addEditBranchViewModel;
        nameTextField.textProperty().bindBidirectional(addEditBranchViewModel.nameProperty());
        locationTextField.textProperty().bindBidirectional(addEditBranchViewModel.locationProperty());
        messageLabel.textProperty().bindBidirectional(addEditBranchViewModel.messageProperty());
    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        addEditBranchViewModel.cancelAction();
    }

    /**
     * Add action.
     */
    public void addAction () {
        addEditBranchViewModel.addAction();
    }
}
