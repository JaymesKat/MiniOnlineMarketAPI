package edu.miu.cs545.group1.MiniOnlineMarket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("management/api/v1/users")
public class UserManagement {

    @GetMapping
    public String test(){
        return "Working";
    }
}
