package EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Integer>{

}
