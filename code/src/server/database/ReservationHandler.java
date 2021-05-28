package server.database;

import client.exceptions.AlreadyExists;
import shared.Branch.Branch;
import shared.Reservation.Address;
import shared.Reservation.Car;
import shared.Reservation.Reservation;


import java.sql.*;
import java.util.ArrayList;

/**
 * Handles adding and retrieving data about reservations from the database
 * @author tymon
 */
public class ReservationHandler {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private final BranchHandler branchHandler = new BranchHandler();
    private final CarHandler carHandler = new CarHandler();


    /**
     * Create reservation in the database.
     *
     * @param name           the name
     * @param surname        the surname
     * @param driversLicence the drivers licence
     * @param address        the address
     * @param carId          the car id
     * @param startBranchId  the start branch id
     * @param endBranchId    the end branch id
     * @param startDate      the start date
     * @param endDate        the end date
     * @param price          the price
     * @param email          the email
     * @param phoneNumber    the phone number
     * @throws AlreadyExists the already exists
     */
    public void createReservation(String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber)  {
   
        try {
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate("INSERT INTO reservation (name, surname, drivers_licence, address_street, address_city, address_zip, address_country, car_id, start_branch_id, end_branch_id, start_date, end_date, price, email, phone_number) " +
                        "VALUES ('" + name + "','" + surname + "','" + driversLicence + "','" + address.getStreet() + "','" + address.getCity() + "', '" + address.getZip() + "', '" + address.getCountry() + "','" + carId + "', '" + startBranchId + "', '" + endBranchId +
                        "', '" + startDate + "','" + endDate + "', '" + price + "', '" + email + "', '" + phoneNumber + "');");
                statement2.close();


        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    /**
     * Gets reservation with given id from the database.
     *
     * @param searchId the search id
     * @return the reservation
     */
    public Reservation getReservation(int searchId) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM 'reservation' WHERE id = '" + searchId + "'); ");
            int id = 0;
            String name = "";
            String surname = "";
            String driversLicence = "";
            String addressStreet = "";
            String addressCity = "";
            String addressZip = "";
            String addressCountry = "";
            int carId = 0;
            int startBranchId = 0;
            int endBranchId = 0;
            Date startDate = null;
            Date endDate = null;
            double price = 0.0;
            String email = null;
            String phoneNumber = null;

            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                driversLicence = result.getString("drivers_licence");
                addressStreet = result.getString("address_street");
                addressCity = result.getString("address_city");
                addressZip = result.getString("address_zip");
                addressCountry = result.getString("address_country");
                carId = result.getInt("car_id");
                startBranchId = result.getInt("start_branch_id");
                endBranchId = result.getInt("end_branch_id");
                startDate = result.getDate("start_date");
                endDate = result.getDate("end_date");
                price = result.getDouble("price");
                email = result.getString("email");
                phoneNumber = result.getString("phone_number");
            }
            statement.close();
            result.close();
            Reservation reservation = new Reservation(id, name, surname, driversLicence, new Address(addressStreet, addressCity, addressZip, addressCountry), carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber);
            return reservation;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    /**
     * Gets all reservations from the database.
     *
     * @return the reservations
     */
    public ArrayList<Reservation> getReservations() {

        try {
            int id = 0;
            String name = "";
            String surname = "";
            String driversLicence = "";
            String addressStreet = "";
            String addressCity = "";
            String addressZip = "";
            String addressCountry = "";
            int carId = 0;
            int startBranchId = 0;
            int endBranchId = 0;
            Date startDate = null;
            Date endDate = null;
            double price = 0.0;
            String email = null;
            String phoneNumber = null;

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM reservation");
            ArrayList<Reservation> reservations = new ArrayList<Reservation>();


            while (result.next()) {

                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                driversLicence = result.getString("drivers_licence");
                addressStreet = result.getString("address_street");
                addressCity = result.getString("address_city");
                addressZip = result.getString("address_zip");
                addressCountry = result.getString("address_country");
                carId = result.getInt("car_id");
                startBranchId = result.getInt("start_branch_id");
                endBranchId = result.getInt("end_branch_id");
                startDate = result.getDate("start_date");
                endDate = result.getDate("end_date");
                price = result.getDouble("price");
                email = result.getString("email");
                phoneNumber = result.getString("phone_number");

                reservations.add(new Reservation(id, name, surname, driversLicence, new Address(addressStreet, addressCity, addressZip, addressCountry), carId, startBranchId, endBranchId, startDate, endDate, price, email, phoneNumber));
            }

            return reservations;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /**
     * Edit reservation in the database.
     *
     * @param id             the id
     * @param name           the name
     * @param surname        the surname
     * @param driversLicence the drivers licence
     * @param address        the address
     * @param carId          the car id
     * @param startBranchId  the start branch id
     * @param endBranchId    the end branch id
     * @param startDate      the start date
     * @param endDate        the end date
     * @param price          the price
     * @param email          the email
     * @param phoneNumber    the phone number
     */
    public void editReservation(int id, String name, String surname, String driversLicence, Address address, int carId, int startBranchId, int endBranchId, Date startDate, Date endDate, double price, String email, String phoneNumber) {


        try {


            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE reservation SET name ='" + name + "', surname = '" + surname + "', drivers_licence ='" + driversLicence + "', address_street = '" + address.getStreet() + "', address_city = '" + address.getCity()
                    + "', address_zip = '" + address.getZip() + "', address_country = '" + address.getCountry() + "', car_id = + '" + carId + "', start_branch_id = '" + startBranchId + "', end_branch_id = '" + endBranchId
                    + "', start_date = '" + startDate + "', end_date = '" + endDate + "', price = '" + price + "', email = '" + email + "', phone_number = '" + phoneNumber + "' WHERE id = '" + id + "';");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Delete reservation from the database.
     *
     * @param id the id
     */
    public void deleteReservation(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM reservation where id = '" + id + "';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
