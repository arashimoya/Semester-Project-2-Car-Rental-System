package client.views.EmployeeView;


import client.viewmodel.EmployeeViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shared.personel.Employee;


/**
 * The Employee view controller.
 * @author Adam
 */
public class EmployeeViewController {

    private EmployeeViewModel employeeViewModel;

    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button addButton;
    @FXML
    private Button backButton;

    @FXML
    private TableView<Employee> employee_tableview;
    @FXML
    private TableColumn<Employee, Number> column_id;
    @FXML
    private TableColumn<Employee, String> column_name;
    @FXML
    private TableColumn<Employee, String> column_surname;
    @FXML
    private TableColumn<Employee, String> column_branch;
    @FXML
    private TableColumn<Employee, String> column_username;
    @FXML
    private TableColumn<Employee, Number> column_role;
    @FXML
    private TableColumn<Employee, String> column_email;

    /**
     * Init.
     *
     * @param employeeViewModel the employee view model
     */
    public void init(EmployeeViewModel employeeViewModel) {
        employee_tableview.getItems().clear();
        this.employeeViewModel = employeeViewModel;
        column_id.setCellValueFactory(cellData -> (cellData.getValue().idProperty()));
        column_name.setCellValueFactory(cellData -> (cellData.getValue().nameProperty()));
        column_branch.setCellValueFactory(cellData -> (cellData.getValue().branchIdProperty()));
        column_surname.setCellValueFactory(cellData -> (cellData.getValue().surnameProperty()));
        column_email.setCellValueFactory(cellData -> (cellData.getValue().emailProperty()));
        column_username.setCellValueFactory(cellData -> (cellData.getValue().surnameProperty()));
        column_role.setCellValueFactory(cellData -> (cellData.getValue().roleProperty()));
        employee_tableview.setItems(employeeViewModel.getEmployees());
    }


    /**
     * Open add view.
     *
     * @param actionEvent the action event
     */
    public void openAddView(ActionEvent actionEvent) {
        employeeViewModel.openRegistrationView();
    }

    /**
     * Delete action.
     */
    public void deleteAction () {
        if (employee_tableview.getSelectionModel().getSelectedItems().get(0) != null)
        employeeViewModel.deleteAction(employee_tableview.getSelectionModel().getSelectedItems().get(0).getId());
    }

    /**
     * Open edit view.
     *
     * @param actionEvent the action event
     */
    public void openEditView(ActionEvent actionEvent) {
        if (employee_tableview.getSelectionModel().getSelectedItems().get(0) != null) {
            Employee selectedEmployee = employee_tableview.getSelectionModel().getSelectedItems().get(0);
            employeeViewModel.openEditView(selectedEmployee);
        }

    }

    /**
     * Back.
     *
     * @param actionEvent the action event
     */
    public void back(ActionEvent actionEvent) {
        employeeViewModel.home();
    }

}
