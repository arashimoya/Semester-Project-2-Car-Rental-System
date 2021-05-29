package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.Reservation.Address;
import shared.Reservation.Car;
import shared.Reservation.Reservation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ViewModel for adding and editing the reservation
 * @author Tymon, Oliver
 */
public class AddEditReservationViewModel {
    private Model model;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;
    private ObservableList<String> branches;
    private ObservableList<String> cars;
    private ArrayList<Reservation> reservations;
    private ArrayList<Car> receivedCars;



    private StringProperty name;
    private StringProperty surname;
    private StringProperty driversLicence;
    private StringProperty addressStreet;
    private StringProperty addressZip;
    private StringProperty addressCity;
    private StringProperty addressCountry;
    private StringProperty price;
    private StringProperty email;
    private StringProperty phoneNumber;
    private StringProperty car;
    private StringProperty startBranch;
    private StringProperty endBranch;
    private ObjectProperty<LocalDate> startDate;
    private ObjectProperty<LocalDate> endDate;
    private StringProperty message;


    /**
     * Instantiates a new Add edit reservation view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public AddEditReservationViewModel (Model model, ViewHandler viewHandler) {
        this.model = model;
        model.addListener(this::listenForBranches, "branches");
        model.addListener(this::listenForCars, "cars");
        model.addListener(this::listenForReservations, "reservations");
        model.getBranches();
        model.getCars();
        model.getReservations();

        this.viewHandler = viewHandler;
        branches = FXCollections.observableArrayList();
        cars = FXCollections.observableArrayList();
        reservations = new ArrayList<>();
        receivedCars = new ArrayList<>();

        name = new SimpleStringProperty();
        surname = new SimpleStringProperty();
        driversLicence = new SimpleStringProperty();
        addressCity = new SimpleStringProperty();
        addressStreet = new SimpleStringProperty();
        addressZip = new SimpleStringProperty();
        addressCountry = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phoneNumber = new SimpleStringProperty();
        startBranch = new SimpleStringProperty();
        price = new SimpleStringProperty();
        car = new SimpleStringProperty();
        endBranch = new SimpleStringProperty();
        startDate = new SimpleObjectProperty<>();
        endDate = new SimpleObjectProperty<>();
        message = new SimpleStringProperty();
    }

    /**
     * listens for the reservation event change
     * @param propertyChangeEvent the value of the event change
     */
    private void listenForReservations(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            reservations = (ArrayList<Reservation>) propertyChangeEvent.getNewValue();
        });
    }
    /**
     * Name property string property.
     *
     * @return the string property
     */
    public StringProperty nameProperty () {
        return name;
    }

    /**
     * Surname property string property.
     *
     * @return the string property
     */
    public StringProperty surnameProperty ()  {
        return surname;
    }

    /**
     * Drivers licence property string property.
     *
     * @return the string property
     */
    public StringProperty driversLicenceProperty() {
        return driversLicence;
    }

    /**
     * Address street property string property.
     *
     * @return the string property
     */
    public StringProperty addressStreetProperty () {
        return addressStreet;
    }

    /**
     * Address zip property string property.
     *
     * @return the string property
     */
    public StringProperty addressZipProperty(){
        return addressZip;
    }

    /**
     * Address city property string property.
     *
     * @return the string property
     */
    public StringProperty addressCityProperty(){
        return addressCity;
    }

    /**
     * Address country property string property.
     *
     * @return the string property
     */
    public StringProperty addressCountryProperty () {
        return addressCountry;
    }

    /**
     * Price property string property.
     *
     * @return the string property
     */
    public StringProperty priceProperty () {
        return price;
    }

    /**
     * Email property string property.
     *
     * @return the string property
     */
    public StringProperty emailProperty () {
        return email;
    }

    /**
     * Phone number property string property.
     *
     * @return the string property
     */
    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    /**
     * Car property string property.
     *
     * @return the string property
     */
    public StringProperty carProperty () {
        return car;
    }

    /**
     * Start branch property string property.
     *
     * @return the string property
     */
    public StringProperty startBranchProperty () {
        return startBranch;
    }

    /**
     * End branch property string property.
     *
     * @return the string property
     */
    public StringProperty endBranchProperty () {
        return endBranch;
    }

    /**
     * Start date property object property.
     *
     * @return the object property
     */
    public ObjectProperty<LocalDate> startDateProperty () {
        return startDate;
    }

    /**
     * End date property object property.
     *
     * @return the object property
     */
    public ObjectProperty<LocalDate> endDateProperty () {
        return endDate;
    }

    /**
     * Message property string property.
     *
     * @return the string property
     */
    public StringProperty messageProperty () {
        return message;
    }

    /**
     * listens for the branches event change
     * @param propertyChangeEvent the event change value
     */
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
     * listens for the car event change
     * @param propertyChangeEvent the event change value
     */
    private void listenForCars(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {

            cars.clear();

            receivedCars = (ArrayList<Car>) propertyChangeEvent.getNewValue();
            ArrayList<String> receivedCarNumbers = new ArrayList<>();
            for (Car receivedCar : receivedCars) {
                receivedCarNumbers.add(String.valueOf(receivedCar.getId()));
            }
            cars.addAll(receivedCarNumbers);
        });
    }

    /**
     * Gets cars.
     *
     * @return the cars
     */
    public ObservableList<String> getCars() {
        return cars;
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
     * calculates the price of the reservation based on the selected dates and the selected car
     */
    public void calculatePrice () {

        if (startDate.get() != null && endDate.get() != null && car != null ) {



            model.getCars();
            double carPrice = 0;
            int duration = endDate.get().getDayOfYear() - startDate.get().getDayOfYear();
            for (Car receivedCar : receivedCars) {

                if (receivedCar.getId() == Integer.parseInt(car.get())) {
                    carPrice = receivedCar.getDailyPrice();
                }
            }
            price.set(String.valueOf(carPrice * duration));
        } else {
            message.set("Input start, end date, car to get a calculation");
        }
    }

    /**
     * verifies the input of the add or edit action
     * @return if its correct or not
     */
    private boolean inputVerification() {



        String decimalNumbers = "[1-9]\\d*(\\.\\d+)?$";
        Pattern regexDecimalNumbers = Pattern.compile(decimalNumbers);
        Matcher matcherDecimalNumbers = regexDecimalNumbers.matcher(price.get());

        //RFC 5322 General Email Regex Official Standard
        String validEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern regexEmail = Pattern.compile(validEmail);
        Matcher matcherEmail = regexEmail.matcher(email.get());

        if (name.get() == null || name.get().equals("")) {
            message.setValue("Please input name");
            return false;
        }
        else if (surname.get() == null || surname.get().equals("")) {
            message.setValue("Please input surname");
            return false;
        }
        else if (driversLicence.get() == null || driversLicence.get().equals("")) {
            message.setValue("Please input drivers licence");
            return false;
        }
        else if (addressStreet.get() == null || addressStreet.get().equals("")) {
            message.setValue("Please input street");
            return false;
        }
        else if (addressZip.get() == null || addressZip.get().equals("")) {
            message.setValue("Please input zip");
            return false;
        }
        else if (addressCity.get() == null || addressCity.get().equals("")) {
            message.setValue("Please input city");
            return false;
        }
        else if (addressCountry.get() == null || addressCountry.get().equals("")) {
            message.setValue("Please input country");
            return false;
        }
        else if (price.get() == null || price.get().equals("")) {
            message.setValue("Please input price");
            return false;
        }
        else if (email.get() == null || email.get().equals("")) {
            message.setValue("Please input email");
            return false;
        }
        else if (phoneNumber.get() == null || phoneNumber.get().equals("")) {
            message.setValue("Please input phone number");
            return false;
        }
        else if (car.get() == null || car.get().equals("")) {
            message.setValue("Please input car");
            return false;
        }
        else if (startBranch.get() == null || startBranch.get().equals("")) {
            message.setValue("Please input start branch");
            return false;
        }
        else if (endBranch.get() == null || endBranch.get().equals("")) {
            message.setValue("Please input end branch");
            return false;
        }
        else if (startDate.get() == null) {
            message.setValue("Please input start date");
            return false;
        }
        else if (endDate.get() == null) {
            message.setValue("Please input end date");
            return false;
        }
        else if (!matcherDecimalNumbers.matches()) {
            message.set("Please input a valid price");
            return false;
        }
        else if (!matcherEmail.matches()){
            message.set("Please input a valid email");
            return false;
        }
        else if (name.get().length() > 800) {
            message.set("Please input a name with a maximum of 800 characters");
            return false;
        }
        else if (surname.get().length() > 40) {
            message.set("Please input a surname with a maximum of 40 characters");
            return false;
        }
        else if (driversLicence.get().length() > 50) {
            message.set("Please input a drivers licence ID with a maximum of 50 characters");
            return false;
        }
        else if (addressStreet.get().length() > 100) {
            message.set("Please input a street with a maximum of 100 characters");
            return false;
        }
        else if (addressCity.get().length() > 100) {
            message.set("Please input a city with a maximum of 100 characters");
            return false;
        }
        else if (addressZip.get().length() > 12) {
            message.set("Please input a ZIP with a maximum of 12 characters");
            return false;
        }
        else if (startDate.get().isAfter(endDate.get())) {
            message.set("Start date cannot be later than the end date");
            return false;
        }


        else {

            for (Reservation reservation : reservations) {
                if (reservation.getName().equals(name.get()) && reservation.getSurname().equals(surname.get()) && reservation.getDriversLicence().equals(driversLicence.get())
                && reservation.getAddress().getStreet().equals(addressStreet.get()) && reservation.getAddress().getCity().equals(addressCity.get()) && reservation.getAddress().getZip().equals(addressZip.get())
                && reservation.getAddress().getCountry().equals(addressCountry.get()) && String.valueOf(reservation.getPrice()).equals(price.get()) && reservation.getEmail().equals(email.get())
                && reservation.getPhoneNumber().equals(phoneNumber.get()) && String.valueOf(reservation.getCarId()).equals(car.get())
                && String.valueOf(reservation.getStartBranchId()).equals(startBranch.get()) && String.valueOf(reservation.getEndBranchId()).equals(endBranch.get())
                && reservation.getStartDate().toLocalDate().equals(startDate.get()) && reservation.getEndDate().toLocalDate().equals(endDate.get())) {
                    message.set("This reservation already exists in the system");
                    return false;
                }
            }

            return true;
        }
    }

    /**
     * Cancel action.
     */
    public void cancelAction () {
        reload();
    }

    /**
     * Add action.
     */
    public void addAction () {
        if (inputVerification()){
            model.createReservation(name.get(),
                    surname.get(),
                    driversLicence.get(),
                    new Address(addressStreet.get(), addressZip.get(), addressCity.get(), addressCountry.get()),
                    Integer.parseInt(car.get()),
                    Integer.parseInt(startBranch.get()),
                    Integer.parseInt(endBranch.get()),
                    getSQLDateFromStartDate(),
                    getSQLDateFromEndDate(),
                    Double.valueOf(price.get()),
                    email.get(),
                    phoneNumber.get());

                    reload();

        }
        else {

        }

    }

    /**
     * defaults the fields of the add and edit form
     *
     *
     */
    private void defaultFields () {
        name.set("");
        surname.set("");
        driversLicence.set("");
        addressStreet.set("");
        addressZip.set("");
        addressCity.set("");
        addressCountry.set("");
        email.set("");
        phoneNumber.set("");
        price.set("");
        message.set("");
        startDate.set(null);
        endDate.set(null);
        startBranch.set("");
        endBranch.set("");
        car.set("");
    }

    /**
     * goes back to the list view, defaults are fields and reloads data
     */
    private void reload () {
        model.getReservations();
        viewHandler.openReservationView();
        defaultFields();
    }

    /**
     * edit action
     * @param id the reservation to be edited
     */
    public void editAction (int id) {
        if (inputVerification()){

                model.editReservation(
                        id,
                        name.get(),
                        surname.get(),
                        driversLicence.get(),
                        new Address(addressStreet.get(), addressCity.get(), addressZip.get(), addressCountry.get()),
                        Integer.parseInt(car.get()),
                        Integer.parseInt(startBranch.get()),
                        Integer.parseInt(endBranch.get()),
                        getSQLDateFromStartDate(),
                        getSQLDateFromEndDate(),
                        Double.parseDouble(price.get()),
                        email.get(),
                        phoneNumber.get()
                );
                        reload();
        }
        else {
            //shouldn't do anything
        }
    }

    /**
     * returns the sql date object from the start date local date object
     * @return the sql date
     */
    private Date getSQLDateFromStartDate () {
        java.sql.Date date = Date.valueOf(startDate.getValue());
        return date;
    }

    /**
     * returns the sql date object from the end date local date object
     * @return the sql date
     */
    private Date getSQLDateFromEndDate () {
        java.sql.Date date = Date.valueOf(endDate.getValue());
        return date;
    }

}
