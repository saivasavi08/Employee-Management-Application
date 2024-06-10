import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private String department;

    public Employee(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}

public class EmployeeManagementApplication {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Employee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }

    private static void addEmployee() {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        Employee employee = new Employee(name, id, department);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private static void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found!");
        } else {
            System.out.println("List of all employees:");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                found = true;
                System.out.print("Enter new name for employee: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new department for employee: ");
                String newDepartment = scanner.nextLine();

                employee.setName(newName);
                employee.setDepartment(newDepartment);
                System.out.println("Employee details updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean removed = employees.removeIf(employee -> employee.getId() == id);
        if (removed) {
            System.out.println("Employee with ID " + id + " deleted successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }
}
