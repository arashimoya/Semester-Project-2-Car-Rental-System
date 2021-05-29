package shared.Tests;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import shared.Branch.Branch;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    private Branch branch;

    private Branch testBranch(){
        return new Branch(1, "TestBranch", "TestLocation");
    }

    @Test
    void branchNotNull () {
        assertNotNull(testBranch());
    }

    @Test
    void getId() {
        assertEquals(testBranch().getId(), 1);
    }

    @Test
    void getName() {
        assertEquals(testBranch().getName(), "TestBranch");
    }

    @Test
    void getLocation() {
        assertEquals(testBranch().getLocation(), "TestLocation");
    }

}