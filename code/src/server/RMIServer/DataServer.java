package server.RMIServer;

import client.exceptions.AlreadyExists;
import client.exceptions.DoesNotExist;
import client.model.Model;
import client.network.Client;
import server.database.BranchHandler;
import server.database.CarHandler;
import server.database.EmployeeHandler;
import server.database.ReservationHandler;
import shared.Branch.Branch;
import shared.Reservation.*;
import shared.personel.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;

/**
 * The type Data server.
 */
public class DataServer implements Server {

    private CarHandler carHandler = new CarHandler();
    private EmployeeHandler employeeHandler = new EmployeeHandler();
    private ReservationHandler reservationHandler = new ReservationHandler();
    private BranchHandler branchHandler = new BranchHandler();


    /**
     * Instantiates a new Data server.
     *
     * @throws RemoteException the remote exception
     */
    public DataServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, Client client, double price, String email, String phoneNumber) throws RemoteException {

            reservationHandler.createReservation(name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber);
    }


    @Override
    public void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException {
        reservationHandler.editReservation(id, name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber);
    }


    @Override
    public void getReservation(int searchId, Client client) throws RemoteException {
        client.reservationCallback(reservationHandler.getReservation(searchId));
    }


    @Override
    public void deleteReservation(int reservationId) throws RemoteException {
        reservationHandler.deleteReservation(reservationId);
    }

    @Override
    public void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException {

            employeeHandler.createEmployee(name, surname, roleId, branchId, username, password, email);

    }

    @Override
    public void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException {
        employeeHandler.editEmployee(id, name, surname, roleId, branchId, username, password, email);
    }


    @Override
    public void getEmployee(int searchId, Client client) throws RemoteException {
        client.employeeCallback(employeeHandler.getEmployee(searchId));
    }

    @Override
    public void deleteEmployee(int employeeId) throws RemoteException {

        employeeHandler.deleteEmployee(employeeId);
    }


    public void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException {

            carHandler.createCar(make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);


    }

    @Override
    public void editCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException {
        carHandler.editCar(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);
    }


    @Override
    public void getCar(int searchId, Client client) throws RemoteException {
        client.carCallback(carHandler.getCar(searchId));
    }


    @Override
    public void deleteCar(int carId) throws RemoteException {
        carHandler.deleteCar(carId);
    }


    @Override
    public void createBranch(String name, String location) throws RemoteException {

            branchHandler.createBranch(name, location);

    }

    @Override
    public void getBranch(int id, Client client) throws RemoteException {
        client.branchCallback(branchHandler.getBranch(id));
    }

    @Override
    public void editBranch(int id, String name, String location) throws RemoteException {
        branchHandler.editBranch(id, name, location);
    }


    @Override
    public void deleteBranch(int branchId) throws RemoteException {

        branchHandler.deleteBranch(branchId);
    }

    @Override
    public void login(String username, String password, Client client) {
        try {
            client.loginCallback(employeeHandler.login(username, password));
        } catch (DoesNotExist | RemoteException doesNotExist) {
            doesNotExist.printStackTrace();
        }
    }

    @Override
    public void getReservations(Client client) throws RemoteException {
        client.reservationsCallback(reservationHandler.getReservations());
    }

    @Override
    public void getBranches(Client client) throws RemoteException {

        client.branchesCallback(branchHandler.getBranches());
    }

    @Override
    public void getCars(Client client) throws RemoteException {
        client.carsCallback(carHandler.getCars());
    }

    @Override
    public void getEmployees (Client client) throws RemoteException {
        client.employeesCallback(employeeHandler.getEmployees());
    }
}
