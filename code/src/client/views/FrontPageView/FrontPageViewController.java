package client.views.FrontPageView;

import client.Session;
import client.viewmodel.FrontPageViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * The Front page view controller.
 * @author adam
 */
public class FrontPageViewController {

    @FXML
    private Button openEmployeeButton;
    @FXML
    private Button openBranchesButton;
    @FXML
    private Button openCarsButton;
    @FXML
    private Label usernameLabel;

    private FrontPageViewModel frontPageViewModel;

    /**
     * Init. Called from viewHandler to load the view
     * Sets the visibility of buttons according to employee role
     *
     * @param frontPageViewModel the front page view model
     */
    public void init(FrontPageViewModel frontPageViewModel) {
        this.frontPageViewModel = frontPageViewModel;
        usernameLabel.textProperty().bindBidirectional(frontPageViewModel.usernameProperty());
        // Owner ID = 1, Manager ID = 2, Employee ID = 3
        if (Session.getRole_id() == 3) {
            openBranchesButton.setVisible(false);
            openEmployeeButton.setVisible(false);
            openCarsButton.setVisible(false);
        } else if (Session.getRole_id() == 2) {
            openBranchesButton.setVisible(false);
        }
    }

    /**
     * On cars button. Calls frontPageViewModel to set view to carView. Accessible to Manager and Owner
     *
     * @param actionEvent the action event
     */
    public void onCarsButton(ActionEvent actionEvent) {
        frontPageViewModel.getCarView();
    }

    public void signOff (ActionEvent actionEvent) {
        frontPageViewModel.signOff();
    }

    /**
     * On reservations button. Calls frontPageViewModel to set view to reservationView. Accessible to everyone
     *
     * @param actionEvent the action event
     */
    public void onReservationsButton(ActionEvent actionEvent) {
        frontPageViewModel.getReservationView();
    }

    /**
     * On employee button.Calls frontPageViewModel to set view to employeeView. Accessible to Manager and Owner
     *
     * @param actionEvent the action event
     */
    public void onEmployeeButton(ActionEvent actionEvent) {
        frontPageViewModel.getEmployeeView();
    }

    /**
     * On branches button. Calls frontPageViewModel to set view to branchesView. Accessible to Owner only
     *
     * @param actionEvent the action event
     */
    public void onBranchesButton(ActionEvent actionEvent) {
        frontPageViewModel.getBranchView();
    }
}
