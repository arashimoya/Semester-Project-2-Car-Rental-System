package server.database;

import client.Session;
import client.exceptions.AlreadyExists;
import client.exceptions.DoesNotExist;
import shared.Branch.Branch;
import shared.personel.Employee;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Handles adding and retrieving data about employees from the database
 *
 * @author Oliver
 */
public class EmployeeHandler {

    private final Connection connection = DatabaseConnection.getInstance().getConnection();
    private BranchHandler branchHandler = new BranchHandler();



    /**
     * Create employee  in the database.
     *
     * @param name     the name
     * @param surname  the surname
     * @param role_id  the role id
     * @param branchId the branch id
     * @param username the username
     * @param password the password
     * @param email    the email
     * @throws AlreadyExists the already exists
     */
   
    public void createEmployee(String name, String surname, int role_id, int branchId, String username, String password, String email) {

        try {
                String hashedPassword = LoginHandler.hash(password);
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate("INSERT INTO employee (name, surname, role_id, branch_id, username, password, email) " +
                        "VALUES ('" + name + "', '" + surname + "', " + role_id + ", " + branchId + ", '" + username + "', '" +
                        hashedPassword + "','" + email + "');");

                statement2.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets employee from the database.
     *
     * @param searchId the search id
     * @return the employee
     */
    public Employee getEmployee(int searchId) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employee WHERE id = '" + searchId + "' ; ");
            String name = null;
            String surname = null;
            int id = 0;
            int branchId = 0;
            String username = null;
            String password = null;
            int roleId = 0;
            String email = null;

            while (result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                branchId = result.getInt("branch_id");
                username = result.getString("username");
                password = result.getString("password");
                roleId = result.getInt("role_id");
                email = result.getString("email");
            }
            statement.close();
            result.close();
            Employee employee = new Employee(id, name, surname, roleId, branchId, username, password, email);
            return employee;
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return null;
    }

    /**
     * Gets employees from the database.
     *
     * @return the employees
     */
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employee");

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String surname = result.getString("surname");
                int roleId = result.getInt("role_id");
                int branchId = result.getInt("branch_id");
                String username = result.getString("username");
                String password = result.getString("password");
                String email = result.getString("email");
                employees.add(new Employee(id, name, surname, roleId, branchId, username, password, email));
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return employees;
        }
    }

    /**
     * Edit employee in the database.
     *
     * @param id       the id
     * @param name     the name
     * @param surname  the surname
     * @param role_id  the role id
     * @param branchId the branch id
     * @param username the username
     * @param password the password
     * @param email    the email
     */
    public void editEmployee(int id, String name, String surname, int role_id, int branchId, String username, String password, String email) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE employee SET name = '" + name + "', surname = '" + surname + "', role_id = '" + role_id + "', branch_id = '" + branchId + "', username = '" + username + "', password = '" + password + "', email = '" + email + "' WHERE id = '" + id + "';");
            statement.close();
        } catch (SQLException throwables) {

            throwables.printStackTrace();

        }
    }

    /**
     * Delete employee from the database.
     *
     * @param id the id
     */
    public void deleteEmployee(int id){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM employee where id = '" + id + "';" );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Validates login and returns role information if accepted
     *
     * @param username the username
     * @param password the password
     * @return the int Role when login approved
     * @throws DoesNotExist the does not exist when password does not match username
     */
    public ArrayList<String> login (String username, String password) throws DoesNotExist {
        try {

            Statement statement = connection.createStatement();
            String storedPassword = null;
            int role_id = 0;

            ResultSet result = statement.executeQuery("SELECT * FROM employee WHERE username = '" + username + "';");
                while (result.next()) {
                    storedPassword = result.getString("password");
                    role_id = result.getInt("role_id");
                }
           if (LoginHandler.validatePassword(password, storedPassword)) {
               ArrayList<String> session = new ArrayList<>();
               session.add(String.valueOf(role_id));
               session.add(username);
               return session;
           }
           else {
               ArrayList<String> session = new ArrayList<>();
               session.add("0");
               session.add("none");
               return session;
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            ArrayList<String> session = new ArrayList<>();
            session.add("0");
            session.add("none");
            return session;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            ArrayList<String> session = new ArrayList<>();
            session.add("0");
            session.add("none");
            return session;
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
            ArrayList<String> session = new ArrayList<>();
            session.add("0");
            session.add("none");
            return session;
        }
    }

    }



