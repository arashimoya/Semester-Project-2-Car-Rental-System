package client.network;

import shared.Branch.Branch;
import shared.Reservation.*;
import shared.personel.Employee;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;

public interface Client extends Remote {

    void startClient() throws RemoteException, NotBoundException;

    void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException;

    void getReservation(int id) throws RemoteException;

    void reservationCallback(Reservation reservation) throws RemoteException;

    void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) throws RemoteException;

    void deleteReservation(int reservationId) throws RemoteException;

    void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException;

    void getEmployee(int id) throws RemoteException;

    void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) throws RemoteException;

    void employeeCallback(Employee employee) throws RemoteException;

    void deleteEmployee(int employeeId) throws RemoteException;

    void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    void getCar(int id) throws RemoteException;

    void editCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) throws RemoteException;

    void carCallback(Car car) throws RemoteException;

    void deleteCar(int carId) throws RemoteException;

    void createBranch(String name, String location) throws RemoteException;

    void getBranch(int id) throws RemoteException;

    void editBranch(int id, String name, String location) throws RemoteException;

    void branchCallback(Branch branch) throws RemoteException;

    void deleteBranch(int branchId) throws RemoteException;

    void login(String username, String password) throws RemoteException;

    void loginCallback(ArrayList<String> session) throws RemoteException;

    void getReservations() throws RemoteException;

    void reservationsCallback(ArrayList<Reservation> reservations) throws RemoteException;

    void getBranches() throws RemoteException;

    void branchesCallback(ArrayList<Branch> branches) throws RemoteException;

    void getCars() throws RemoteException;

    void carsCallback(ArrayList<Car> cars) throws RemoteException;

    void employeesCallback(ArrayList<Employee> employees) throws RemoteException;

    void getEmployees() throws RemoteException;




}
