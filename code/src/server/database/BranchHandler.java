package server.database;

import client.exceptions.AlreadyExists;
import shared.Branch.Branch;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Handles adding and retrieving data about branches from the database
 * @author Oliver, Tymon
 */
public class BranchHandler {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();



    /**
     * Create branch from database.
     *
     * @param name     the name
     * @param location the location
     * @throws AlreadyExists the already exists when object already exists in database
     */


    public void createBranch(String name, String location){


        try {
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate("INSERT INTO branch (name, location) VALUES ('" + name + "','" + location + "');");
                statement2.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    /**
     * Gets branch from database.
     *
     * @param searchId the search id
     * @return the branch
     */
    public Branch getBranch(int searchId) {
        try {

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM branch WHERE id = '" + searchId + "' ; ");
            int id = 0;
            String name = null;
            String location = null;

            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                location = result.getString("location");
            }
            statement.close();

            Branch branch = new Branch(id, name, location);
            return branch;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

    }

    /**
     * Gets branches from database.
     *
     * @return the branches
     */
    public ArrayList<Branch> getBranches() {

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM branch");
            ArrayList<Branch> branches = new ArrayList<Branch>();
            int id = 0;
            String name = "";
            String location = "";
            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                location = result.getString("location");
                branches.add(new Branch(id, name, location));
            }
            return branches;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    /**
     * Edit branch from database.
     *
     * @param id       the id
     * @param name     the name
     * @param location the location
     */
    public void editBranch(int id, String name, String location) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE branch SET name ='" + name + "', location = '" + location + "' WHERE id = '" + id + "';");
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Delete branch  from database.
     *
     * @param id the id
     */
    public void deleteBranch(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM branch where id= '" + id + "';");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
