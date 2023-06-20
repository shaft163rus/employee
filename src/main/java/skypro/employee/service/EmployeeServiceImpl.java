package skypro.employee.service;

import org.springframework.stereotype.Service;
import skypro.employee.exceptions.EmployeeAlreadyAddedException;
import skypro.employee.exceptions.EmployeeNotFoundException;
import skypro.employee.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service

public class EmployeeServiceImpl implements EmployeeService {

    private final int MAX_EMPLOYEES_COUNT = 10;

    private final List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        if(employeeList.contains(employee)){
            throw new EmployeeAlreadyAddedException("Employee already added");
        }
        employeeList.add(employee);


        return employee;

    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }


        throw new EmployeeNotFoundException("Employee not found");

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public List<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}
