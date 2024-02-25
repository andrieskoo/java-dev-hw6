package org.example.DTO;

public class MaxSalaryWorker {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public MaxSalaryWorker() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
