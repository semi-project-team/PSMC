package com.javaclass.psmc.user.model.dao;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.user.model.dto.SignUpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<EmployeeDTO> getAllMember();

    List<EmployeeDTO> findMember(Map<String, String> param);

    int registMember(SignUpDTO signup);


}
