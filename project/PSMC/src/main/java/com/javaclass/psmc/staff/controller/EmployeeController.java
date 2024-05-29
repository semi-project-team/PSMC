package com.javaclass.psmc.staff.controller;

import com.javaclass.psmc.common.model.dto.MedicalFieldDTO;
import com.javaclass.psmc.common.model.method.MakePhoneNumber;
import com.javaclass.psmc.staff.model.dto.EmployeeFieldPositionDTO;
import com.javaclass.psmc.staff.model.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
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
    private MakePhoneNumber makePhoneNumber=new MakePhoneNumber();

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/staff/list")
    public String findEmployeeList(Model model, HttpSession session) {

        List<EmployeeFieldPositionDTO> employeeList = employeeService.findAllEmployee();

        for (EmployeeFieldPositionDTO employeeDTO : employeeList) {
            System.out.println("employeeDTO = " + employeeDTO);
        }

        for(EmployeeFieldPositionDTO e: employeeList){
            e.setPhone(makePhoneNumber.formatPhoneNumber(e.getPhone()));
        }
        
        List<MedicalFieldDTO> allField = employeeService.findAllField();
        session.setAttribute("allField", allField);



        model.addAttribute("allField", allField);
        model.addAttribute("employeeList", employeeList);

        return "/staff/list";
    }

    @GetMapping("/searchByCondition")
    public String searchByParam(@RequestParam Map<String, String> parameter, Model model, RedirectAttributes redirect, HttpSession session) {

        System.out.println("parameter = " + parameter);
        List<EmployeeFieldPositionDTO> employeeList = employeeService.findMemberByFieldCode(parameter);
        if (employeeList.size() == 0) {
            redirect.addFlashAttribute("isNull", true);
            return "redirect:/staff/list";
        }

        List<MedicalFieldDTO> allField = (List<MedicalFieldDTO>) session.getAttribute("allField");

        for(EmployeeFieldPositionDTO e: employeeList){
            e.setPhone(makePhoneNumber.formatPhoneNumber(e.getPhone()));
        }

        model.addAttribute("allField", allField);
        model.addAttribute("employeeList", employeeList);
        System.out.println("employeeList = " + employeeList);

//        for(EmployeeFieldPositionDTO e: employeeList){
//            System.out.println("e = " + e);
//        }

        return "/staff/search";
    }

    @GetMapping("/search")
    public String searchByParam2(@RequestParam Map<String, String> parameter, Model model, RedirectAttributes redirect, HttpSession session) {

        System.out.println("parameter = " + parameter);
        List<EmployeeFieldPositionDTO> employeeList = employeeService.findMemberByFieldCode(parameter);
        if (employeeList.size() == 0) {
            redirect.addFlashAttribute("isNull", true);
            return "redirect:/staff/list";
        }

        List<MedicalFieldDTO> allField = (List<MedicalFieldDTO>) session.getAttribute("allField");

        for(EmployeeFieldPositionDTO e: employeeList){
            e.setPhone(makePhoneNumber.formatPhoneNumber(e.getPhone()));
        }

        model.addAttribute("allField", allField);
        model.addAttribute("employeeList", employeeList);
        System.out.println("employeeList = " + employeeList);

//        for(EmployeeFieldPositionDTO e: employeeList){
//            System.out.println("e = " + e);
//        }

        return "/staff/search";
    }
}