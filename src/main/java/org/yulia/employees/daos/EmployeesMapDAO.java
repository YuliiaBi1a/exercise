package org.yulia.employees.daos;


import org.yulia.employees.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EmployeesMapDAO implements EmployeesDAO {

    private final Map<String, Employee> employeeMap = new HashMap<>();
//    private static int counterEmp = 0;

    @Override
    public void insertEmployee(Employee employee) {
        employeeMap.put(employee.getNif(), employee);
    }

    @Override
    public Employee getEmployee(String nif) {
        for (Employee employee : employeeMap.values()) {
            if (employee.getNif().equalsIgnoreCase(nif)) {
                return employee;
            }
        }
        return null;
//        Iterator<Employee> employeeIterator = employeeMap.values().iterator();
//        while (employeeIterator.hasNext()) {
//            Employee employee = employeeIterator.next();
//            if (employee.getNif().equalsIgnoreCase(nif)) {
//                return employee;
//            }
//        }
//        return null;
    }


    @Override
    public Collection<Employee> getALlEmployees() {
        return employeeMap.values();
    }

    @Override
    public boolean deleteEmployee(String nif) {
        return employeeMap.remove(nif) != null;
    }
}
