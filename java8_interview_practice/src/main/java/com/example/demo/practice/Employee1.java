package com.example.demo.practice;

import java.util.*;
import java.util.stream.Collectors;

class Employee1 {
    private int id;
    private String name;
    private String department;
    private double salary;
    private int yearOfJoining;

    public Employee1(int id, String name, String department, double salary, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.yearOfJoining = yearOfJoining;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getYearOfJoining() { return yearOfJoining; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", yearOfJoining=" + yearOfJoining +
                '}';
    }
}
