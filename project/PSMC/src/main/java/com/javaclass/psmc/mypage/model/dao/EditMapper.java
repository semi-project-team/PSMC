package com.javaclass.psmc.mypage.model.dao;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.dto.MemberRegistDTO;
import com.javaclass.psmc.mypage.model.dto.EditDTO;
import com.javaclass.psmc.mypage.model.dto.ProfileFroEditDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface EditMapper {

    int updateEmployee(EditDTO editDTO);

    int updateRegist(EditDTO editDTO);

    EmployeeDTO employeeDetail(Map<String, Object> params);

    MemberRegistDTO memberRegistDetail(Map<String, Object> params);

    ProfileFroEditDTO findInfoForEdit(String pmCode);
}
