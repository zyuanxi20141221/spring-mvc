package com.zheng.mapper;

import com.zheng.domain.User;

import java.util.List;

public interface UserDaoMapper {

    List<User> findAll();

    Long save(User user);

    void saveUserRoleRel(Long id, Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);
}
