package client.viewmodel;

import client.Session;
import client.core.ViewHandler;
import client.model.DataModel;
import client.model.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.Branch.Branch;
import shared.personel.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ViewModel for registration of new employee, only accesible by manager and owner
 *
 * @author Oliver, Tymon
 */
public class RegistrationViewModel {

    private Model model;
    private StringProperty firstname;
    private StringProperty lastname;
    private StringProperty username;
    private StringProperty password;
    private StringProperty confirmpassword;
    private StringProperty registrationMessageLabel;
    private StringProperty role;
    private StringProperty branch;
    private StringProperty email;
    private PropertyChangeSupport support;
    private ViewHandler viewHandler;
    private ObservableList<String> branches;
    private ObservableList<String> roles;
    private ArrayList<Employee> employees;

    /**
     * Instantiates a new Registration view model.
     *
     * @param model       the model
     * @param viewHandler the view handler
     */
    public RegistrationViewModel(Model model, ViewHandler viewHandler) {
        this.model = model;
        support = new PropertyChangeSupport(this);
        this.viewHandler = viewHandler;
        employees = new ArrayList<>();
        firstname = new SimpleStringProperty();
        lastname = new SimpleStringProperty();
        username = new SimpleStringProperty();
        password = new SimpleStringProperty();
        confirmpassword = new SimpleStringProperty();
        registrationMessageLabel = new SimpleStringProperty();
        role = new SimpleStringProperty();
        branch = new SimpleStringProperty();
        email = new SimpleStringProperty();
        branches = FXCollections.observableArrayList();
        roles = FXCollections.observableArrayList();
        model.addListener(this::listenForEmployees, "employees");
        model.getEmployees();

        model.addListener(this::listenForBranches, "branches");
        model.getBranches();

    }


