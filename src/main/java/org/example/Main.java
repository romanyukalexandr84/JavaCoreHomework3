package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

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
        System.out.println();

        students.add(new Student("Иван", Arrays.asList(5.3, 4.5, 3.8), "Информатика"));
        students.add(new Student("Петр", Arrays.asList(4.3, 4.0, 2.8), "Математика"));
        students.add(new Student("Михаил", Arrays.asList(5.3, 5.5, 5.8), "Информатика"));
        students.add(new Student("Алексей", Arrays.asList(5.3, 5.5, 5.8), "Дизайн"));
        students.add(new Student("Степан", Arrays.asList(5.3, 4.5, 1.8), "Информатика"));
        students.add(new Student("Григорий", Arrays.asList(5.3, 3.5, 3.2), "Маркетинг"));
        students.add(new Student("Александр", Arrays.asList(4.4, 5.0, 5.0), "Информатика"));
        students.add(new Student("Сергей", Arrays.asList(4.2, 4.0, 5.8), "Экономика"));
        students.add(new Student("Тимофей", Arrays.asList(5.3, 4.5, 4.9), "Информатика"));
        students.add(new Student("Артем", Arrays.asList(3.3, 3.5, 3.8), "Юриспруденция"));
        students.add(new Student("Денис", Arrays.asList(5.6, 5.5, 5.8), "Информатика"));
        students.add(new Student("Николай", Arrays.asList(4.3, 4.9, 4.9), "Информатика"));

        List<String> bestStudents = students.stream()
                .sorted()
                .filter(e -> e.getAverageGrade() > 4.5 && e.getSpecialty().equals("Информатика"))
                .limit(5)
                .map(e -> {
                    return e.getName() + " " + String.format("ср.балл = %.2f", e.getAverageGrade());
                })
                .toList();

        System.out.println(bestStudents);
    }
}