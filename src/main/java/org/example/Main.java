package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void changeSalary(ArrayList<Employee> arr) {
        for (Employee item : arr) {
            if (item.getAge() > 45) {
                item.setSalary(item.getSalary() + 5000);
            }
        }
    }

    public static void changeSalary(ArrayList<Employee> arr, int age, int increase) {
        for (Employee item : arr) {
            if (item.getAge() > age) {
                item.setSalary(item.getSalary() + increase);
            }
        }
    }

    public static void printAverages(ArrayList<Employee> employees) {
        int avAge = 0;
        int avSalary = 0;
        for (Employee item : employees) {
            avAge += item.getAge();
            avSalary += item.getSalary();
        }
        System.out.println("Средний возраст равен: " + avAge / employees.size());
        System.out.println("Средняя зарплата равна: " + avSalary / employees.size());
    }

    public static void main(String[] args) throws ParseException {
        employees.add(new Employee(10000, 25, new SimpleDateFormat("yyyy-MM-dd").parse("1999-05-12")));
        employees.add(new Employee(50000, 55, new SimpleDateFormat("yyyy-MM-dd").parse("1969-10-22")));
        employees.add(new Employee(12000, 30, new SimpleDateFormat("yyyy-MM-dd").parse("1994-07-18")));
        employees.add(new Employee(30000, 40, new SimpleDateFormat("yyyy-MM-dd").parse("1984-11-04")));
        employees.add(new Employee(10000, 35, new SimpleDateFormat("yyyy-MM-dd").parse("1989-01-14")));

        changeSalary(employees);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }
        System.out.println();

        changeSalary(employees, 30, 2500);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }
        System.out.println();

        Employee.changeSalary(employees, 30, 1200);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }

        printAverages(employees);
        System.out.println();

        employees.sort(Employee::compareTo);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }
        System.out.println();

        employees.add(new Manager(40000, 42, new SimpleDateFormat("yyyy-MM-dd").parse("1982-03-28")));
        Manager.increaseSalary(employees, 10000);
        for (Employee item : employees) {
            System.out.println(item.toString());
        }

    }
}