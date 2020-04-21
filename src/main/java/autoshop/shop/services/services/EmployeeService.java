package autoshop.shop.services.services;

import autoshop.shop.data.entities.Employee;
import autoshop.shop.services.models.EmployeeServiceModel;
import autoshop.shop.services.models.EmployeeViewServiceModel;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(EmployeeServiceModel employeeServiceModel);

    List<EmployeeViewServiceModel> getAllEmployees();

    Employee getEmployeeByEmployeeNumber(int employeeNumber);
}
