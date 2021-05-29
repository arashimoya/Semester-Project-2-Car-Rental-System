package shared.Tests;

import org.junit.jupiter.api.Test;
import shared.Reservation.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car testCar () {
        return new Car (1, "TestMake", "TestModel", "TestColor", "TestNumberPlates", "TestFuelType", "TestFuelConsumption", "5", "TestEngine", "TestTransmission", "TestEquipment", "TestDescription", 1, 1000.5);
    }

    @Test
    void carNotNull () {
        assertNotNull(testCar());
    }

    @Test
    void getId() {
        assertEquals(testCar().getId(), 1);
    }

    @Test
    void getMake() {
        assertEquals(testCar().getMake(), "TestMake");
    }

    @Test
    void getModel() {
        assertEquals(testCar().getModel(), "TestModel");
    }

    @Test
    void getColor() {
        assertEquals(testCar().getColor(), "TestColor");
    }

    @Test
    void getNumberPlates() {
        assertEquals(testCar().getNumberPlates(), "TestNumberPlates");
    }

    @Test
    void getFuelType() {
        assertEquals(testCar().getFuelType(), "TestFuelType");
    }

    @Test
    void getFuelConsumption() {
        assertEquals(testCar().getFuelConsumption(), "TestFuelConsumption");
    }

    @Test
    void getSeats() {
        assertEquals(testCar().getSeats(), "5");
    }

    @Test
    void getEngine() {
        assertEquals(testCar().getEngine(), "TestEngine");
    }

    @Test
    void getTransmission() {
        assertEquals(testCar().getTransmission(), "TestTransmission");
    }

    @Test
    void getEquipment() {
        assertEquals(testCar().getEquipment(), "TestEquipment");
    }

    @Test
    void getDescription() {
        assertEquals(testCar().getDescription(), "TestDescription");
    }

    @Test
    void getBranchId() {
        assertEquals(testCar().getBranchId(), 1);
    }

    @Test
    void getDailyPrice() {
        assertEquals(testCar().getDailyPrice(), 1000.5);
    }
}