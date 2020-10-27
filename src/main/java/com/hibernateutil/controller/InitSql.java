package com.hibernateutil.controller;


import com.hibernateutil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public class InitSql {


    @Autowired
    UserRepository userRepository;


    public String init () {

            return userRepository.getUsernameById(1);
    }


}
