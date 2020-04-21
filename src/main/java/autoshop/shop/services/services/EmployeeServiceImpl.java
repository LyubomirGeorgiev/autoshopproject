package autoshop.shop.services.services;

import autoshop.shop.data.entities.Employee;
import autoshop.shop.data.repositories.EmployeeRepository;
import autoshop.shop.services.models.EmployeeServiceModel;
import autoshop.shop.services.models.EmployeeViewServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Employee addEmployee(EmployeeServiceModel employeeServiceModel) {

        Employee employee = this.modelMapper.map(employeeServiceModel, Employee.class);

        employee.setEmployeeNumber((int) (this.employeeRepository.count() + 1));
        employee.setHireDate(new Date());

        return this.employeeRepository.saveAndFlush(employee);
    }

    @Override
    public List<EmployeeViewServiceModel> getAllEmployees() {

        List<EmployeeViewServiceModel> employees = this.employeeRepository
                .findAll()
                .stream()
                .map(e -> this.modelMapper.map(e, EmployeeViewServiceModel.class))
                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeByEmployeeNumber(int employeeNumber) {

        return this.employeeRepository.findByEmployeeNumber(employeeNumber);
    }
}
