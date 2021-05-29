package server.database;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

class BranchHandlerTest {

    private BranchHandler branchHandler;

    @Before
    public void setUp () {
        branchHandler = new BranchHandler();
    }

    @Test
    public void getBranches() {
        assertNotNull(branchHandler.getBranches());
    }
}