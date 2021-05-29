package client.core;

import client.network.Client;
import client.network.DataClient;

import java.rmi.RemoteException;

/**
 * uses lazy instantiation to provide only one instance of client
 * @author Tymon, Oliver
 */
public class ClientFactory {

    private DataClient client;

    /**
     * if clients is null returns new DataClient(), else returns client
     * @return client
     */
    public DataClient getClient() {
        if (client == null) {
            try {
                client = new DataClient();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return client;
    }
}
