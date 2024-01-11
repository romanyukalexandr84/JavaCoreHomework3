package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Employee implements Comparable<Employee> {
    private String fio;
    private String position;
    private int phone;
    private int salary;
    private int age;
    private Date birthdate;

    public Employee(String fio, String position, int phone, int salary, int age, Date birthdate) {
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        this.birthdate = birthdate;
    }

    public Employee(int salary, int age, Date birthdate) {
        this.fio = "default";
        this.position = "default";
        this.phone = 100;
        this.salary = salary;
        this.age = age;
        this.birthdate = birthdate;
    }

    public static void changeSalary(ArrayList<Employee> employees, int age, int increase) {
        for (Employee item : employees) {
            if (item.getAge() > age) {
                item.setSalary(item.getSalary() + increase);
            }
        }
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", age=" + age +
                ", birthdate=" + new SimpleDateFormat("yyyy-MM-dd").format(this.birthdate) +
                '}';
    }

    public void info() {
        System.out.println(this.toString());
    }

    public void info_format() {
        System.out.println(String.format("%s", this.toString()));
    }

    @Override
    public int compareTo(Employee o) {
        return this.getBirthdate().compareTo(o.getBirthdate());
    }
}
