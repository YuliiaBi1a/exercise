package org.yulia.employees.daos;


import org.yulia.employees.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeesListDAO implements EmployeesDAO {

    private final List<Employee> employeeList = new ArrayList<>();

    @Override
    public void insertEmployee(Employee employee) {
        employeeList.add(employee);
    }

    @Override
    public Employee getEmployee(String nif) {
        return employeeList.stream()
                .filter(employee -> employee.getNif().equalsIgnoreCase(nif))
                .findFirst()
                .orElse(null);
//        for (Employee emp: employeeList) {
//            if (emp.getNif().equalsIgnoreCase(nif)) {
//                return emp;
//            }
//        }
//        return null;
    }

    @Override
    public Collection<Employee> getALlEmployees() {
        return employeeList;
    }
}
