package EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.entity.EmpHome;
import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.entity.Employee;
import EmployeeDirectory.FinalpracticalExamDemo.EmployeeDirectory.services.EmployeeServices;
import jakarta.validation.Valid;

@Controller
public class EmpLogin {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employeelogin")
    public String getLogin(Model model) {
        model.addAttribute("emphome", new EmpHome());
        return "empHome";
    }

    @PostMapping("/loginstatus")
    public String getLogStatus(@Valid @ModelAttribute("emphome") EmpHome emphome, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "empHome";
        }

        List<Employee> dbemployee = employeeServices.employeeList();
        boolean found = false;

        for (Employee em : dbemployee) {
            String username = em.getUsername();
            String password = em.getPassword();
            
            if (username != null && username.equals(emphome.getUsername()) &&
                password != null && password.equals(emphome.getPassword())) {
                found = true;
                break;
            }
        }

        if (found) {
            return "redirect:/employeelist";
        } else {
            model.addAttribute("error", "Incorrect username or password");
            return "empHome";
        }
    }
}
