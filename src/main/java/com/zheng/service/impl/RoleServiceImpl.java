package com.zheng.service.impl;

import com.zheng.dao.RoleDao;
import com.zheng.domain.Role;
import com.zheng.mapper.RoleMapper;
import com.zheng.service.RoleService;

import javax.annotation.Resource;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Resource
    private RoleMapper roleMapper;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> list() {
        return roleMapper.findAll();
    }

    public void save(Role role) {
        roleMapper.save(role);
    }

    @Override
    public void delete(Long id) {
        roleMapper.delete(id);
    }
}
