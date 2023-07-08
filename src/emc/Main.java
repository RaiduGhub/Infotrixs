package emc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}

class ManagementSystem {
    private List<Employee> employees;

    public ManagementSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(int employeeId) {
        Employee employeeToRemove = null;
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void updateEmployeeSalary(int employeeId, double newSalary) {
        boolean employeeFound = false;
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                employee.setSalary(newSalary);
                employeeFound = true;
                System.out.println("Employee salary updated successfully.");
                break;
            }
        }
        if (!employeeFound) {
            System.out.println("Employee not found.");
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagementSystem managementSystem = new ManagementSystem();

        while (true) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    Employee employee = new Employee(id, name, salary);
                    managementSystem.addEmployee(employee);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    managementSystem.removeEmployee(removeId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to update salary: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine();
                    managementSystem.updateEmployeeSalary(updateId, newSalary);
                    break;
                case 4:
                    managementSystem.displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
