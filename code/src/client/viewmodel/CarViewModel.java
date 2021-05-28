package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Reservation.Car;
import shared.Reservation.Reservation;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * ViewModel for displaying car information
 * @author adam
 */
public class CarViewModel {

    private Model model;
    private ViewHandler viewHandler;
    private ObservableList<Car> cars;
    private ArrayList<Reservation> reservations;
    private StringProperty message;

    /**
     * Instantiates a new Car view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public CarViewModel(Model model, ViewHandler viewHandler) {
        cars = FXCollections.observableArrayList();
        reservations = new ArrayList<>();
        this.model = model;
        this.viewHandler = viewHandler;
        message = new SimpleStringProperty();
        model.addListener(this::listenForCars, "cars");
        model.addListener(this::listenForReservations, "reservations");
        model.getReservations();
        model.getCars();
    }

    public StringProperty messageProperty () {
        return message;
    }

    private void listenForReservations(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            reservations = (ArrayList<Reservation>) propertyChangeEvent.getNewValue();
        });
    }

    /**
     * Listen for cars.
     *
     * @param event the event
     */
    public void listenForCars(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            cars.clear();

            ArrayList<Car> receivedCars = (ArrayList<Car>) event.getNewValue();
            cars.addAll(receivedCars);
        });
    }


    /**
     * Home.
     */
    public void home() {
        viewHandler.openFrontPageView();
        message.set("");
    }


    /**
     * Gets cars.
     *
     * @return the cars
     */
    public ObservableList<Car> getCars() {
        return cars;
    }

    /**
     * Open add car view.
     */
    public void openAddCarView () {
        viewHandler.openAddCarView();
        message.set("");
    }

    /**
     * Open edit view.
     *
     * @param selectedCar the selected car
     */
    public void openEditView (Car selectedCar) {
        viewHandler.openCarEditView(selectedCar);
        message.set("");
    }

    /**
     * Delete action.
     *
     * @param id the id
     */
    public void deleteAction (int id) {



        model.getReservations();

        boolean canDelete = true;

        for (Reservation reservation : reservations) {
            if (reservation.getCarId() == id)
                canDelete = false;
        }
        if (canDelete) {
            model.deleteCar(id);
            model.getCars();
        } else {
            message.set("This car cannot be deleted because there is a reservation associated with it");
        }
    }
}
