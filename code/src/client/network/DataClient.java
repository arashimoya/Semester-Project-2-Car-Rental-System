package client.network;


import server.RMIServer.Server;
import shared.Branch.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Class used for passing & retrieving data between Model and Server
 * Client establishes connection to server
 *
 * @author Tymon, Oliver
 */
public class DataClient implements Client, PropertyChangeSubject {

    private Server server;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Public constructor
     *
     * @throws RemoteException if cannot export itself
     */

    public DataClient() throws RemoteException {
        UnicastRemoteObject.exportObject((Client) this, 0);

    }

    /**
     * Starts the client, lookups server in registry
     *
     * @throws RemoteException   if cannot establish connection
     * @throws NotBoundException if server was not found
     */
    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (Server) registry.lookup("server");
    }

    /**
     * Calls createReservation on Server with listed parameters and itself
     *
     * @param name           String
     * @param surname        String
     * @param driversLicence String
     * @param address        String
     * @param carId          int
     * @param startBranchId  int
     * @param endBranchId    int
     * @param startDate      Date
     * @param endDate        Date
     * @param price          String
     * @param email          String
     * @param phoneNumber    String
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException {
        server.createReservation(name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, (Client) this, price, email, phoneNumber);
    }

    /**
     * Calls getReservation on Server with given id and itself
     *
     * @param id id of car
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void getReservation(int id) throws RemoteException {
        server.getReservation(id, this);
    }

    /**
     * Notifies model of new Reservation
     *
     * @param reservation Reservation instance
     */
    @Override
    public void reservationCallback(Reservation reservation) {
        support.firePropertyChange("reservation", null, reservation);
    }

    /**
     * Calls editReservation on Server with listed parameters and itself
     *
     * @param name           String
     * @param surname        String
     * @param driversLicence String
     * @param address        String
     * @param carId          int
     * @param startBranchId  int
     * @param endBranchId    int
     * @param startDate      Date
     * @param endDate        Date
     * @param price          String
     * @param email          String
     * @param phoneNumber    String
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException {
        server.editReservation(id, name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber);
    }

    /**
     * Calls deleteReservation on Server
     *
     * @param reservationId id of reservation that is meant to be deleted
     */
    @Override
    public void deleteReservation(int reservationId) {
        try {
            server.deleteReservation(reservationId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls createEmployee method on Server with listed parameters
     *
     * @param name     String
     * @param surname  String
     * @param roleId   int, ID of role that employee has (2 for manager, 3 for employee)
     * @param branchId int, ID of branch that employee works for
     * @param username String
     * @param password String
     * @param email    String
     */
    public void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email) {
        try {
            server.createEmployee(name, surname, roleId, branchId, username, password, email);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getEmployee(int id) throws RemoteException {
        server.getEmployee(id, this);
    }

    /**
     * Calls edit Employee on Server with listed parameters
     *
     * @param id       int
     * @param name     String
     * @param surname  String
     * @param roleId   int
     * @param branchId int
     * @param username String
     * @param password String
     * @param email    String
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException {
        server.editEmployee(id, name, surname, roleId, branchId, username, password, email);
    }

    /**
     * Notifies model of new Employee
     *
     * @param employee Employee instance
     */
    @Override
    public void employeeCallback(Employee employee) {
        support.firePropertyChange("employee", null, employee);
    }

    /**
     * Calls deleteEmployee on Server
     *
     * @param employeeId id of Employee that is meant to be deleted
     */
    @Override
    public void deleteEmployee(int employeeId) {
        try {

            server.deleteEmployee(employeeId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    /**
     * Calls createCar method on Server with listed parameters
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

    public void createCar(String make, String carModel, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) {
        try {
            server.createCar(make, carModel, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls getCar on server
     *
     * @param id int
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void getCar(int id) throws RemoteException {
        server.getCar(id, this);
    }

    @Override
    /**
     * Calls editCar method on Server
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
     * @throws RemoteException if cannot establish connection
     */
    public void editCar(int id, String make, String carModel, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException {
        server.editCar(id, make, carModel, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);

    }

    /**
     * Notifies model of new Car
     *
     * @param car Car instance
     */
    @Override
    public void carCallback(Car car) {
        support.firePropertyChange("car", null, car);
    }

    /**
     * Calls deleteCar on Server with given id
     *
     * @param carId int
     */
    @Override
    public void deleteCar(int carId) {
        try {
            server.deleteCar(carId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls createBranch method on Server with listed parameters
     *
     * @param name     String
     * @param location String
     */
    @Override
    public void createBranch(String name, String location) {
        try {
            server.createBranch(name, location);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls getBranch on server with given id and itself
     *
     * @param id int
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void getBranch(int id) throws RemoteException {
        server.getBranch(id, this);
    }

    /**
     * Calls editBranch method on Server
     *
     * @param id       int
     * @param name     String
     * @param location String
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void editBranch(int id, String name, String location) throws RemoteException {
        server.editBranch(id, name, location);
    }

    /**
     * Notifies model of new Branch
     *
     * @param branch Branch instance
     */
    @Override
    public void branchCallback(Branch branch) {
        support.firePropertyChange("branch", null, branch);
    }

    /**
     * Calls deleteBranch on Server
     *
     * @param branchId given id of the branch
     */
    @Override
    public void deleteBranch(int branchId) {
        try {

            server.deleteBranch(branchId);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calls login method on Server with listed parameters and itself
     *
     * @param username String
     * @param password String
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void login(String username, String password) throws RemoteException {
        server.login(username, password, this);
    }

    /**
     * Notifies Model when login is approved
     *
     * @param session arraylist with id of employee role and username
     */
    @Override
    public void loginCallback(ArrayList<String> session) {
        support.firePropertyChange("login", null, session);
    }

    /**
     * Allows model to addListener so it can listen for notifications
     *
     * @param listener Reference to method that listens
     * @param name     String, name of method that listens
     */
    @Override
    public void addListener(PropertyChangeListener listener, String name) {
        support.addPropertyChangeListener(name, listener);
    }

    /**
     * Calls getReservations on Server with itself as argument
     *
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void getReservations() throws RemoteException {
        server.getReservations(this);
    }

    /**
     * Notifies model of new ArrayList<Reservation> that stores reservations
     *
     * @param reservations list of reservations
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void reservationsCallback(ArrayList<Reservation> reservations) throws RemoteException {
        support.firePropertyChange("reservations", null, reservations);
    }

    /**
     * Calls getBranches on Server with itself as argument
     *
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void getBranches() throws RemoteException {

        server.getBranches(this);
    }

    /**
     * Notifies model of new ArrayList<Branch> that stores branches
     *
     * @param branches list of branches
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void branchesCallback(ArrayList<Branch> branches) throws RemoteException {

        support.firePropertyChange("branches", null, branches);
    }

    /**
     * Calls getCars on Server with itself as argument
     *
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void getCars() throws RemoteException {

        server.getCars(this);
    }

    /**
     * Notifies model of new ArrayList<Car> that stores cars
     *
     * @param cars list of cars
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void carsCallback(ArrayList<Car> cars) throws RemoteException {

        support.firePropertyChange("cars", null, cars);
    }

    /**
     * Retrieves employees
     * @throws RemoteException if cannot establish collection
     */
    @Override
    public void getEmployees() throws RemoteException {
        server.getEmployees(this);
    }

    /**
     * Notifies model of new ArrayList<Employee> that stores employees
     *
     * @param employees list of employees
     * @throws RemoteException if cannot establish connection
     */
    @Override
    public void employeesCallback(ArrayList<Employee> employees) throws RemoteException {
        support.firePropertyChange("employees", null, employees);
    }

}
