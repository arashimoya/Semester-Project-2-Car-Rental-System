package shared.Tests;

import org.junit.jupiter.api.Test;
import shared.Reservation.Address;
import shared.Reservation.Reservation;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation testReservation () {
        return new Reservation(1, "TestName", "TestSurname", "TestDriversLicence", new Address("TestStreet", "TestCity", "TestZip", "TestCountry"), 1, 1, 1, new Date(1), new Date(1), 1.5, "TestEmail", "TestPhoneNumber");
    }

    @Test
    void reservationNutNull () {
        assertNotNull(testReservation());
    }

    @Test
    void getName() {
        assertEquals(testReservation().getName(), "TestName");
    }

    @Test
    void getSurname() {
        assertEquals(testReservation().getSurname(), "TestSurname");
    }

    @Test
    void getDriversLicence() {
        assertEquals(testReservation().getDriversLicence(), "TestDriversLicence");
    }

    @Test
    void getAddress() {
        assertNotNull(testReservation().getAddress());
        assertEquals(testReservation().getAddress().getStreet(), "TestStreet");
        assertEquals(testReservation().getAddress().getZip(), "TestZip");
        assertEquals(testReservation().getAddress().getCity(), "TestCity");
        assertEquals(testReservation().getAddress().getCountry(), "TestCountry");
    }

    @Test
    void getCarId() {
        assertEquals(testReservation().getId(), 1);
    }

    @Test
    void getStartBranchId() {
        assertEquals(testReservation().getStartBranchId(), 1);
    }

    @Test
    void getEndBranchId() {
        assertEquals(testReservation().getEndBranchId(), 1);
    }

    @Test
    void getId() {
        assertEquals(testReservation().getId(), 1);
    }

    @Test
    void getPrice() {
        assertEquals(testReservation().getPrice(), 1.5);
    }

    @Test
    void getEmail() {
        assertEquals(testReservation().getEmail(), "TestEmail");
    }

    @Test
    void getPhoneNumber() {
        assertEquals(testReservation().getPhoneNumber(), "TestPhoneNumber");
    }

    @Test
    void getStartDate() {
        assertEquals(testReservation().getStartDate(), new Date(1));
    }

    @Test
    void getEndDate() {
        assertEquals(testReservation().getEndDate(), new Date(1));
    }
}