package com.psmc.staff.controller;

import com.psmc.staff.model.EmployeeDTO;
import com.psmc.staff.model.EmployeeService;
import com.psmc.staff.model.EmployeeToMedicalFieldDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        List<EmployeeDTO> employeeList = employeeService.findAllEmployee();

        model.addAttribute("employeeList", employeeList);

        return "/employee/list";
    }

    @GetMapping("/search")
    public String searchByParam(@RequestParam Map<String,String> parameter, Model model) {

       List<EmployeeToMedicalFieldDTO> employeeList= employeeService.findMemberByFieldCode(parameter);

       model.addAttribute("employeeList",employeeList);

       
       for(EmployeeToMedicalFieldDTO e: employeeList){
           System.out.println("e = " + e);
       }


        return "/employee/search";
    }

}
