/*
 * To change this license header, choose License Headers in Project Properties.
"Enter the Department code \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none\n Department code: " * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.email.ui;

import com.mycompany.email.dto.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anechka
 */
public class EmailView {

    UserIO io;

    public EmailView(UserIO io) {
        this.io = io;
    }

    int idNum = 0;

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Employees");
        io.print("2. Create New Employee");
        io.print("3. View an Employee");
        io.print("4. Remove an Employee");
        io.print("5. Update an Employee");
        io.print("6. Exit");

        return io.readInt("Please select form the above choices", 1, 6);
    }

    public Employee getNewEmployeeInfo() {
        String firstName = io.readString("▶ Please enter First Name");
        String lastName = io.readString("▶ Please Enter Last Name");
        int depCode = io.readInt("\n ▶ Enter the Department code "
                + "\n1 for Sales "
                + "\n2 for Development "
                + "\n3 for Accounting "
                + "\n Department code: ");
        String department = departmentChoice(depCode);
        String EmpId = department.substring(0, 3) + "0" + String.valueOf(idNum);
        Employee currentEmployee = new Employee(EmpId);
        currentEmployee.setDepartment(department);
        currentEmployee.setFirstName(firstName.trim());
        currentEmployee.setLastName(lastName.trim());
        currentEmployee.setEmail(currentEmployee.getFirstName().trim() + "." + currentEmployee.getLastName().trim() + "@" + currentEmployee.getDepartment() + ".mycompany.com");
        currentEmployee.setPassword(randomPassword());
        currentEmployee.setEmployeeId(EmpId);
        idNum++;
        displayEmployee(currentEmployee);
        return currentEmployee;

    }

    public Employee updateEmpl( Employee emp) {
    
        String firstName = io.readString("▶ Please Enter first Name. (Current name: " + emp.getFirstName() + ")");
        String lastName = io.readString("▶ Please Enter last Name. (Current last name: " + emp.getLastName() + ")");
        int depCode = io.readInt("\n ▶ Enter the Department code "
                + "\n1 for Sales "
                + "\n2 for Development "
                + "\n3 for Accounting "
                + "\n Department code:  (Current department: " + emp.getDepartment() + ")");
        String department = departmentChoice(depCode);
        String EmpId = department.substring(0, 3) + "0" + String.valueOf(idNum);
        Employee currentEmployee = new Employee(EmpId);
        currentEmployee.setDepartment(department);
        currentEmployee.setFirstName(firstName);
        currentEmployee.setLastName(lastName);
        currentEmployee.setEmail(currentEmployee.getFirstName().trim() + "." + currentEmployee.getLastName().trim() + "@" + currentEmployee.getDepartment() + ".mycompany.com");
        currentEmployee.setPassword(randomPassword());
        currentEmployee.setEmployeeId(EmpId);
        idNum++;
        displayEmployee(currentEmployee);
        return currentEmployee;

    }
//    private String email(String id, String dep ){
//        Employee currentEmployee = new Employee(id);
//        String dep= currentEmployee.getDepartment();
//    }

    private String randomPassword() {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&";
        char[] password = new char[10];
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public String departmentChoice(int depCode) {
        //return io.readInt("Please select form the above choices", 1, 3);
        String dep = "";
        switch (depCode) {
            case 1:
                dep = "sales";
                break;
            case 2:
                dep = "development";
                break;
            case 3:
                dep = "accounting";
                break;
            default:
                dep = "UNKNOWN COMMAND";
        }
        return dep;
    }

    public void displayEmployeeList(List<Employee> employeeList) {
        if (employeeList.isEmpty()) {
            io.print("There is no employee in the company yet");
            io.print("☹");

        } else {
            for (Employee currentEmployee : employeeList) {
 io.print(currentEmployee.getEmployeeId() + ": "
                        + currentEmployee.getFirstName() + " " + currentEmployee.getLastName()
                );
            }
        }

        io.readString("Please hit enter to continue");
    }

    public String getEmployeeIdChoice() {
        return io.readString("▶▶▶Please enter employee ID◀◀◀");
    }

    public void displayEmployee(Employee employee) {
        if (employee != null) {
            io.print("ID: " + employee.getEmployeeId());
            io.print("Name: " + employee.getFirstName() + " " + employee.getLastName());
            io.print("Emal: " + employee.getEmail());
            io.print("Email password: " + employee.getPassword());

        } else {
            io.print("No such employee");
        }
        io.readString("Please hit enter to continue.");
    }

    //ALL THE BANNERS
    public void displayCreateEmployeeBanner() {
        io.print("▶▶▶ Create Employee ◀◀◀ \n");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                " █ █ █ Employee successfully created █ █ █  \n Please hit enter to continue");
    }

    public void displayAllBanner() {
        io.print("▶▶▶ Dsplay All Employee ◀◀◀ \n");
    }

    public void displayEmployeeBanner() {
        io.print("▶▶▶ Dsplay Employee ◀◀◀ \n");
    }

    public void displayRemoveEmployeeBanner() {
        io.print("▶▶▶ Remove Employee ◀◀◀ \n");
    }

    public void displayUpdateEmployeeBanner() {
        io.print("▶▶▶ Update Employee ◀◀◀ \n");
    }

    public void displayUpdateSuccessBanner() {
        io.readString(
                " █ █ █ Employee successfully updated █ █ █  \n Please hit enter to continue");
    }

    public void displayRemoveSuccessBanner() {
        io.readString(
                " █ █ █ Employee successfully removed █ █ █  \n Please hit enter to continue");
    }

    public void displayExitBanner() {
        io.print("Have a great day!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
