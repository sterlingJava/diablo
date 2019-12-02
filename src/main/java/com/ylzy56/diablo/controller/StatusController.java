package com.ylzy56.diablo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/status")
@Api(value = "Status")
public class StatusController {
    private static String ip = "UnknowHost";

    static{
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
        }
    }

    @GetMapping("/")
    public String[] status(){
        return new String[]{"diablo","running",ip};
    }
}
