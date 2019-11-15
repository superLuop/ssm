package com.lp.ssm.service.impl;

import com.lp.ssm.mapper.UserMapper;
import com.lp.ssm.model.User;
import com.lp.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User login(String username,String password) {
        return userMapper.selectByUsernameAndPassword(username,password);
    }
}
