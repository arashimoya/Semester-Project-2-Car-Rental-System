package shared.personel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Branch.Branch;
import java.io.Serializable;

/**
 * @author tymon, oliver
 * @version 1.0
 * class representing employee
 * implements Serializable so it can be passed between
 * client and server
 */
public class Employee implements Serializable {
    private String name;
    private String surname;
    private int id;
    private int branchId;
    private String username;
    private String password;
    int roleId;
    private String email;

    /**
     * public constructor
     * @param id int
     * @param name String
     * @param surname String
     * @param roleId int
     * @param branchId int
     * @param username String
     * @param password String
     * @param email String
     */
    public Employee(int id, String name, String surname, int roleId, int branchId, String username, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.branchId = branchId;
        this.roleId = roleId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getRoleId() {
        return roleId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    /**
     * converts String name to StringProperty
     * @return name as StringProperty
     */
    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    /**
     * converts String surname to StringProperty
     * @return surname as StringProperty
     */
    public StringProperty surnameProperty() {
        return new SimpleStringProperty(surname);
    }

    /**
     * converts int id to IntegerProperty
     * @return id as IntegerProperty
     */
    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    /**
     * converts int branchId to StringProperty
     * @return id as StringProperty
     */
    public StringProperty branchIdProperty() {
        return new SimpleStringProperty(String.valueOf(branchId));
    }

    /**
     * converts String username to StringProperty
     * @return username as StringProperty
     */
    public StringProperty usernameProperty() {
        return new SimpleStringProperty(username);
    }

    /**
     * converts int role to IntegerProperty
     * @return role as IntegerProperty
     */
    public IntegerProperty roleProperty() {
        return new SimpleIntegerProperty(roleId);
    }

    /**
     * converts String email to StringProperty
     * @return email as StringProperty
     */
    public StringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }
    /**
     *
     * @return all fields as a single String
     */
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", branch=" + branchId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
