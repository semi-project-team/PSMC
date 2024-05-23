package com.javaclass.psmc.mypage.model.service;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.dto.MemberRegistDTO;
import com.javaclass.psmc.mypage.model.dao.EditMapper;
import com.javaclass.psmc.mypage.model.dto.EditDTO;
import com.javaclass.psmc.mypage.model.dto.ProfileFroEditDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EditService {

    private final EditMapper editMapper;

    @Autowired
    public EditService(EditMapper editMapper) {this.editMapper=editMapper;}


    public int updateEmployee(EditDTO editDTO) {
        return editMapper.updateEmployee(editDTO);
    }

    public int updateRegist(EditDTO editDTO) {
        return editMapper.updateRegist(editDTO);
    }

    public EmployeeDTO employeeDetail(Map<String, Object> params) {
        return editMapper.employeeDetail(params);
    }

    public MemberRegistDTO memberRegistDetail(Map<String, Object> params) {
        return editMapper.memberRegistDetail(params);
    }

    public ProfileFroEditDTO findInfoForEdit(String pmCode) {

        return editMapper.findInfoForEdit(pmCode);
    }
}
