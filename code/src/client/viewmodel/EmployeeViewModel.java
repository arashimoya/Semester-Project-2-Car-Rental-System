package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * ViewModel for displaying employee information
 * @author adam
 */
public class EmployeeViewModel {
    private final ViewHandler viewHandler;
    private Model model;
    private ObservableList<Employee> employees;


    /**
     * Instantiates a new Employee view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public EmployeeViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        model.addListener(this::listenForEmployees, "employees");
        employees = FXCollections.observableArrayList();
    }

    private void listenForEmployees(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            employees.clear();
            ArrayList<Employee> receivedEmployees = (ArrayList<Employee>) event.getNewValue();
            employees.addAll(receivedEmployees);
        });

    }

    /**
     * Home.
     */
    public void home() {
        viewHandler.openFrontPageView();
    }


    /**
     * Gets employees.
     *
     * @return the employees
     */
    public ObservableList<Employee> getEmployees() {
       return employees;
    }

    /**
     * Open registration view.
     */
    public void openRegistrationView () {
        viewHandler.openRegistrationView();
    }

    /**
     * Open edit view.
     *
     * @param selectedEmployee the selected employee
     */
    public void openEditView (Employee selectedEmployee) {
        viewHandler.openEmployeeEditView(selectedEmployee);
    }

    /**
     * Delete action.
     *
     * @param id the id
     */
    public void deleteAction (int id) {

        model.deleteEmployee(id);
        model.getEmployees();
    }
}
