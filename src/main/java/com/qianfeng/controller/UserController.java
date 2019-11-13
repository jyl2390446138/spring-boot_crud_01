package com.qianfeng.controller;

import com.qianfeng.entity.Department;
import com.qianfeng.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {



    @GetMapping(value = "/getUserList")
    public String getUserList(Map map){

        List<User> list = new ArrayList<>();
        User user1 = new User(1001,"AAA","MAN");
        User user2 = new User(1002,"BBB","WOMAN");
        User user3 = new User(1003,"CCC","MAN");
        User user4 = new User(1004,"DDD","WOMAN");

        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        map.put("users",list);

        return "userList";
    }

    @GetMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId){
        System.out.println("删除userId"+userId);
        return "redirect:/user/getUserList";
    }

    @GetMapping(value = "/jumpUpdateUser/{userId}")
    public String update(@PathVariable("userId") Integer userId,Map map){
        System.out.println("跳转更新页面");

        List<Department> departments=new ArrayList<>();

        Department department1 = new Department(1001, "人事部");
        Department department2 = new Department(1002, "行政部");
        Department department3 = new Department(1003, "产品研发部");
        Department department4 = new Department(1004, "财务部");

        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);

        map.put("departments",departments);
        map.put("deptShowId",1003);

        return "redirect:/user/getUserList";
    }



    public void A(){

    }







}
