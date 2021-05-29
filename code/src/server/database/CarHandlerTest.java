package server.database;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarHandlerTest {

    private CarHandler carHandler;

    @Before
    public void setUp () {
        carHandler = new CarHandler();
    }

    @Test
    void getCars() {
        assertNotNull(carHandler.getCars());
    }
}