package com.earth.signin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class LoginController {

    @RequestMapping("/login/login")
    public String showlogin(){ return "login";}

    @PostMapping("/login/login")
    public String login(String id, String pwd, Model model) throws UnsupportedEncodingException {   //모델을 넣어줘야 값을 화면에 받을 수 있다
        //1. id, pwd 확인
        if (loginCheck(id, pwd)){
            //2. 일치하면
            model.addAttribute("id",id);
            model.addAttribute("pwd", pwd);

            return "userInfo";
        }
        else {
            // 일치하지 않으면 redirect로 다시 입력받는 창(같은페이지인데 새로고침 느낌)
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다", "utf-8");
            return "redirect:/login/login?msg"+msg;
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return ("earth").equals(id) && ("0629").equals(pwd);
    }

}
