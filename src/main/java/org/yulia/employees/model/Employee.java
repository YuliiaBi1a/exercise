package org.yulia.employees.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

    private String nif;
    private String name;
    private String surname;
    private int age;
    private double salary;
    private Department department;

    public Employee() {
        super();
// TODO Auto-generated constructor stub
    }

    public Employee(String nif, String name, String surname, int age, double salary, Department department) {
        super();
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return nif.equals(employee.nif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif);
    }

    //getEmploye - iterate through the set
    //if we find an employee with that nif, we return it, else null
    //*create new employee with that nif
    //or iterator, hasnext, etc
    //create empDaoList and map
}
