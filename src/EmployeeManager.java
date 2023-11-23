import java.util.*;

public class EmployeeManager implements Displayable {
    private List<Employee> employees;
    private Set<Integer> employeeIds;
    private FileHandler fileHandler;

    public EmployeeManager() {
        this.fileHandler = new FileHandler();
        this.employees = new ArrayList<>();
        this.employeeIds = new HashSet<>();

        // Load existing employees from the file
        List<Employee> loadedEmployees = fileHandler.loadData();
        for (Employee employee : loadedEmployees) {
            employees.add(employee);
            employeeIds.add(employee.getId());
        }
    }

    public void addEmployee(String name, int id, String position, double salary) {
        Employee newEmployee = new Employee(name, id, position, salary);

        if (!employeeIds.contains(newEmployee.getId())) {
            employees.add(newEmployee);
            employeeIds.add(newEmployee.getId());
            fileHandler.saveData(employees);
        } else {
            System.out.println("Employee with ID " + newEmployee.getId() + " already exists.");
        }
    }

    // Other methods...

    @Override
    public void display() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void addEmployee(Employee employee) {
    }
}
