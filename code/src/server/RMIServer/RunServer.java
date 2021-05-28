package server.RMIServer;

import shared.Branch.Branch;
import shared.personel.Employee;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Class for Running the server
 * @author tymon
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

        Branch branch = new Branch(0, "owner", "city");
        Employee employee = new Employee(1, "David", "Wallace", 1, 0, "boss", "boss123", "adsdas@gmail.com");

    }
}
