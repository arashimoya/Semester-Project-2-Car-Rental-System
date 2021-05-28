package client.viewmodel;

import client.Session;
import client.core.ViewHandler;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * ViewModel for displaying home page of the app
 * @author Dan
 */
public class FrontPageViewModel {

    private ViewHandler viewHandler;
    private Model model;

    private StringProperty username;

    /**
     * Instantiates a new Front page view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public FrontPageViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        username = new SimpleStringProperty();
        username.set(Session.getUsername());
    }

    public StringProperty usernameProperty() {
        return username;
    }

    /**
     * Gets car view.
     */
    public void getCarView() {
        viewHandler.openCarView();
        model.getCars();

    }

    public void signOff () {
        Session.setRole_id(0);
        Session.setUsername(null);
        viewHandler.openLoginView();
    }

    /**
     * Gets reservation view.
     */
    public void getReservationView() {
        viewHandler.openReservationView();
        model.getReservations();
    }

    /**
     * Gets employee view.
     */
    public void getEmployeeView() {
        viewHandler.openEmployeeView();
        model.getEmployees();
    }

    /**
     * Gets branch view.
     */
    public void getBranchView() {
        viewHandler.openBranchView();
        model.getBranches();
    }

}
