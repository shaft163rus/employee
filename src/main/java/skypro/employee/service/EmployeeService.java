package skypro.employee.service;


import skypro.employee.model.Employee;

import java.util.List;


public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);


    Employee deleteEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> findAll();
}
