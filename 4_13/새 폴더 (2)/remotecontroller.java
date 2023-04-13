package com.earth.dayoftheweek;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     //원격프로그램 등록
public class remotecontroller {

    @RequestMapping("/")
    public String earth(){

        System.out.println("Hi SB");
        return "Hi spring Boot";
    }
}
