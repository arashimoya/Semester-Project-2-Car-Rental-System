package client.core;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Initialises client factory, model factory and viewHandler
 * opens the first scene
 * @author Tymon, Oliver
 */
public class CarRentalApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClientFactory clientFactory = new ClientFactory();
        ModelFactory modelFactory = new ModelFactory(clientFactory);
        ViewHandler viewHandler = new ViewHandler(modelFactory);
        viewHandler.start();
    }
}
