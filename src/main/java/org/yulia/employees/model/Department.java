package org.yulia.employees.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Department implements Serializable {

    private String departmentId;
    private String name;
    private final List<Employee> employees = new ArrayList<>();

    public Department() {
        super();
// TODO Auto-generated constructor stub
    }

    public Department(String departmentId, String name) {
        super();
        this.departmentId = departmentId;
        this.name = name;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((departmentId == null) ? 0 : departmentId.hashCode());
        return result;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Department other = (Department) obj;
        if (departmentId == null) {
            return other.departmentId == null;
        } else return departmentId.equals(other.departmentId);
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId + ", name=" + name + "]";
    }
}
