package com.zheng.dao;

import com.zheng.domain.Role;
import java.util.List;

public interface RoleDao {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);

    void delete(Long id);
}
