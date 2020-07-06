package com.zheng.service;

import com.zheng.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> list();

    void save(Role role);

    void delete(Long id);

}