    /**
     * listens for the employees event change
     * @param propertyChangeEvent the value of the event change
     */
    private void listenForEmployees(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            employees = (ArrayList<Employee>) propertyChangeEvent.getNewValue();
        });
    }

    /**
     * listens for the branches event change
     * @param propertyChangeEvent the value of the event
     */
    private void listenForBranches(PropertyChangeEvent propertyChangeEvent) {
        Platform.runLater(() -> {
            branches.clear();

            ArrayList<Branch> receivedBranches = (ArrayList<Branch>) propertyChangeEvent.getNewValue();
            ArrayList<String> receivedBranchNumbers = new ArrayList<>();
            for (Branch receivedBranch : receivedBranches) {
                receivedBranchNumbers.add(String.valueOf(receivedBranch.getId()));
            }
            branches.addAll(receivedBranchNumbers);

        });
    }

    /**
     * Gets branches.
     *
     * @return the branches
     */
    public ObservableList<String> getBranches() {
        return branches;
    }

    /**
     * Gets roles.
     *
     * @return the roles
     */
    public ObservableList<String> getRoles() {
        roles.clear();

        if (Session.getRole_id() == 1){
            roles.add("2");
            roles.add("3");
        }
        else{
            roles.add("3");
        }
        return roles;
    }

    /**
     * Home.
     */
    public void home() {
        reload();
    }

    /**
     * verifies the input of the add or edit action
     * @return whether the input is valid or not
     */
    private boolean inputVerification() {

        model.getEmployees();
        boolean uniqueUsername = true;


        for (Employee employee : employees) {
            if (employee.usernameProperty().get().equals(username.get())) {
                uniqueUsername = false;
            }
        }

        String specialCharacters = "[^\\w]";
        Pattern regexSpecial = Pattern.compile(specialCharacters);
        Matcher matcherSpecial = regexSpecial.matcher(password.get());

        String uppercase = "[A-Z]";
        Pattern regexUppercase = Pattern.compile(uppercase);
        Matcher matcherUppercase = regexUppercase.matcher(password.get());

        String lowercase = "[a-z]";
        Pattern regexLowercase = Pattern.compile(lowercase);
        Matcher matcherLowercase = regexLowercase.matcher(password.get());

        String digits = "[0-9]";
        Pattern regexDigits = Pattern.compile(digits);
        Matcher matcherDigits = regexDigits.matcher(password.get());

        //RFC 5322 General Email Regex Official Standard
        String validEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern regexEmail = Pattern.compile(validEmail);
        Matcher matcherEmail = regexEmail.matcher(email.get());

        if (firstname.get() == null || "".equals(firstname.get())) {
            registrationMessageLabel.setValue("Please input your first name");
            return false;
        } else if (lastname.get() == null || "".equals(lastname.get())) {
            registrationMessageLabel.setValue("Please input your last name");
            return false;
        } else if (username.get() == null || "".equals(username.get())) {
            registrationMessageLabel.setValue("Please input your username");
            return false;
        } else if (password.get() == null || "".equals(password.get())) {
            registrationMessageLabel.setValue("Please input your password");
            return false;
        } else if (confirmpassword.get() == null || "".equals(confirmpassword.get())) {
            registrationMessageLabel.setValue("Please input your password confirmation");
            return false;
        } else if (email.get() == null || email.get().equals("")) {
            registrationMessageLabel.set("Please input email");
            return false;
        } else if (!password.get().equals(confirmpassword.get())) {
            registrationMessageLabel.setValue("Please input matching passwords");
            return false;
        } else if (firstname.get().length() > 800) {
            registrationMessageLabel.set("Please input a first name with a maximum of 800 characters");
            return false;
        } else if (lastname.get().length() > 40) {
            registrationMessageLabel.set("Please input a last name with a maximum of 40 characters");
            return false;
        } else if (password.get().length() < 8) {
            registrationMessageLabel.set("Please input a password with a minimum length of 8 characters");
            return false;
        } else if (!matcherSpecial.find()) {
            registrationMessageLabel.set("Please input a password with at least one special character");
            return false;
        } else if (!matcherUppercase.find()) {
            registrationMessageLabel.set("Please input a password with at least one uppercase letter");
            return false;
        } else if (!matcherLowercase.find()) {
            registrationMessageLabel.set("Please input a password with at least one lowercase letter");
            return false;
        } else if (!matcherDigits.find()) {
            registrationMessageLabel.set("Please input a password with at least one digit");
            return false;
        } else if (!matcherEmail.matches()) {
            registrationMessageLabel.set("Please input a valid email");
            return false;
        } else if (branch.get() == null || branch.get().equals("")) {
            registrationMessageLabel.set("Please select a branch");
            return false;
        } else if (uniqueUsername == false) {
            registrationMessageLabel.set("Please input a unique username");
            return false;
        }
            else {
            for (Employee employee : employees) {
                if (employee.getName().equals(firstname.get()) && employee.getSurname().equals(lastname.get()) && String.valueOf(employee.getBranchId()).equals(branch.get()) && employee.getEmail().equals(email.get())
                        && String.valueOf(employee.getRoleId()).equals(role.get())) {
                    registrationMessageLabel.set("This employee already exists in the system");
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Register.
     */
    public void register() {
        if (inputVerification()) {
            model.createEmployee(
                    firstname.get(),
                    lastname.get(),
                    Integer.parseInt(role.get()),
                    Integer.parseInt(branch.get()),
                    username.get(),
                    password.get(),
                    email.get()
            );
            reload();

        } else {
            //shouldn't do anything
        }

    }

    /**
     * Default fields.
     */

    private void defaultFields() {
        firstname.setValue("");
        lastname.setValue("");
        username.setValue("");
        password.setValue("");
        confirmpassword.setValue("");
        registrationMessageLabel.setValue("");
        email.setValue("");
    }


    /**
     * goes back to the list, retrieves new data and sets all textfields to default
     */
    private void reload() {
        model.getEmployees();
        viewHandler.openEmployeeView();
        defaultFields();
    }

    /**
     * the edit action
     * @param id
     */
    public void onEdit(int id) {
        if (inputVerification()) {
            model.editEmployee(
                    id,
                    firstname.get(),
                    lastname.get(),
                    Integer.parseInt(role.get()),
                    Integer.parseInt(branch.get()),
                    username.get(),
                    password.get(),
                    email.get()
            );
            reload();
        } else {
            //shouldn't do anything
        }
    }

    /**
     * Firstname property string property.
     *
     * @return the string property
     */
    public StringProperty firstnameProperty() {
        return firstname;
    }

    /**
     * Lastname property string property.
     *
     * @return the string property
     */
    public StringProperty lastnameProperty() {
        return lastname;
    }

    /**
     * Role property string property.
     *
     * @return the string property
     */
    public StringProperty roleProperty() {
        return role;
    }

    /**
     * Branch property string property.
     *
     * @return the string property
     */
    public StringProperty branchProperty() {
        return branch;
    }

    /**
     * Email property string property.
     *
     * @return the string property
     */
    public StringProperty emailProperty() {
        return email;
    }

    /**
     * Username property string property.
     *
     * @return the string property
     */
    public StringProperty usernameProperty() {
        return username;
    }

    /**
     * Password property string property.
     *
     * @return the string property
     */
    public StringProperty passwordProperty() {
        return password;
    }

    /**
     * Confirm password property string property.
     *
     * @return the string property
     */
    public StringProperty confirmPasswordProperty() {
        return confirmpassword;
    }

    /**
     * Registration message label property string property.
     *
     * @return the string property
     */
    public StringProperty registrationMessageLabelProperty() {
        return registrationMessageLabel;
    }
}
