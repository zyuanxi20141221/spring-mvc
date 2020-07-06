package com.zheng.service.impl;

import com.zheng.domain.Role;
import com.zheng.domain.User;
import com.zheng.mapper.RoleDaoMapper;
import com.zheng.mapper.UserDaoMapper;
import com.zheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoMapper userDaoMapper;

    @Autowired
    private RoleDaoMapper roleDaoMapper;

    public List<User> list() {
        List<User> userList = userDaoMapper.findAll();
        //封装userList中的每一个User的roles数据
        for (User user : userList) {
            //获得user的id
            Long id = user.getId();
            //将id作为参数 查询当前userId对应的Role集合数据
            List<Role> roles = roleDaoMapper.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    public void save(User user, Long[] roleIds) {
        Long userId = userDaoMapper.save(user);
        System.out.println("userid=" + userId);
        System.out.println("user = " + user);
        userDaoMapper.saveUserRoleRel(user.getId(), roleIds);
    }

    public void del(Long userId) {
        userDaoMapper.delUserRoleRel(userId);
        userDaoMapper.del(userId);
    }
}
