package com.javaclass.psmc.user.model.service;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.user.model.dao.UserMapper;
import com.javaclass.psmc.user.model.dto.IdDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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


    public List<IdDTO> allIds() {
        List<IdDTO> ids =userMapper.allIds();
        for(IdDTO i : ids){
            System.out.println(i);
        }
        return ids;
    }
}
