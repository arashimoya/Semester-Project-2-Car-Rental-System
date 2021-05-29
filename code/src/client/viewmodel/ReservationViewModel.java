package client.viewmodel;

import client.core.ViewHandler;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Reservation.Reservation;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

/**
 * ViewModel for displaying reservation information
 * @author Oliver, Tymon
 */
public class ReservationViewModel {
    private ObservableList<Reservation> reservations;
    private Model model;
    private ViewHandler viewHandler;

    /**
     * Instantiates a new Reservation view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public ReservationViewModel(Model model, ViewHandler viewHandler) {
        reservations = FXCollections.observableArrayList();
        this.model = model;
        model.addListener(this::listenForReservations, "reservations");
        model.getReservations();
        this.viewHandler = viewHandler;
    }

    /**
     * listens for the reservation event change
     * @param propertyChangeEvent the value of the event
     */
    private void listenForReservations(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            reservations.clear();
            ArrayList<Reservation> receivedReservations = (ArrayList<Reservation>) propertyChangeEvent.getNewValue();
            reservations.addAll(receivedReservations);
        });
    }

    /**
     * Home.
     */
    public void home() {
        viewHandler.openFrontPageView();
    }

    /**
     * Gets reservations.
     *
     * @return the reservations
     */
    public ObservableList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Gets add reservation view.
     */
    public void getAddReservationView() {
        viewHandler.openAddReservationView();
    }

    /**
     * Open edit view.
     *
     * @param selectedReservation the selected reservation
     */
    public void openEditView(Reservation selectedReservation) {
        viewHandler.openReservationEditView(selectedReservation);
    }

    /**
     * Delete action.
     *
     * @param id the id
     */
    public void deleteAction (int id) {
        model.deleteReservation(id);
        model.getReservations();
    }
}