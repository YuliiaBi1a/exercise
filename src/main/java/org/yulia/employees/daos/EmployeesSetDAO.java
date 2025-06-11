package org.yulia.employees.daos;


import org.yulia.employees.model.Employee;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EmployeesSetDAO implements EmployeesDAO{

    private final Set<Employee> employeeSet = new HashSet<>();

    @Override
    public void insertEmployee(Employee employee) {
        employeeSet.add(employee);
    }

    @Override
    public Employee getEmployee(String nif) {
        Iterator<Employee> empSetIterator = employeeSet.iterator();
        while (empSetIterator.hasNext()) {
            Employee currentEmp = empSetIterator.next();
            if (currentEmp.getNif().equalsIgnoreCase(nif)) {
                return currentEmp;
            }
        }
        return null;
    }

    @Override
    public Collection<Employee> getALlEmployees() {
        return employeeSet;
        //return new ArrayList<>(employeeSet);
    }
}
