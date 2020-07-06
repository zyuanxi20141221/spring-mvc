package com.zheng.mapper;

import com.zheng.domain.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> findAll();

    void save(Role role);

    void delete(long id);

}
