package jx.pgz.controller;


import jx.pgz.dao.entity.User;
import jx.pgz.dao.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();

        //响应视图1
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView loginUrl(@RequestParam("username")String username,@RequestParam("password")String password) {

        System.out.println(username);
        System.out.println(password);
        //响应视图

        User one = userService.lambdaQuery()
                .eq(User::getUsername, username)
                .eq(User::getPassword, password)
                .one();

        ModelAndView modelAndView=new ModelAndView();
        if (one!=null){
            modelAndView.setViewName("redirect:index");
        }else{
            modelAndView.setViewName("redirect:errorPage");
        }

        return modelAndView;
    }


    @RequestMapping("/errorPage")
    public String errorPage() {
        return "errorPage";
    }


    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("list",userService.list());
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:index";
    }


    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(String deleteId) {
        if (StringUtils.hasText(deleteId)){
            userService.removeBatchByIds(Arrays.asList(deleteId.split(",")));
        }
        return "ok";
    }




}
