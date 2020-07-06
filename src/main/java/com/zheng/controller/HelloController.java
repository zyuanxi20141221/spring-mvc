package com.zheng.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zheng.domain.Customer;
import com.zheng.domain.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping("/hello.action")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login.action")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("username", "jimmy");
        return modelAndView;
    }

    @RequestMapping("/register.action")
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.setViewName("register");
        modelAndView.addObject("username", "john");
        return modelAndView;
    }

    @RequestMapping("/loginSuccess.action")
    public ModelAndView loginSuccess(String username, String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginSuccess");
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    /**
     * spring数据回显
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/echo.action", params = "id=10")
    public void echoString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("{\"user:\" \"john\", \"age:\" 30}");
    }

    /**
     * spring数据回显，格式化输出
     *
     * @throws IOException
     */
    @RequestMapping("/echojson.action")
    @ResponseBody
    public String echoJson() throws IOException {
        Customer customer = new Customer();
        customer.setName("jimmy");
        customer.setTelephone("13418638490");
        customer.setGender("boy");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(customer);
    }

    @RequestMapping("/param.action")
    public ModelAndView save(String username, Integer age) {
        System.out.println("用户名：" + username);
        System.out.println("年龄：" + age);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginSuccess");
        modelAndView.addObject("username", username);
        return modelAndView;
    }

    @RequestMapping("/param2.action")
    public ModelAndView save2(TestUser user) {
        System.out.println("用户名2：" + user.getUsername());
        System.out.println("年龄2：" + user.getAge());
        System.out.println("生日：" + user.getBirthday());
        System.out.println("省份:" + user.getAddress().getProvince());
        System.out.println("城市:" + user.getAddress().getCity());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginSuccess");
        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("province", user.getAddress().getProvince());
        modelAndView.addObject("city", user.getAddress().getCity());
        return modelAndView;
    }
}
