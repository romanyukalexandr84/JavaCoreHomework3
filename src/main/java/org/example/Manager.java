package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Manager extends Employee {

    public Manager(String fio, String position, int phone, int salary, int age, Date birthdate) {
        super(fio, position, phone, salary, age, birthdate);
    }

    public Manager(int salary, int age, Date birthdate) {
        super(salary, age, birthdate);
    }

    public static void increaseSalary(ArrayList<Employee> employees, int increase) {
        for (Employee item : employees) {
            if (!(item instanceof Manager)) {
                item.setSalary(item.getSalary() + increase);
            }
        }
    }
}
