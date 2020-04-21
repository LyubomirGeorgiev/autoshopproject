package autoshop.shop.data.repositories;

import autoshop.shop.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Employee findByEmployeeNumber(int employeeNumber);
}
