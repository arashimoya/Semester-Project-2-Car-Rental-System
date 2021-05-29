package shared.Reservation;

import javafx.beans.property.*;

import java.io.Serializable;

/**
 * @author Oliver, tymon
 * @version 1.0
 * stores Car information that are used in Reservation class
 * implements Serializable so it can be passed between
 * client and server
 */
public class Car implements Serializable {
    private int id;
    private String make;
    private String model;
    private String color;
    private String numberPlates;
    private String fuelType;
    private String fuelConsumption;
    private String seats;
    private String engine;
    private String transmission;
    private String equipment;
    private String description;
    private int branchId;
    private double dailyPrice;

    /**
     * public constructor
     *
     * @param id              int
     * @param make            String
     * @param model           String
     * @param color           String
     * @param numberPlates    String
     * @param fuelType        String
     * @param fuelConsumption String
     * @param seats           String
     * @param engine          String
     * @param transmission    String
     * @param equipment       String
     * @param description     String
     * @param branchId        String
     * @param dailyPrice      String
     */
    public Car(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.color = color;
        this.numberPlates = numberPlates;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.seats = seats;
        this.engine = engine;
        this.transmission = transmission;
        this.equipment = equipment;
        this.description = description;
        this.branchId = branchId;
        this.dailyPrice = dailyPrice;
    }


    /**
     * gets id
     *
     * @return id as int
     */
    public int getId() {
        return id;
    }

    /**
     * converts int id to IntegerProperty
     *
     * @return id as IntegerProperty
     */
    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    /**
     * sets id
     *
     * @param id int, new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets make
     *
     * @return make as String
     */
    public String getMake() {
        return make;
    }

    /**
     * converts String make to StringProperty
     *
     * @return make as StringProperty
     */
    public StringProperty makeProperty() {
        return new SimpleStringProperty(make);
    }

    /**
     * sets make
     *
     * @param make String, new make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * gets model
     *
     * @return model as String
     */
    public String getModel() {
        return model;
    }

    /**
     * converts String model to StringProperty
     *
     * @return model as StringProperty
     */
    public StringProperty modelProperty() {
        return new SimpleStringProperty(model);
    }

    /**
     * sets model
     *
     * @param model String, new model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * gets color
     *
     * @return color as String
     */
    public String getColor() {
        return color;
    }

    /**
     * converts String color to StringProperty
     *
     * @return color as StringProperty
     */
    public StringProperty colorProperty() {
        return new SimpleStringProperty(color);
    }

    /**
     * sets color
     *
     * @param color String, new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * gets numberPlates
     *
     * @return numberPlates as String
     */
    public String getNumberPlates() {
        return numberPlates;
    }

    /**
     * converts String numberPlates to StringProperty
     *
     * @return numberPlates as StringProperty
     */
    public StringProperty numberPlatesProperty() {
        return new SimpleStringProperty(numberPlates);
    }

    /**
     * sets numberPlates
     *
     * @param numberPlates String, new numberPlates
     */
    public void setNumberPlates(String numberPlates) {
        this.numberPlates = numberPlates;
    }

    /**
     * gets fuelType
     *
     * @return fuelType as String
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * converts String fuelType to StringProperty
     *
     * @return fuelType as StringProperty
     */
    public StringProperty fuelTypeProperty() {
        return new SimpleStringProperty(fuelType);
    }

    /**
     * gets fuelType
     *
     * @param fuelType String, new fuelType
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * gets fuelConsumption
     *
     * @return fuelConsumption as String
     */
    public String getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * converts String fuelConsumption to StringProperty
     *
     * @return fuelConsumption as StringProperty
     */
    public StringProperty fuelConsumptionProperty() {
        return new SimpleStringProperty(fuelConsumption);
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * gets seats
     *
     * @return seats as String
     */
    public String getSeats() {
        return seats;
    }

    /**
     * converts String seats to StringProperty
     *
     * @return seats as StringProperty
     */
    public StringProperty seatsProperty() {
        return new SimpleStringProperty(seats);
    }

    /**
     * sets seats
     *
     * @param seats String, new seats
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }

    /**
     * gets engine
     *
     * @return engine as String
     */
    public String getEngine() {
        return engine;
    }

    /**
     * converts String engine to StringProperty
     *
     * @return engine as StringProperty
     */
    public StringProperty engineProperty() {
        return new SimpleStringProperty(engine);
    }

    /**
     * sets engine
     *
     * @param engine String, new engine
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

    /**
     * gets transmission
     *
     * @return transmission as String
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * converts String transmission to StringProperty
     *
     * @return transmission as StringProperty
     */
    public StringProperty transmissionProperty() {
        return new SimpleStringProperty(transmission);
    }

    /**
     * sets transmission
     *
     * @param transmission String, new transmission
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * gets equipment
     *
     * @return equipment as String
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * converts String equipment to StringProperty
     *
     * @return equipment as StringProperty
     */
    public StringProperty equipmentProperty() {
        return new SimpleStringProperty(equipment);
    }

    /**
     * sets equipment
     *
     * @param equipment String, new equipment
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * gets description
     *
     * @return description as String
     */
    public String getDescription() {
        return description;
    }

    /**
     * converts String description to StringProperty
     *
     * @return description as StringProperty
     */
    public StringProperty descriptionProperty() {
        return new SimpleStringProperty(description);
    }

    /**
     * sets description
     *
     * @param description String, new description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gets branchId
     *
     * @return branchId as int
     */
    public int getBranchId() {
        return branchId;
    }

    /**
     * converts int branchId to IntegerProperty
     *
     * @return branchId as IntegerProperty
     */
    public IntegerProperty branchIdProperty() {
        return new SimpleIntegerProperty(branchId);
    }

    /**
     * gets dailyPrice
     *
     * @return dailyPrice as double
     */
    public double getDailyPrice() {
        return dailyPrice;
    }

    /**
     * converts double dailyPrice to DoubleProperty
     *
     * @return dailyPrice as DoubleProperty
     */
    public DoubleProperty dailyPriceProperty() {
        return new SimpleDoubleProperty(dailyPrice);
    }

    /**
     * @return all fields as a single String
     */
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", numberPlates='" + numberPlates + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                ", seats='" + seats + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", equipment='" + equipment + '\'' +
                ", description='" + description + '\'' +
                ", branchId=" + branchId +
                '}';
    }
}
