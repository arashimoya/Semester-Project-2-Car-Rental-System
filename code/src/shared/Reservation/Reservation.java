package shared.Reservation;

import javafx.beans.property.*;
import shared.Branch.Branch;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Adam
 * @version 2.0
 * class representing reservation
 * implements Serializable so it can be passed between
 * client and server
 */
public class Reservation implements Serializable {
    private int id;
    private String name;
    private String surname;
    private String driversLicence;
    private Address address;
    private int carId;
    private int startBranchId;
    private int endBranchId;
    private Date startDate;
    private Date endDate;
    private double price;
    private String email;
    private String phoneNumber;

    /**
     * public constructor
     * @param id int
     * @param name  String
     * @param surname String
     * @param driversLicence String
     * @param address String
     * @param carId int
     * @param startBranchId  int
     * @param endBranchId int
     * @param startDate int
     * @param endDate int
     * @param price double
     * @param email String
     * @param phoneNumber String
     */
    public Reservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, java.sql.Date startDate, Date endDate, double price, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.driversLicence = driversLicence;
        this.address = address;
        this.carId = carId;
        this.startBranchId = startBranchId;
        this.endBranchId = endBranchId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * gets name
     * @return name as String
     */
    public String getName() {
        return name;
    }
    /**
     * gets surname
     * @return surname as String
     */
    public String getSurname() {
        return surname;
    }
    /**
     * gets driversLicence
     * @return driversLicence as String
     */
    public String getDriversLicence() {
        return driversLicence;
    }
    /**
     * gets Address
     * @return address as Address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * gets carId
     * @return carId as int
     */
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }
    /**
     * gets StartBranchId
     * @return branchId as int
     */
    public int getStartBranchId() {
        return startBranchId;
    }

    public void setStartBranchId(int startBranchId) {
        this.startBranchId = startBranchId;
    }

    public void setEndBranchId(int endBranchId) {
        this.endBranchId = endBranchId;
    }

    /**
     * gets endBranchId
     * @return endBranchId as int
     */
    public int getEndBranchId() {
        return endBranchId;
    }

    /**
     * gets id
     * @return id as int
     */
    public int getId() {
        return id;
    }
    /**
     * gets price
     * @return price as Double
     */
    public double getPrice() {
        return price;
    }
    /**
     * gets email
     * @return email as String
     */
    public String getEmail() {
        return email;
    }
    /**
     * gets phoneNumber
     * @return phoneNumber as String
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDriversLicence(String driversLicence) {
        this.driversLicence = driversLicence;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets startDate
     * @return startDate as Date
     */
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * gets endDate
     * @return endDate as Date
     */
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * converts int id to IntegerProperty
     * @return id as IntegerProperty
     */
    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }
    /**
     * converts String name to StringProperty
     * @return name  as StringProperty
     */
    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }
    /**
     * converts String surname to StringProperty
     * @return surname as StringProperty
     */
    public StringProperty surnameProperty() {
        return new SimpleStringProperty(surname);
    }
    /**
     * converts String driversLicence to StringProperty
     * @return driversLicence as StringProperty
     */
    public StringProperty driversLicenseProperty() {
        return new SimpleStringProperty(driversLicence);
    }
    /**
     * converts Address address to StringProperty using .toString()
     * @return address as StringProperty
     */
    public StringProperty addressProperty() {
        return new SimpleStringProperty(address.toString());
    }
    /**
     * converts int car to IntegerProperty
     * @return car as IntegerProperty
     */
    public IntegerProperty carProperty() {
        return new SimpleIntegerProperty(carId);
    }
    /**
     * converts int startBranch to IntegerProperty
     * @return startBranch as IntegerProperty
     */
    public IntegerProperty startBranchProperty() {
        return new SimpleIntegerProperty(startBranchId);
    }
    /**
     * converts int endBranch to IntegerProperty
     * @return endBranch as IntegerProperty
     */
    public IntegerProperty endBranchProperty() {
        return new SimpleIntegerProperty(endBranchId);
    }
    /**
     * converts Date startDate to StringProperty using .toString()
     * @return startDate as StringProperty
     */
    public StringProperty startDateProperty() {
        return new SimpleStringProperty(startDate.toString());
    }

    /**
     * converts Date endDate to StringProperty using .toString()
     * @return endDate as StringProperty
     */
    public StringProperty endDateProperty() {
        return new SimpleStringProperty(endDate.toString());
    }
    /**
     * converts double price to DoubleProperty
     * @return price as DoubleProperty
     */
    public DoubleProperty priceProperty() {
        return new SimpleDoubleProperty(price);
    }
    /**
     * converts String email to StringProperty
     * @return email as StringProperty
     */
    public StringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }
    /**
     * converts String phoneNumber to StringProperty
     * @return phoneNumber as StringProperty
     */
    public StringProperty phoneNumberProperty() {
        return new SimpleStringProperty(phoneNumber);
    }
}

