package server.database;


import client.exceptions.AlreadyExists;
import shared.Reservation.Car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Handles adding and retrieving data about cars from the database
 * @author Tymon
 */
public class CarHandler {


    /**
     * add car to the database.
     *
     * @param make            the make
     * @param model           the model
     * @param color           the color
     * @param numberPlates    the number plates
     * @param fuelType        the fuel type
     * @param fuelConsumption the fuel consumption
     * @param seats           the seats
     * @param engine          the engine
     * @param transmission    the transmission
     * @param equipment       the equipment
     * @param description     the description
     * @param branchId        the branch id
     * @param dailyPrice      the daily price
     * @throws AlreadyExists the already exists exception if object already exists in database
     */
   
    public void createCar(String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice){

        try {
                Statement statement2 = DatabaseConnection.getInstance().getConnection().createStatement();
                statement2.executeUpdate(
                        " INSERT INTO car (make, model, color, number_plates, fuel_type," +
                                " fuel_consumption, seats, engine, transmission, equipment, description, branch_id, daily_price) " +
                                "VALUES ('" + make + "', '" + model + "', '" + color + "', '" + numberPlates + "', '" + fuelType + "', '" +
                                fuelConsumption + "', '" + seats + "', '" + engine + "', '" + transmission + "', '" + equipment + "', '" + description + "', '" + branchId + "', '" + dailyPrice + "');");

                statement2.close();
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets car  from the database.
     *
     * @param searchId the search id
     * @return the car
     */
    public Car getCar(int searchId) {


        try {
            int id = 0;
            String make = null;
            String model = null;
            String color = null;
            String numberPlates = null;
            String fuelType = null;
            String fuelConsumption = null;
            String seats = null;
            String engine = null;
            String transmission = null;
            String equipment = null;
            String description = null;
            double dailyPrice = 0;
            int branchId = 0;
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * from car WHERE id = '" + searchId + "';");
            while (result.next()) {
                id = result.getInt("id");
                make = result.getString("make");
                model = result.getString("model");
                color = result.getString("color");
                numberPlates = result.getString("number_plates");
                fuelType = result.getString("fuel_type");
                fuelConsumption = result.getString("fuel_consumption");
                seats = result.getString("seats");
                engine = result.getString("engine");
                transmission = result.getString("transmission");
                equipment = result.getString("equipment");
                description = result.getString("description");
                branchId = result.getInt("branch_id");
                dailyPrice = result.getDouble("daily_price");
            }
            statement.close();
            result.close();
            return new Car(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Gets cars from the database.
     *
     * @return the cars
     */
    public ArrayList<Car> getCars() {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * from car");
            while (result.next()) {
                int id = result.getInt("id");
                String make = result.getString("make");
                String model = result.getString("model");
                String color = result.getString("color");
                String numberPlates = result.getString("number_plates");
                String fuelType = result.getString("fuel_type");
                String fuelConsumption = result.getString("fuel_consumption");
                String seats = result.getString("seats");
                String engine = result.getString("engine");
                String transmission = result.getString("transmission");
                String equipment = result.getString("equipment");
                String description = result.getString("description");
                int branchId = result.getInt("branch_id");
                double dailyPrice = result.getDouble("daily_price");
                cars.add(new Car(id, make, model, color, numberPlates, fuelType, fuelConsumption, seats, engine, transmission, equipment, description, branchId, dailyPrice));
            }
            return cars;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return cars;
        }

    }

    /**
     * Edit car in the database.
     *
     * @param id              the id
     * @param make            the make
     * @param model           the model
     * @param color           the color
     * @param numberPlates    the number plates
     * @param fuelType        the fuel type
     * @param fuelConsumption the fuel consumption
     * @param seats           the seats
     * @param engine          the engine
     * @param transmission    the transmission
     * @param equipment       the equipment
     * @param description     the description
     * @param branchId        the branch id
     * @param dailyPrice      the daily price
     */
    public void editCar(int id, String make, String model, String color, String numberPlates, String fuelType, String fuelConsumption, String seats, String engine, String transmission, String equipment, String description, int branchId, double dailyPrice) {
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            statement.executeUpdate("UPDATE car SET make = '" + make + "', model = '" + model + "', color = '" + color + "', number_plates = '" + numberPlates + "', fuel_type = '" + fuelType + "', fuel_consumption = '" + fuelConsumption +
                    "',seats = '" + seats + "', engine = '" + engine + "', transmission = '" + transmission + "', equipment = '" + equipment + "', description = '" + description + "', branch_id = '" + branchId + "', daily_price = '" + dailyPrice +
                    "' WHERE id = '" + id + "';");
            statement.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    /**
     * Delete car from the database.
     *
     * @param id the id
     */
    public void deleteCar(int id) {
        try {
            Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
            statement.executeUpdate("DELETE FROM car where id = '" + id + "';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
