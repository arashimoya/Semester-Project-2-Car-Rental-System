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
 * @author Tymon, Oliver
 */
public class RunCarRentalApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws AlreadyExists the already exists
     */
    public static void main(String[] args) throws AlreadyExists {

        LocalDate localDate;
        Application.launch(CarRentalApp.class);


        
    }
}
