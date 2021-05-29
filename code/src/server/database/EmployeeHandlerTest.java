package server.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeHandlerTest {

    private EmployeeHandler employeeHandler;

    @Before
    public void setUp () {
        employeeHandler = new EmployeeHandler();
    }

    @Test
    public void getEmployees () {
        assertNotNull(employeeHandler.getEmployees());
    }

}