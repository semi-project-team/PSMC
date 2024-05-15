package com.javaclass.psmc.user.model.service;

import com.javaclass.psmc.auth.model.dto.MyPatientDTO;
import com.javaclass.psmc.auth.model.dto.ProjectsDTO;
import com.javaclass.psmc.auth.model.dto.TheraProjectDTO;
import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.dto.MediInfoDTO;
import com.javaclass.psmc.common.model.dto.MenuDTO;
import com.javaclass.psmc.common.model.dto.TheraInfoDTO;
import com.javaclass.psmc.mainPage.model.dto.*;
import com.javaclass.psmc.user.model.dao.UserMapper;

import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper,PasswordEncoder passwordEncoder){

        this.userMapper=userMapper;
        this.passwordEncoder=passwordEncoder;
    }

    public List<EmployeeDTO> getAllMember() {

        return userMapper.getAllMember();
    }

    public List<EmployeeDTO> findMember(Map<String, String> param) {

        return userMapper.findMember(param);
    }

    public int registMember(SignupDTO signup) {

        signup.setPassword(passwordEncoder.encode(signup.getPassword()));
        int result =0;

        try {
            result=userMapper.registMember(signup);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }



    public LoginUserDTO findByUsername(String username) {

        return userMapper.findByUsername(username);
    }




    public List<LoginUserDTO> findAllMember() {
        return userMapper.findAllMember();
    }

    public LoginUserDTO findMemberByPmCode(String pmCode) {
        return userMapper.findMemberByPmCode(pmCode);
    }

    public ProfileDTO findEmployeeByPmCode(String pmCode) {

        return userMapper.findEmployeeByPmCode(pmCode);
    }


    public List<TtoMIDTO> todayMedi(Map<String, Object> param) {

        return userMapper.todayMedi(param);
    }

    public List<TtoMIDTO> allTimes(String pmCode) {

        return userMapper.allTimes(pmCode);
    }

    public int softDelete(Map<String,String> delete) {
        return userMapper.softDelete(delete);
    }

    public int mediInfoUpdate(Map<String, Object> parameter) {
        return userMapper.mediInfoUpdate(parameter);
    }

    public List<TheraToProDTO> todayThera(Map<String, Object> param) {
        return userMapper.todayThera(param);
    }

    public List<TheraToProDTO> allThera(String pmCode) {
        return userMapper.allThera(pmCode);
    }



    public List<AllMediDTO> allMedi(Map<String, Object> param) {

        return userMapper.allMedi(param);
    }

    public List<AllTheraDTO> allTheraInfo(Map<String, Object> param) {
        return userMapper.allTheraInfo(param);
    }

    public List<ConnectProjectDTO> checkRes(Map<String, Object> parameter) {

        return userMapper.checkRes(parameter);
    }

    public List<ConnectProjectDTO> tcheckRes(Map<String, Object> parameter) {

        return userMapper.tcheckRes(parameter);
    }

    public List<ProjectsDTO> mediToday(Map<String, Object> sender) {

        return userMapper.mediToday(sender);
    }

    public TodayMenuDTO menu(int date) {

        return userMapper.menu(date);
    }

    public int findDayNo(String today) {

        return userMapper.findDayNo(today);
    }

    public List<TheraProjectDTO> theraToday(Map<String, Object> sender) {
        return userMapper.theraToday(sender);
    }

    public List<MyPatientDTO> myPatient(Map<String,Object> sender) {

        return userMapper.myPatient(sender);
    }

    public int makeMediInfo(MediInfoDTO mediInfoDTO) {

        return userMapper.makeMediInfo(mediInfoDTO);
    }

    public int makeTheraInfo(TheraInfoDTO theraInfoDTO) {

        return userMapper.makeTheraInfo(theraInfoDTO);
    }

    public List<TodayAllMediDTO> todayAllMedi(Map<String, String> parameter) {
        return userMapper.todayAllMedi(parameter);
    }

    public List<TodayAllTheraDTO> todayTheraByPRNo(TheraJSONDTO theraJSONDTO) {
        return userMapper.todayTheraByPRNo(theraJSONDTO);
    }


    public List<TodayAllTheraDTO> checkTheraByStartAndEnd(Map<String, Object> sender) {

        return userMapper.checkTheraByStartAndEnd(sender);
    }

    public List<TodayAllMediDTO> todayMediByPRNo(Map<String, Object> sender) {

        return userMapper.todayMediByPRNo(sender);
    }

    public List<TodayAllTheraDTO> checkTheraByTheraCode(Map<String, Object> sender) {

        return userMapper.checkTheraByTheraCode(sender);
    }

    public int theraInfoupdate(Map<String, Object> sender) {

        return userMapper.theraInfoupdate(sender);
    }

//    public List<TheraToProDTO> todayThera(Map<String, Object> param) {
//    }
}
