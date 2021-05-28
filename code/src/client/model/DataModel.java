package client.model;

import client.Session;
import client.network.DataClient;
import shared.Branch.Branch;
import shared.PropertyChangeSubject;
import shared.Reservation.*;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Class used for passing & retrieving data between ViewModel and Client
 */
public class DataModel implements Model, PropertyChangeSubject {

    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private DataClient client;

    /**
     * public constructor
     * @param client DataClient instance that allows model to listen for updates
     */
    public DataModel(DataClient client) {
        this.client = client;
        client.addListener(this::receiveBranch, "branch");
        client.addListener(this::receiveCar, "car");
        client.addListener(this::receiveEmployee, "employee");
        client.addListener(this::receiveReservation, "reservation");
        client.addListener(this::receiveLogin, "login");
        client.addListener(this::receiveBranches, "branches");
        client.addListener(this::receiveCars, "cars");
        client.addListener(this::receiveEmployees, "employees");
        client.addListener(this::receiveReservations, "reservations");
        try {
            client.startClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override


    public void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) {
        try {
            client.createReservation(name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) {
        try {
            client.editReservation(id, name, surname, driversLicence, address, carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void receiveReservation(PropertyChangeEvent event) {
        support.firePropertyChange("reservation", null, event.getNewValue());

    }

    @Override
    public void receiveReservations(PropertyChangeEvent event) {

        support.firePropertyChange("reservations", null, event.getNewValue());

    }

    @Override
    public void receiveCars(PropertyChangeEvent event) {

        support.firePropertyChange("cars", null, event.getNewValue());

    }

    @Override
    public void receiveBranches(PropertyChangeEvent event) {
        support.firePropertyChange("branches", null, event.getNewValue());

    }

    @Override
    public void receiveEmployees(PropertyChangeEvent event) {
        support.firePropertyChange("employees", null, event.getNewValue());
    }


    @Override
    public void deleteReservation(int reservationId) {
        client.deleteReservation(reservationId);
    }

    @Override

    public void createEmployee(String name, String surname, int roleId, int branchId, String username, String password, String email) {
        client.createEmployee(name, surname, roleId, branchId, username, password, email);
    }

    @Override
    public void editEmployee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) {
        try {
            client.editEmployee(id, name, surname, roleId, branchId, username, password, email);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void receiveEmployee(PropertyChangeEvent event) {
        support.firePropertyChange("employee", null, event.getNewValue());
    }


    @Override
    public void deleteEmployee(int employeeId) {

        client.deleteEmployee(employeeId);
    }

    @Override
    public void createCar(String make, String carModel, String color, String numberPlates,
                          String fuelType, String fuelConsumption, String seats, String engine,
                          String transmission, String equipment, String description, int branchId, double dailyPrice) {
        client.createCar(make, carModel, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);

    }


    @Override
    public void editCar(int id, String make, String carModel, String color,
                        String numberPlates, String fuelType, String fuelConsumption,
                        String seats, String engine, String transmission, String equipment,
                        String description, int branchId, double dailyPrice) {
        try {
            client.editCar(id, make, carModel, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void receiveCar(PropertyChangeEvent event) {

        support.firePropertyChange("car", null, event.getNewValue());
    }


    @Override
    public void deleteCar(int carId) {
        client.deleteCar(carId);
    }

    @Override

    public void createBranch(String name, String location) {
        client.createBranch(name, location);

    }

    @Override
    public void editBranch(int id, String name, String location) {
        try {
            client.editBranch(id, name, location);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receiveBranch(PropertyChangeEvent event) {

        support.firePropertyChange("branch", null, event.getNewValue());
    }


    @Override
    public void deleteBranch(int branchId) {

        client.deleteBranch(branchId);
    }

    @Override
    public void login(String username, String password) {

        try {
            client.login(username, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void receiveLogin(PropertyChangeEvent event) {
        ArrayList<String> session = (ArrayList<String>) event.getNewValue();
        Session.setRole_id(Integer.parseInt(session.get(0)));
        Session.setUsername(session.get(1));
        support.firePropertyChange("login", null, event.getNewValue());
    }

    @Override
    public void getBranch(int id) {
        try {
            client.getBranch(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCar(int id) {
        try {
            client.getCar(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getEmployee(int id) {
        try {
            client.getEmployee(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getReservation(int id) {
        try {
            client.getReservation(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getReservations() {
        try {
            client.getReservations();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getBranches() {
        try {
            client.getBranches();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getCars() {
        try {
            client.getCars();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getEmployees() {
        try {
            client.getEmployees();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void register(Employee employee) {

    }

    @Override
    public void addListener(PropertyChangeListener listener, String name) {
        support.addPropertyChangeListener(name, listener);
    }
}
