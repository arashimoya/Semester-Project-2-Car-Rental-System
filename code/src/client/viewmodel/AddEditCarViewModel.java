package client.viewmodel;

import client.core.ViewHandler;
import client.exceptions.AlreadyExists;
import client.model.Model;
import javafx.application.Platform;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.Reservation.Car;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ViewModel for adding and editing the car
 * @author Tymon
 */
public class AddEditCarViewModel {


    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;
    private ObservableList<String> branches;
    private ArrayList<Car> cars;


    private StringProperty make;
    private StringProperty carModel;
    private StringProperty color;
    private StringProperty numberPlates;
    private StringProperty fuelType;
    private StringProperty fuelConsumption;
    private StringProperty seats;
    private StringProperty engine;
    private StringProperty transmission;
    private StringProperty equipment;
    private StringProperty description;
    private StringProperty dailyPrice;
    private StringProperty branch;
    private StringProperty message;


    /**
     * Instantiates a new Add edit car view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public AddEditCarViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        this.viewHandler = viewHandler;
        this.support = new PropertyChangeSupport(this);
        cars = new ArrayList<>();
        model.addListener(this::listenForBranches, "branches");
        model.addListener(this::listenForCars, "cars");
        model.getBranches();
        model.getCars();
        branches = FXCollections.observableArrayList();
        make = new SimpleStringProperty();
        carModel = new SimpleStringProperty();
        color = new SimpleStringProperty();
        numberPlates = new SimpleStringProperty();
        fuelType = new SimpleStringProperty();
        fuelConsumption = new SimpleStringProperty();
        seats = new SimpleStringProperty();
        engine = new SimpleStringProperty();
        transmission = new SimpleStringProperty();
        equipment = new SimpleStringProperty();
        description = new SimpleStringProperty();
        dailyPrice = new SimpleStringProperty();

        branch = new SimpleStringProperty();
        message = new SimpleStringProperty();
    }

    private void listenForCars(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            cars = (ArrayList<Car>) propertyChangeEvent.getNewValue();
        });
    }

    private void listenForBranches(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            branches.clear();
            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) propertyChangeEvent.getNewValue();
            ArrayList<String> receivedBranchNumbers = new ArrayList<>();
            for (Branch receivedBranch : receivedBranches) {
                receivedBranchNumbers.add(String.valueOf(receivedBranch.getId()));
            }
            branches.addAll(receivedBranchNumbers);

        });
    }

    /**
     * Gets branches.
     *
     * @return the branches
     */
    public ObservableList<String> getBranches() {
        return branches;

    }

    /**
     * Make property string property.
     *
     * @return the string property
     */
    public StringProperty makeProperty() {
        return make;
    }


    /**
     * Car model property string property.
     *
     * @return the string property
     */
    public StringProperty carModelProperty() {
        return carModel;
    }


    /**
     * Color property string property.
     *
     * @return the string property
     */
    public StringProperty colorProperty() {
        return color;
    }


    /**
     * Number plates property string property.
     *
     * @return the string property
     */
    public StringProperty numberPlatesProperty () {
        return numberPlates;
    }


    /**
     * Fuel type property string property.
     *
     * @return the string property
     */
    public StringProperty fuelTypeProperty() {
        return fuelType;
    }


    /**
     * Fuel consumption property string property.
     *
     * @return the string property
     */
    public StringProperty fuelConsumptionProperty() {
        return fuelConsumption;
    }


    /**
     * Seats property string property.
     *
     * @return the string property
     */
    public StringProperty seatsProperty() {
        return seats;
    }


    /**
     * Engine property string property.
     *
     * @return the string property
     */
    public StringProperty engineProperty() {
        return engine;
    }


    /**
     * Transmission property string property.
     *
     * @return the string property
     */
    public StringProperty transmissionProperty() {
        return transmission;
    }


    /**
     * Equipment property string property.
     *
     * @return the string property
     */
    public StringProperty equipmentProperty() {
        return equipment;
    }


    /**
     * Description property string property.
     *
     * @return the string property
     */
    public StringProperty descriptionProperty () {
        return description;
    }

    /**
     * Daily price property string property.
     *
     * @return the string property
     */
    public StringProperty dailyPriceProperty () {
        return dailyPrice;
    }

    /**
     * Branch property string property.
     *
     * @return the string property
     */
    public StringProperty branchProperty () {
        return branch;
    }

    /**
     * Message property string property.
     *
     * @return the string property
     */
    public StringProperty messageProperty () {
        return message;
    }


