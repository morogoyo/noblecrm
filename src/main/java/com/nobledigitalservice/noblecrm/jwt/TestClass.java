package com.nobledigitalservice.noblecrm.jwt;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestClass {

    @RequestMapping({"/hello"})
    public String hello(){
        return "Hello World";
    }
}
