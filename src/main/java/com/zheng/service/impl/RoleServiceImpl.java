package com.zheng.service.impl;

import com.zheng.domain.Role;
import com.zheng.mapper.RoleDaoMapper;
import com.zheng.service.RoleService;
import javax.annotation.Resource;
import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDaoMapper roleMapper;

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
