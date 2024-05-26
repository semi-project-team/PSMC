package com.javaclass.psmc.mypage.model.service;

import com.javaclass.psmc.mypage.model.dto.EditDTO;
import com.javaclass.psmc.mypage.model.dto.ProfileFroEditDTO;
import com.javaclass.psmc.mypage.model.dao.EditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditService {

    private final EditMapper editMapper;

    @Autowired
    public EditService(EditMapper editMapper) {
        this.editMapper = editMapper;
    }

    public ProfileFroEditDTO findInfoForEdit(String pmCode) {
        return editMapper.findInfoForEdit(pmCode);
    }

    public int updateEmployee(EditDTO editDTO) {
        return editMapper.updateEmployee(editDTO);
    }

    public int updateRegist(EditDTO editDTO) {
        return editMapper.updateRegist(editDTO);
    }
}
