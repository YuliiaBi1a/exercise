package org.yulia.employees.daos;



import org.yulia.employees.model.Employee;

import java.util.Collection;

public interface EmployeesDAO {

    public abstract void insertEmployee(Employee employee);
    public abstract Employee getEmployee(String nif);
    public abstract Collection<Employee> getALlEmployees();
}
