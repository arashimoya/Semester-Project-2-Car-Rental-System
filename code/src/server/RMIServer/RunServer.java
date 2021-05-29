package server.RMIServer;

import server.database.EmployeeHandler;
import shared.Branch.Branch;
import shared.personel.Employee;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Class for Running the server
 * @author Tymon, Oliver
 */
public class RunServer {
    /**
     * The entry point of application, binds the Server object to registry so it can be found by the client.
     *
     * @param args the input arguments
     * @throws RemoteException       the remote exception
     * @throws AlreadyBoundException the already bound exception
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Server server = new DataServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("server", server);

        EmployeeHandler employeeHandler = new EmployeeHandler();
        employeeHandler.createOwnerAccount("owner", "owner", 1, "owner", "Toda@2115", "owner@gmail.com");

    }
}
