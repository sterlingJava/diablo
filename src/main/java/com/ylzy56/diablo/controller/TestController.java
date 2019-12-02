package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.service.FirstBlood;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(value = "Test")
public class TestController {
    @Autowired
    private FirstBlood firstBlood;

    @GetMapping("/getFirstBlood")
    public String getFirstBlood(){
        return firstBlood.getFirstBlood();
    }
}
