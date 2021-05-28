package client.core;

import client.viewmodel.*;
import server.database.BranchHandler;
import shared.personel.Employee;
/**
 * uses lazy instantiation to provide only one instance of each ViewModel
 * @author Dan, Tymon, Oliver
 */
public class ViewModelFactory {

    private LoginViewModel loginViewModel;
    private CarViewModel carViewModel;
    private RegistrationViewModel registrationViewModel;
    private FrontPageViewModel frontPageViewModel;
    private ModelFactory modelFactory;
    private ViewHandler viewHandler;
    private ReservationViewModel reservationViewModel;
    private BranchViewModel branchViewModel;
    private EmployeeViewModel employeeViewModel;
    private AddEditReservationViewModel addEditReservationViewModel;
    private AddEditBranchViewModel addEditBranchViewModel;
    private AddEditCarViewModel addEditCarViewModel;

    /**
     * public constructor
     * @param modelFactory ModelFactory to get model
     * @param viewHandler to open a scene
     */
    public ViewModelFactory(ModelFactory modelFactory, ViewHandler viewHandler) {
        this.modelFactory = modelFactory;
        this.viewHandler = viewHandler;
    }

    /**
     * if LoginViewModel is null returns new LoginViewModel(), else returns LoginViewModel
     * @return loginViewModel
     */
    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null) {
            loginViewModel = new LoginViewModel(modelFactory.getModel(), viewHandler);
        }
        return loginViewModel;
    }
    /**
     * if CarViewModel is null returns new CarViewModel(), else returns carViewModel
     * @return carViewModel
     */
    public CarViewModel getCarViewModel() {
        if (carViewModel == null) {

            carViewModel = new CarViewModel(modelFactory.getModel(), viewHandler);

        }
        return carViewModel;
    }
    /**
     * if FrontPageViewModel is null returns new FrontPageViewModel(), else returns frontPageViewModel
     * @return frontViewModel
     */
    public FrontPageViewModel getFrontPageController() {
        if (frontPageViewModel == null) {
            frontPageViewModel = new FrontPageViewModel(modelFactory.getModel(), viewHandler);
        }
        return frontPageViewModel;
    }
    /**
     * if RegistrationViewModel is null returns new RegistrationViewModel(), else returns registrationViewModel
     * @return registrationViewModel
     */
    public RegistrationViewModel getRegistrationViewModel() {
        if (registrationViewModel == null) {
            registrationViewModel = new RegistrationViewModel(modelFactory.getModel(), viewHandler);
        }
        return registrationViewModel;
    }
    /**
     * if ReservationViewModel is null returns new ReservationViewModel(), else returns reservationViewModel
     * @return reservationViewModel
     */
    public ReservationViewModel getReservationViewModel() {
        if (reservationViewModel == null) {
            reservationViewModel = new ReservationViewModel(modelFactory.getModel(), viewHandler);
        }
        return reservationViewModel;
    }
    /**
     * if BranchViewModel is null returns new BranchViewModel(), else returns branchViewModel
     * @return branchViewModel
     */
    public BranchViewModel getBranchViewModel() {
        if (branchViewModel == null) {
            branchViewModel = new BranchViewModel(modelFactory.getModel(), viewHandler);

        }
        return branchViewModel;
    }
    /**
     * if EmployeeViewModel is null returns new EmployeeViewModel(), else returns employeeViewModel
     * @return employeeViewModel
     */
    public EmployeeViewModel getEmployeeViewModel() {
        if (employeeViewModel == null) {
            employeeViewModel = new EmployeeViewModel(modelFactory.getModel(), viewHandler);
        }
        return employeeViewModel;
    }
    /**
     * if AddEditReservationViewModel is null returns new AddEditViewModel(), else returns addEditReservationViewModel
     * @return addEditReservationViewModel
     */
    public AddEditReservationViewModel getAddEditReservationViewModel() {
        if (addEditReservationViewModel == null) {
            addEditReservationViewModel = new AddEditReservationViewModel(modelFactory.getModel(), viewHandler);
        }
        return addEditReservationViewModel;
    }
    /**
     * if AddEditBranchViewModel is null returns new AddEditBranchViewModel(), else returns addEditBranchViewModel
     * @return addEditBranchViewModel
     */
    public AddEditBranchViewModel getAddEditBranchViewModel() {
        if (addEditBranchViewModel == null) {
            addEditBranchViewModel = new AddEditBranchViewModel(modelFactory.getModel(), viewHandler);
        }
        return addEditBranchViewModel;
    }
    /**
     * if AddEditCarViewModel is null returns new AddEditCarViewModel(), else returns addEditCarViewModel
     * @return addEditCarViewModel
     */
    public AddEditCarViewModel getAddEditCarViewModel() {
        if (addEditCarViewModel == null) {
            addEditCarViewModel = new AddEditCarViewModel(modelFactory.getModel(), viewHandler);
        }
        return addEditCarViewModel;
    }
}
