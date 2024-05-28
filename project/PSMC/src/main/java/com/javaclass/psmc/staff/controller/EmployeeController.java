package com.javaclass.psmc.staff.controller;

import com.javaclass.psmc.common.model.dto.MedicalFieldDTO;
import com.javaclass.psmc.staff.model.dto.EmployeeFieldPositionDTO;
import com.javaclass.psmc.staff.model.dto.EmployeeToMedicalFieldDTO;
import com.javaclass.psmc.staff.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/staff/list")
    public String findEmployeeList(Model model){

        List<EmployeeFieldPositionDTO> employeeList = employeeService.findAllEmployee();

        for(EmployeeFieldPositionDTO employeeDTO : employeeList){
            System.out.println("employeeDTO = " + employeeDTO)                                                                                                                                                  ;
        }

        List<MedicalFieldDTO> allField = employeeService.findAllField();

        model.addAttribute("medicalField",allField);
        model.addAttribute("employeeList", employeeList);

        return "/staff/list";
    }

    @GetMapping("/search")
    public String searchByParam(@RequestParam Map<String,String> parameter, Model model, RedirectAttributes redirect) {

        System.out.println("parameter = " + parameter);
        List<EmployeeToMedicalFieldDTO> employeeList= employeeService.findMemberByFieldCode(parameter);
        if(employeeList.size() == 0) {
            redirect.addFlashAttribute("isNull", true);
            return "redirect:/staff/list";
        }
        model.addAttribute("employeeList",employeeList);
        System.out.println("employeeList = " + employeeList);

        for(EmployeeToMedicalFieldDTO e: employeeList){
            System.out.println("e = " + e);
        }

        return "/staff/search";
    }

}
