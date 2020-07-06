package com.zheng.mapper;

import com.zheng.domain.Role;
import com.zheng.domain.User;

import java.util.List;

public interface RoleDaoMapper {

    List<Role> findAll();

    void save(Role role);

    void delete(long id);

    List<Role> findRoleByUserId(long id);

}
