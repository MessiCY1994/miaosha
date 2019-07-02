package com.messiyang.miaosha.service.otherService;


import com.messiyang.miaosha.dao.UserMapper;
import com.messiyang.miaosha.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User getById(int id) {
        return userMapper.getById(id);
    }


}
