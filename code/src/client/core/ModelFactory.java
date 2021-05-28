package client.core;

import client.model.DataModel;
import client.model.Model;
import client.network.DataClient;

import java.rmi.RemoteException;

/**
 * uses lazy instantiation to provide only one instance of client
 * @author Dan
 */
public class ModelFactory
{
    private DataModel model;
    private ClientFactory clientFactory;

    /**
     * public constructor
     * @param clientFactory ClientFactory to get client
     */
    public ModelFactory(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }


    /**
     * if model is null returns new DataModel(), else returns model
     * @return client
     */
    public Model getModel() {
        if (model == null) {
            model = new DataModel(clientFactory.getClient());

        }
        return model;
    }


}
