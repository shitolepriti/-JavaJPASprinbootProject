package EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.entity.Employee;
import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.entity.repository.EmployeeRepository;
@Service
public class EmployeeServiceimplementation implements EmployeeServices {
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public EmployeeServiceimplementation(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveRegistered(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> employeeList() {
		List<Employee>findAll=employeeRepo.findAll();
		return findAll;

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee>	findById=employeeRepo.findById(id);
		Employee employee=findById.get();
			return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

}
