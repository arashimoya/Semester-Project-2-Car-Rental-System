package shared.Tests;

import org.junit.jupiter.api.Test;
import shared.personel.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee testEmployee () {
        return new Employee (1, "TestName", "TestSurname", 1, 1, "TestUsername", "TestPassword", "TestEmail");
    }


    @Test
    void employeeNotNull () {
        assertNotNull(testEmployee());
    }

    @Test
    void getName() {
        assertEquals(testEmployee().getName(), "TestName");
    }

    @Test
    void getSurname() {
        assertEquals(testEmployee().getSurname(), "TestSurname");
    }

    @Test
    void getId() {
        assertEquals(testEmployee().getId(), 1);
    }

    @Test
    void getEmail() {
        assertEquals(testEmployee().getEmail(), "TestEmail");
    }

    @Test
    void getRoleId() {
        assertEquals(testEmployee().getRoleId(), 1);
    }

    @Test
    void getBranchId() {
        assertEquals(testEmployee().getBranchId(), 1);
    }

}