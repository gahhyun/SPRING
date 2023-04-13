package com.earth.dayoftheweek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;

@Controller
public class DayOfTheWeek {

    @RequestMapping("/dayofweek")
    public String dayweek(int year, int month, int day, Model model){

        //요일 계산
        char dayOfWeek = getDayOfWeek(year, month,day);

        //작업한 결과를 Model에 저장 (DS이 Model을 View로 전달함)
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("dayOfWeek", dayOfWeek);


        return "dayOfWeek";     //dayOfWeek.html 뷰의 이름을 반환
    }
    private char getDayOfWeek(int year,int month,int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month-1, day );       //월은 0-11이기 때문에 1을 빼줌
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);              //요일 리턴.1-7 리턴 1:일
        return "일월화수목금토".charAt(dayOfWeek-1);
    }
}
