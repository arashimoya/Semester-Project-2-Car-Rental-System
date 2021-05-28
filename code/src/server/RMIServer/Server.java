package server.RMIServer;

import client.model.Model;
import client.network.Client;
import shared.Branch.Branch;
import shared.Reservation.*;
import shared.personel.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;

/**
 * The interface Server extends Remote for RMI connection.
 * @author tymon 
 */
public interface Server extends Remote {
    /**
     * Create reservation.
     *
     * @param name           the name
     * @param surname        the surname
     * @param driversLicence the drivers licence
     * @param address        the address
     * @param carId          the car id
     * @param startBranchId  the start branch id
     * @param endBranchId    the end branch id
     * @param startDate      the start date
     * @param endDate        the end date
     * @param client         the client
     * @param price          the price
     * @param email          the email
     * @param phoneNumber    the phone number
     * @throws RemoteException the remote exception
     */
    void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, Client client, double price, String email, String phoneNumber) throws RemoteException;

    /**
     * Edit reservation.
     *
     * @param id             the id
     * @param name           the name
     * @param surname        the surname
     * @param driversLicence the drivers licence
     * @param address        the address
     * @param carId          the car id
     * @param startBranchId  the start branch id
     * @param endBranchId    the end branch id
     * @param startDate      the start date
     * @param endDate        the end date
     * @param price          the price
     * @param email          the email
     * @param phoneNumber    the phone number
     * @throws RemoteException the remote exception
     */
    void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException;

    /**
     * Gets reservation.
     *
     * @param searchId the search id
     * @param client   the client
     * @throws RemoteException the remote exception
     */
    void getReservation(int searchId, Client client) throws RemoteException;

    /**
     * Delete reservation.
     *
     * @param reservationId the reservation id
     * @throws RemoteException the remote exception
     */
    void deleteReservation(int reservationId) throws RemoteException;

    /**
     * Create employee.
     *
     * @param name     the name
     * @param surname  the surname
     * @param roleId   the role id
     * @param branchId the branch id
     * @param username the username
     * @param password the password
     * @param email    the email
     * @throws RemoteException the remote exception
     */
    void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException;

    /**
     * Edit employee.
     *
     * @param id       the id
     * @param name     the name
     * @param surname  the surname
     * @param roleId   the role id
     * @param branchId the branch id
     * @param username the username
     * @param password the password
     * @param email    the email
     * @throws RemoteException the remote exception
     */
    void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException;

    /**
     * Gets employee.
     *
     * @param searchId the search id
     * @param client   the client
     * @throws RemoteException the remote exception
     */
    void getEmployee(int searchId, Client client) throws RemoteException;

    /**
     * Delete employee.
     *
     * @param employeeId the employee id
     * @throws RemoteException the remote exception
     */
    void deleteEmployee(int employeeId) throws RemoteException;

    /**
     * Create car.
     *
     * @param make            the make
     * @param model           the model
     * @param color           the color
     * @param numberPlates    the number plates
     * @param fuelType        the fuel type
     * @param fuelConsumption the fuel consumption
     * @param seats           the seats
     * @param engine          the engine
     * @param transmission    the transmission
     * @param equipment       the equipment
     * @param description     the description
     * @param branchId        the branch id
     * @param dailyPrice      the daily price
     * @throws RemoteException the remote exception
     */
    void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    /**
     * Edit car.
     *
     * @param id              the id
     * @param make            the make
     * @param model           the model
     * @param color           the color
     * @param numberPlates    the number plates
     * @param fuelType        the fuel type
     * @param fuelConsumption the fuel consumption
     * @param seats           the seats
     * @param engine          the engine
     * @param transmission    the transmission
     * @param equipment       the equipment
     * @param description     the description
     * @param branchId        the branch id
     * @param dailyPrice      the daily price
     * @throws RemoteException the remote exception
     */
    void editCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    /**
     * Gets car.
     *
     * @param searchId the search id
     * @param client   the client
     * @throws RemoteException the remote exception
     */
    void getCar(int searchId, Client client) throws RemoteException;

    /**
     * Delete car.
     *
     * @param carId the car id
     * @throws RemoteException the remote exception
     */
    void deleteCar(int carId) throws RemoteException;

    /**
     * Create branch.
     *
     * @param name     the name
     * @param location the location
     * @throws RemoteException the remote exception
     */
    void createBranch(String name, String location) throws RemoteException;

    /**
     * Gets branch.
     *
     * @param id     the id
     * @param client the client
     * @throws RemoteException the remote exception
     */
    void getBranch(int id, Client client) throws RemoteException;

    /**
     * Edit branch.
     *
     * @param id       the id
     * @param name     the name
     * @param location the location
     * @throws RemoteException the remote exception
     */
    void editBranch(int id, String name, String location) throws RemoteException;

    /**
     * Delete branch.
     *
     * @param branchId the branch id
     * @throws RemoteException the remote exception
     */
    void deleteBranch(int branchId) throws RemoteException;

    /**
     * Login from database handlers.
     *
     * @param username the username
     * @param password the password
     * @param client   the client
     * @throws RemoteException the remote exception
     */
    void login(String username, String password, Client client) throws RemoteException;

    /**
     * Gets reservations from database handlers.
     *
     * @param client the client
     * @throws RemoteException the remote exception
     */
    void getReservations(Client client) throws RemoteException;

    /**
     * Gets branches from database handlers.
     *
     * @param client the client
     * @throws RemoteException the remote exception
     */
    void getBranches(Client client) throws RemoteException;

    /**
     * Gets cars from database handlers.
     *
     * @param client the client
     * @throws RemoteException the remote exception
     */
    void getCars(Client client) throws RemoteException;

    /**
     * Gets employees  from database handlers.
     *
     * @param client the client
     * @throws RemoteException the remote exception
     */
    void getEmployees(Client client) throws RemoteException;
}
