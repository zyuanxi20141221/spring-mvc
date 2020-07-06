package com.zheng.controller;

import com.zheng.domain.User;
import com.zheng.service.RoleService;
import com.zheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        modelAndView.addObject("userList", userService.list());
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {
        userService.save(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("roleList", roleService.list());
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/del/{userId}")
    public String delete(@PathVariable("userId") Long id) {
        userService.del(id);
        return "redirect:/user/list";
    }
}
