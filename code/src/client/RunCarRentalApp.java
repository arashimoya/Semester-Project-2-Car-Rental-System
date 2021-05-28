package client;

import client.core.CarRentalApp;
import client.exceptions.AlreadyExists;
import client.views.ReservationView.ReservationViewController;
import javafx.application.Application;
import server.database.BranchHandler;
import server.database.CarHandler;
import server.database.EmployeeHandler;
import server.database.ReservationHandler;
import shared.Branch.Branch;
import shared.Reservation.Address;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Runs the app on the client side
 */
public class RunCarRentalApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws AlreadyExists the already exists
     */
    public static void main(String[] args) throws AlreadyExists {
        EmployeeHandler employeeHandler = new EmployeeHandler();
        BranchHandler branchHandler = new BranchHandler();
        CarHandler carHandler = new CarHandler();
        ReservationHandler reservationHandler = new ReservationHandler();

        employeeHandler.createEmployee("owner", "owner", 1, 6, "owner", "owner", "owner@gmail.com");
        LocalDate localDate;
        Application.launch(CarRentalApp.class);






        //NOT GUI
        //TODO finish javadocs
        //TODO write unit testing



        // methods to add to diagram :
        // AddEditBranchViewModel : private void listenForBranches(PropertyChangeEvent propertyChangeEvent), private void defaultFields(), private void reload()
        // AddEditCarViewModel : private void listenForCars (PropertyChangeEvent propertyChangeEvent), private void defaultFields(), private void reload()
        // AddEditReservationViewModel : private void listenForReservations (PropertyChangeEvent propertyChangeEvent), private void defaultFields(), private void reload(), public void calculatePrice()
        // RegistrationViewModel : private void listenForEmployees (PropertyChangeEvent propertyChangeEvent), private void reload()
        // RegistrationViewModel : defaultFields from public to private
        // Employee : public String getEmail()
        // Employee : public int getRoleId()
        // FrontPageViewController : public void signOff(ActionEvent actionEvent)
        // FrontPageViewModel : public void signOff()
        // BranchViewModel : public StringProperty messageProperty
        // CarViewModel : public StringProperty messageProperty
        // FrontPageViewModel : public StringProperty usernameProperty
        // editReservationViewController : public void calculateAction ()
        // addReservationViewController : public void calculateAction ()

        // fields to add to diagram :
        // AddEditBranchViewModel : private ArrayList<Branch> branches
        // AddEditCarViewModel : private ArrayList<Car> cars
        // AddEditReservationViewModel : private ArrayList<Reservation> reservations, private ArrayList<Car> receivedCars
        // RegisterViewModel : private ArrayList<Employee> employees
        // BranchViewModel : private ArrayList<Employee> employees, private ArrayList<Car> cars, private ArrayList<Reservation> reservations, private StringProperty message
        // CarViewModel : private ArrayList<Reservation> reservations, private StringProperty message;
        // FrontPageViewModel : private StringProperty username

        // other changes :
        // BranchHandler - createBranch doesnt throw already exists exception
        // EmployeeHandler - createEmployee doesnt throw already exists exception
        // ReservationHandler - createReservation doesnt throw already exists exception
        // CarHandler - createCar doesnt throw already exists exception

    }
}
