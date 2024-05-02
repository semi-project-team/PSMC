package com.javaclass.psmc.user.model.service;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.user.model.dao.UserMapper;
import com.javaclass.psmc.user.model.dto.SignUpDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    public List<EmployeeDTO> getAllMember() {

        return userMapper.getAllMember();
    }

    public EmployeeDTO findMember(Map<String, String> param) {

        return userMapper.findMember(param);
    }

    public int registMember(SignUpDTO signup) {

        return userMapper.registMember(signup);
    }
}
