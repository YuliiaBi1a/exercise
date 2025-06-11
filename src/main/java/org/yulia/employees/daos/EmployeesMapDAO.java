package org.yulia.employees.daos;


import org.yulia.employees.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EmployeesMapDAO implements EmployeesDAO {

    private final Map<Integer, Employee> employeeMap = new HashMap<>();
    private static int counterEmp = 0;

    @Override
    public void insertEmployee(Employee employee) {
        employeeMap.put(counterEmp++, employee);
    }

    @Override
    public Employee getEmployee(String nif) {
        Iterator<Employee> employeeIterator = employeeMap.values().iterator();
        while (employeeIterator.hasNext()) {
            if (employeeIterator.next().getNif().equalsIgnoreCase(nif)) {
                return employeeIterator.next();
            }
        }
        return null;
    }

    @Override
    public Collection<Employee> getALlEmployees() {
        return employeeMap.values();
    }
}
