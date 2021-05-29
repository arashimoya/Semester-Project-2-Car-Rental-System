package server.database;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationHandlerTest {

    private ReservationHandler reservationHandler;

    @Before
    public void setUp () {
        reservationHandler = new ReservationHandler();
    }

    @Test
    void getReservations() {
        assertNotNull(reservationHandler.getReservations());
    }
}