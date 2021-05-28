package shared.Branch;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * @author tymon
 * @version 1.0
 * class representing branch
 * client and server
 */
public class Branch implements Serializable {
    private int id;
    private String name;
    private String location;


    /**
     * @param id
     * @param name
     * @param location
     */
    public Branch(int id, String name, String location) {
        this.name = name;
        this.id = id;
        this.location = location;
    }

    /**
     * @return branch id
     */
    public int getId() {
        return id;
    }

    /**
     * @return branch name
     */
    public String getName() {
        return name;
    }

    /**
     * @return branch location
     */
    public String getLocation() {
        return location;
    }

    /**
     * sets branch name
     *
     * @param name
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * sets branch location
     *
     * @param location
     */

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * converts String location to StringProperty
     *
     * @return location, as StringProperty
     */
    public StringProperty locationProperty() {
        return new SimpleStringProperty(location);
    }

    /**
     * converts String name to StringProperty
     *
     * @return name, as StringProperty
     */

    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    /**
     * converts int name to IntegerProperty
     *
     * @return id as IntegerProperty
     */
    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

    /**
     * @return all fields as a single String
     */
    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
