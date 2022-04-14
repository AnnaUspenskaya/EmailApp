/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.controller;

import com.mycompany.email.dao.EmailDao;
import com.mycompany.email.dao.EmployeePersistenceException;
import com.mycompany.email.dao.EmailDaoFileImpl;
import com.mycompany.email.dto.Employee;
import com.mycompany.email.service.EmailServiceLayer;
import com.mycompany.email.service.EmployeeDataValidationException;
import com.mycompany.email.ui.EmailView;
import com.mycompany.email.ui.UserIO;
import com.mycompany.email.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author anechka
 */
public class EmailController {

    UserIO io = new UserIOConsoleImpl();

    //EmailView view = new EmailView();
    //EmailDao dao = new EmailDaoFileImpl();
    // Dependency Injection
private EmailView view;
private EmailServiceLayer service;

    public EmailController(EmailServiceLayer service, EmailView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listEmployee();
                        break;
                    case 2:
                        createEmployee();
                        break;
                    case 3:
                        viewEmployee();
                        break;
                    case 4:
                        removeEmployee();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();            

                }

            }
            exitMessage();

        } catch (EmployeePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createEmployee() throws EmployeePersistenceException {
        view.displayCreateEmployeeBanner();
        boolean hasErrors = false; 
        do{
                    Employee newEmployee = view.getNewEmployeeInfo();

        try {
            service.addEmployee(newEmployee);
            view.displayCreateSuccessBanner();
            hasErrors =false;
        }catch (EmployeeDataValidationException e){
            hasErrors = true;
            view.displayErrorMessage(e.getMessage());
        }
    }while(hasErrors);
}
       

    private void listEmployee() throws EmployeePersistenceException {
        view.displayAllBanner();
        List<Employee> empList = service.getAllEmployees();
        view.displayEmployeeList(empList);
    }

    private void viewEmployee() throws EmployeePersistenceException {
        view.displayEmployeeBanner();
        String id = view.getEmployeeIdChoice();
        Employee emp = service.getEmployee(id);
        view.displayEmployee(emp);
    }

    private void removeEmployee() throws EmployeePersistenceException {
        view.displayRemoveEmployeeBanner();
        String employeeId = view.getEmployeeIdChoice();
        service.removeEmployee(employeeId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
