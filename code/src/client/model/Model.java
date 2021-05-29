package client.model;

import shared.Branch.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import java.util.ArrayList;


/**
 * Interface used for datamodel
 * @author Tymon, Oliver
 */

public interface Model extends PropertyChangeSubject {


    /**
     * Calls createReservation on Client with listed parameters
     * @param name String
     * @param surname  String
     * @param driversLicence String
     * @param address String
     * @param carId  int
     * @param startBranchId int
     * @param endBranchId int
     * @param startDate Date
     * @param endDate Date
     * @param price String
     * @param email String
     * @param phoneNumber String
     */
    void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber);
    /**
     * Calls editReservation on Client with listed parameters
     * @param name String
     * @param surname  String
     * @param driversLicence String
     * @param address String
     * @param carId  int
     * @param startBranchId int
     * @param endBranchId int
     * @param startDate Date
     * @param endDate Date
     * @param price String
     * @param email String
     * @param phoneNumber String
     */
    void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber);

    /**
     * Listens for single reservation from Client
     * @param event stores Reservation Object
     */
    void receiveReservation(PropertyChangeEvent event);

    /**
     * Listens for ArrayList<Reservation> from Client
     * @param event stores list of reservations
     */
    void receiveReservations(PropertyChangeEvent event);
    /**
     * Listens for ArrayList<Cars> from Client
     * @param event stores list of cars
     */
    void receiveCars(PropertyChangeEvent event);
    /**
     * Listens for ArrayList<Branches> from Client
     * @param event stores list of branches
     */
    void receiveBranches(PropertyChangeEvent event);
    /**
     * Listens for ArrayList<Employees> from Client
     * @param event stores list of employees
     */
    void receiveEmployees(PropertyChangeEvent event);

    /**
     * Calls deleteReservation on Client
     * @param reservationId id of reservation that is meant to be deleted
     */
    void deleteReservation(int reservationId);

    /**
     * Calls createEmployee method on Client
     * @param name  String
     * @param surname String
     * @param roleId int, ID of role that employee has (2 for manager, 3 for employee)
     * @param branchId int, ID of branch that employee works for
     * @param username String
     * @param password String
     * @param email String
     */
    void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email);

    /**
     * Calls editEmployee method on Client
     * @param name  String
     * @param surname String
     * @param roleId int, ID of role that employee has (2 for manager, 3 for employee)
     * @param branchId int, ID of branch that employee works for
     * @param username String
     * @param password String
     * @param email String
     */
    void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email);

    /**
     * Listens for Employee from Client
     * @param event stores Employee Object
     */
    void receiveEmployee(PropertyChangeEvent event);

    /**
     * Calls deleteEmployee method on client with given id
     * @param employeeId id of employee that is meant to be deleted
     */
    void deleteEmployee(int employeeId);

    /**
     * Calls createCar method on Client
     * @param make  String
     * @param carModel String
     * @param color String
     * @param numberPlates String
     * @param fuelType String
     * @param fuelConsumption String
     * @param seats String
     * @param engine String
     * @param transmission String
     * @param equipment String
     * @param description String
     * @param branchId  int
     * @param dailyPrice double
     */
    void createCar(String make, String carModel, String color, String numberPlates, String fuelType,
                   String fuelConsumption, String seats, String engine, String transmission, String equipment,
                   String description, int branchId, double dailyPrice);
    /**
     * Calls editCar method on Client
     * @param make  String
     * @param carModel String
     * @param color String
     * @param numberPlates String
     * @param fuelType String
     * @param fuelConsumption String
     * @param seats String
     * @param engine String
     * @param transmission String
     * @param equipment String
     * @param description String
     * @param branchId  int
     * @param dailyPrice double
     */
    void editCar(int id, String make, String carModel, String color, String numberPlates, String fuelType,
                 String fuelConsumption, String seats, String engine, String transmission, String equipment,
                 String description, int branchId, double dailyPrice);

    /**
     * Listens for car from Client
     * @param event stores CarObject
     */
    void receiveCar(PropertyChangeEvent event);

    /**
     * Calls deleteCar with given id on Client
     * @param carId car that is meant to be deleted
     */
    void deleteCar(int carId);

    /**
     * Calls createBranch method on Client
     * @param name String
     * @param location String
     */
    void createBranch(String name, String location);
    /**
     * Calls editBranch method on Client
     * @param id  int
     * @param name String
     * @param location String
     */
    void editBranch(int id, String name, String location);

    /**
     * Listens for branch from Client
     * @param event stores Branch Object
     */
    void receiveBranch(PropertyChangeEvent event);

    /**
     * Calls deleteBranch method on Client
     * @param branchId for branch that is meant to be deleted
     */
    void deleteBranch(int branchId);

    /**
     * Calls method login on Client
     * @param username String
     * @param password String
     */
    void login(String username, String password);

    /**
     * Listens for login verification and role from Client
     * @param event stores role id
     */
    void receiveLogin(PropertyChangeEvent event);

    /**
     * Retrieves a branch
     * @param id the id of the branch to be retrieved
     */
    void getBranch(int id);

    /**
     * Retrieves a car
     * @param id the id of the car to be retrieved
     */
    void getCar(int id);

    /**
     * Retrieves an employee
     * @param id the id of the employee to be retrieved
     */
    void getEmployee(int id);

    /**
     * Retrieves a reservation
     * @param id the id of the reservation to be retrieved
     */
    void getReservation(int id);

    /**
     * Calls getReservations on client, gets all reservations
     */
    void getReservations();

    /**
     * Calls getBranches on client, gets all Branches
     */
    void getBranches();

    /**
     * Calls getCars on client, gets all cars
     */
    void getCars();

    /**
     * Calls getEmployees on client, gets all employees
     */
    void getEmployees();

    /**
     * Registers a new employee
     * @param employee the employee to be registered
     */

    void register(Employee employee);

}
