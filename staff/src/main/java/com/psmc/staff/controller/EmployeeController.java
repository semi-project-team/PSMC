package com.psmc.staff.controller;

import com.psmc.staff.model.EmployeeDTO;
import com.psmc.staff.model.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String findEmployeeList(Model model){

        List<EmployeeDTO> EmployeeList = employeeService.findAllEmployee();

        model.addAttribute("employeeList", EmployeeList);

        return "employee/list";
    }

}
