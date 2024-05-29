package EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.entity.Employee;
import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.services.EmployeeServices;
import jakarta.validation.Valid;

@Controller
public class EmployeeController {
@Autowired
	private EmployeeServices employeeServices;
@GetMapping("/empReg")
public String getRegEmp(Model model) {
	model.addAttribute("employee",new Employee());
	return "empReg";
	
}
@PostMapping("/status")
public String getStatus(@Valid @ModelAttribute ("employee") Employee employee , BindingResult bindingResult) {
	if(bindingResult.hasErrors()) {
		return "empReg";
		
	}
	employeeServices.saveRegistered(employee);

		return "redirect:/employeelogin";


	
}
	
}
