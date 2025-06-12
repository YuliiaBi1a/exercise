package org.yulia.employees.ui;


import org.yulia.employees.daos.EmployeesDAO;
import org.yulia.employees.daos.EmployeesListDAO;
import org.yulia.employees.daos.EmployeesMapDAO;
import org.yulia.employees.daos.EmployeesSetDAO;
import org.yulia.employees.model.Department;
import org.yulia.employees.model.Employee;

public class EmployeesConsoleManager {

    private final EmployeesDAO employeesDAO = new EmployeesSetDAO();
    private final EmployeesDAO employeesDAO1 = new EmployeesListDAO();
    private final EmployeesDAO employeesDAO2 = new EmployeesMapDAO();


    public static void main(String[] args) {
        new EmployeesConsoleManager().go();
    }

    private void go() {
       generateData();
       printEmployees();
       testSet();
       testList();
       testMap();
    }

    private void generateData() {
        Department it = new Department("IT", "Information Technology");
        Department hr = new Department("HR", "Human Resources");

        Employee john = new Employee("123A", "John", "Doe", 30, 50000, it);
        Employee jane = new Employee("124B", "Jane", "Smith", 28, 52000, hr);
        Employee anotherJane = new Employee("124B", "Jane", "Smith", 28, 52000, hr);
        Employee ikran = new Employee("124B", "Inkran", "Garcia", 36, 25000, hr);

        employeesDAO.insertEmployee(john);
        employeesDAO.insertEmployee(jane);
        employeesDAO.insertEmployee(ikran);
        employeesDAO.insertEmployee(jane);
        employeesDAO.insertEmployee(anotherJane);
        employeesDAO.deleteEmployee(anotherJane.getNif());

        employeesDAO1.insertEmployee(john);
        employeesDAO1.insertEmployee(jane);
        employeesDAO1.insertEmployee(ikran);
        employeesDAO1.insertEmployee(jane);
        employeesDAO1.insertEmployee(anotherJane);
        employeesDAO1.deleteEmployee(anotherJane.getNif());

        employeesDAO2.insertEmployee(john);
        employeesDAO2.insertEmployee(jane);
        employeesDAO2.insertEmployee(ikran);
        employeesDAO2.insertEmployee(jane);
        employeesDAO2.insertEmployee(anotherJane);
        employeesDAO2.deleteEmployee(anotherJane.getNif());
    }

    private void printEmployees() {
//        employeesDAO
//                .getALlEmployees()
//                .forEach(System.out::println);
        for (Employee emp: employeesDAO.getALlEmployees()) {
            System.out.println(emp);
        }
    }

    private void testSet() {
        System.out.println("------------------------------" +
                "\nEmployee set test");
        System.out.println("Search: " + employeesDAO.getEmployee("123A"));
        System.out.println("Search: " + employeesDAO.getEmployee("jane"));
        System.out.println("Search: " + employeesDAO.getEmployee(null));
        System.out.println(employeesDAO.getALlEmployees());
    }

    private void testList() {
        System.out.println("------------------------------" +
                "\nEmployee list test");
        System.out.println("Search: " + employeesDAO1.getEmployee("123A"));
        System.out.println("Search: " + employeesDAO1.getEmployee("jane"));
        System.out.println("Search: " + employeesDAO1.getEmployee(null));
        System.out.println(employeesDAO1.getALlEmployees());
    }

    private void testMap() {
        System.out.println("------------------------------" +
                "\nEmployee map test");
        System.out.println("Search: " + employeesDAO2.getEmployee("123A"));
        System.out.println("Search: " + employeesDAO2.getEmployee("jane"));
        System.out.println("Search: " + employeesDAO2.getEmployee(null));
        System.out.println(employeesDAO2.getALlEmployees());
    }
}
