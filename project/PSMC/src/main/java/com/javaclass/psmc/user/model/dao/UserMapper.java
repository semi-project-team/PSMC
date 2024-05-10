package com.javaclass.psmc.user.model.dao;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.mainPage.model.dto.ProfileDTO;
import com.javaclass.psmc.mainPage.model.dto.TtoMIDTO;
import com.javaclass.psmc.user.model.dto.IdDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.dto.SignupDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<EmployeeDTO> getAllMember();

    List<EmployeeDTO> findMember(Map<String, String> param);

    int registMember(SignupDTO signup);


    LoginUserDTO findByUsername(String username);


    List<LoginUserDTO> findAllMember();

    LoginUserDTO findMemberByPmCode(String pmCode);

    ProfileDTO findEmployeeByPmCode(String pmCode);

    List<TtoMIDTO> todayMedi(Map<String, Object> param);

    List<TtoMIDTO> allTimes(String pmCode);

    int softDelete(int mediCode);

    int mediInfoUpdate(Map<String, Object> parameter);
}
