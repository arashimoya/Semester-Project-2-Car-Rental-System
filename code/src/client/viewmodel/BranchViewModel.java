package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.Car;
import shared.Reservation.Reservation;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ViewModel for displaying branch information
 * @author Dan
 */
public class BranchViewModel {
    private Model model;
    private final ViewHandler viewHandler;
    private ObservableList<Branch> branches;

    /**
     * Instantiates a new Branch view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    private ArrayList<Car> cars;
    private ArrayList<Reservation> reservations;
    private ArrayList<Employee> employees;

    private StringProperty message;

    public BranchViewModel(Model model, ViewHandler viewHandler) {

        this.model = model;
        this.viewHandler = viewHandler;

        branches = FXCollections.observableArrayList();
        cars = new ArrayList<>();
        reservations = new ArrayList<>();
        employees = new ArrayList<>();



        model.addListener(this::listenForBranches, "branches");
        model.addListener(this::listenForCars, "cars");
        model.addListener(this::listenForEmployees, "employees");
        model.addListener(this::listenForReservations, "reservations");

        model.getBranches();
        model.getReservations();
        model.getCars();
        model.getEmployees();


        message = new SimpleStringProperty();

    }

    public StringProperty messageProperty () {
        return message;
    }

    private void listenForReservations(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            reservations = (ArrayList<Reservation>) propertyChangeEvent.getNewValue();
        });
    }

    private void listenForEmployees(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            employees = (ArrayList<Employee>) propertyChangeEvent.getNewValue();
        });
    }

    private void listenForCars(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            cars = (ArrayList<Car>) propertyChangeEvent.getNewValue();
        });
    }


    /**
     * Gets model.
     *
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * Home.
     */
    public void home() {
        viewHandler.openFrontPageView();
        message.set("");
    }

    /**
     * Listen for branches.
     *
     * @param event the event
     */
    public void listenForBranches(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            branches.clear();
            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) event.getNewValue();
            branches.addAll(receivedBranches);
        });
    }


    /**
     * Gets branches.
     *
     * @return the branches
     */
    public ObservableList<Branch> getBranches() {
        return branches;
    }

    /**
     * Gets add branch view.
     */
    public void getAddBranchView () {
        viewHandler.openAddBranchView();
        message.set("");
    }

    /**
     * Open edit view.
     *
     * @param selectedBranch the selected branch
     */
    public void openEditView (Branch selectedBranch) {
        viewHandler.openBranchEditView(selectedBranch);
        message.set("");
    }

    /**
     * Delete action.
     *
     * @param id the id
     */
    public void deleteAction (int id) {
        //TODO associate message property with a message in the GUI, i didnt do it right now because i didnt want to touch the views so there are no conflicts - OLIVER
        model.getReservations();
        model.getCars();
        model.getEmployees();
        boolean canDelete = true;
        boolean employeeAssociation = false;
        boolean carAssociation = false;
        boolean reservationAssociation = false;


        for (Employee employee : employees) {
            if (employee.getBranchId() == id) {
                employeeAssociation = true;
                canDelete = false;
            }
        }

        for (Car car : cars) {
            if (car.getBranchId() == id) {
                carAssociation = true;
                canDelete = false;
            }
        }

        for (Reservation reservation : reservations) {
            if (reservation.getStartBranchId() == id || reservation.getEndBranchId() == id){
                reservationAssociation = true;
                canDelete = false;
            }
        }

        if (canDelete) {
            model.deleteBranch(id);
            model.getBranches();
        } else {
            if (employeeAssociation)
                message.set("This branch cannot be deleted because there are employees associated with it");
            else if (carAssociation)
                message.set("This branch cannot be deleted because there are cars associated with it");
            else if (reservationAssociation)
                message.set("This branch cannot be deleted because there are reservations associated with it");
        }
    }

}
