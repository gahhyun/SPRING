package com.earth.dayofweek;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController("/dayofweek")
public class Dayofweek {

    public String dayweek(HttpServletRequest request){
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        System.out.println("year = " + year);
        System.out.println("month = " + month);
        System.out.println("day = " + day);


        return  "wednesday";
    }
}