    private boolean inputVerification () {

        String decimalNumbers = "[1-9]\\d*(\\.\\d+)?$";
        Pattern regexDecimalNumbers = Pattern.compile(decimalNumbers);
        Matcher matcherDecimalNumbers = regexDecimalNumbers.matcher(dailyPrice.get());

        String numbers = "[0-9]";
        Pattern regexNumbers = Pattern.compile(numbers);
        Matcher matcherNumbers = regexNumbers.matcher(seats.get());

        if (make.get() == null || make.get().equals("")) {
            message.setValue("Please input make");
            return false;
        }
        else if (carModel.get() == null || carModel.get().equals("")) {
            message.setValue("Please input model");
            return false;
        }
        else if (color.get() == null || color.get().equals("")) {
            message.setValue("Please input color");
            return false;
        }
        else if (numberPlates.get() == null || numberPlates.get().equals("")) {
            message.setValue("Please input number plates ");
            return false;
        }
        else if (fuelType.get() == null || fuelType.get().equals("")) {
            message.setValue("Please input fuel type");
            return false;
        }
        else if (fuelConsumption.get() == null || fuelConsumption.get().equals("")) {
            message.setValue("Please input fuel consumption");
            return false;
        }
        else if (seats.get() == null || seats.get().equals("")) {
            message.setValue("Please input seats");
            return false;
        }
        else if (engine.get() == null || engine.get().equals("")) {
            message.setValue("Please input engine");
            return false;
        }
        else if (transmission.get() == null || transmission.get().equals("")) {
            message.setValue("Please input transmission");
            return false;
        }
        else if (equipment.get() == null || equipment.get().equals("")) {
            message.setValue("Please input equipment");
            return false;
        }
        else if (description.get() == null || description.get().equals("")) {
            message.setValue("Please input description");
            return false;
        }
        else if (dailyPrice.get() == null || dailyPrice.get().equals("")) {
            message.setValue("Please input daily price");
            return false;
        }
        else if (branch.get() == null || branch.get().equals("")) {
            message.setValue("Please input branch");
            return false;
        }
        else if (!matcherDecimalNumbers.matches()) {
            message.set("Please input a valid daily price");
            return false;
        }
        else if (!matcherNumbers.matches()){
            message.set("Please input a valid number of seats");
            return false;
        }
        else if (make.get().length() > 30) {
            message.set("Please input a make with a maximum of 30 characters");
            return false;
        }
        else if (carModel.get().length() > 50){
            message.set("Please input a model with a maximum of 50 characters");
            return false;
        }
        else if (color.get().length() > 30) {
            message.set("Please input a color with a maximum of 30 characters");
            return false;
        }
        else if (numberPlates.get().length() > 10){
            message.set("Please input number plates with a maximum of 10 characters");
            return false;
        }
        else if (fuelType.get().length() > 50 ) {
            message.set("Please input a fuel type with a maximum of 50 characters");
            return false;
        }
        else if (fuelConsumption.get().length() > 50) {
            message.set("Please input a fuel consumption with a maximum of 50 characters");
            return false;
        }
        else if (Integer.parseInt(seats.get()) < 0 || Integer.parseInt(seats.get()) > 100) {
            message.set("Please input a number of seats that is between 0 and 100");
            return false;
        }
        else if (engine.get().length() > 300) {
            message.set("Please input an engine with a maximum of 300 characters");
            return false;
        }
        else if (transmission.get().length() > 300) {
            message.set("Please input a transmission with a maximum of 300 characters");
            return false;
        }

        else if (Double.parseDouble(dailyPrice.get()) < 0.0) {
            message.set("Please input a price higher than 0");
            return false;
        }
        else {

            for (Car car : cars) {
                if (car.getMake().equals(make.get()) && car.getModel().equals(carModel.get()) && car.getColor().equals(color.get()) && car.getNumberPlates().equals(numberPlates.get())
                && car.getFuelType().equals(fuelType.get()) && car.getFuelConsumption().equals(fuelConsumption.get()) && car.getSeats().equals(seats.get()) && car.getEngine().equals(engine.get())
                && car.getTransmission().equals(transmission.get()) && car.getEquipment().equals(equipment.get()) && car.getDescription().equals(description.get())
                        && car.getDailyPrice() == Double.parseDouble(dailyPrice.get()) && String.valueOf(car.getBranchId()).equals(branch.get())) {
                    message.set("This car already exists in the system");
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Add action.
     */
    public void addAction () {
        if (inputVerification()) {
            model.createCar(make.get(),
                    carModel.get(),
                    color.get(),
                    numberPlates.get(),
                    fuelType.get(),
                    fuelConsumption.get(),
                    seats.get(),
                    engine.get(),
                    transmission.get(),
                    equipment.get(),
                    description.get(),
                    Integer.parseInt(branch.get()),
                    Double.parseDouble(dailyPrice.get()));

                    reload();

        }
        else {
            //shouldn't do anything
        }
    }

    private void defaultFields() {
        make.set("");
        carModel.set("");
        color.set("");
        numberPlates.set("");
        fuelType.set("");
        fuelConsumption.set("");
        seats.set("");
        engine.set("");
        transmission.set("");
        equipment.set("");
        description.set("");
        dailyPrice.set("");
        message.set("");
        branch.set("");
        message.set("");
    }

    private void reload () {
        model.getCars();
        viewHandler.openCarView();
        defaultFields();
    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        reload();
    }

    /**
     * Edit action.
     *
     * @param id the id
     */
    public void editAction (int id) {
      if (inputVerification()){
          model.editCar(
                  id,
                  make.get(),
                  carModel.get(),
                  color.get(),
                  numberPlates.get(),
                  fuelType.get(),
                  fuelConsumption.get(),
                  seats.get(),
                  engine.get(),
                  transmission.get(),
                  equipment.get(),
                  description.get(),
                  Integer.parseInt(branch.get()),
                  Double.parseDouble(dailyPrice.get())
          );
          reload();
      }
        else {
            //shouldn't do anything
        }
    }



}
