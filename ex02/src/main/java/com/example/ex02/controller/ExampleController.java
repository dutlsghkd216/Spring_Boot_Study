package com.example.ex02.controller;


import com.example.ex02.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller //이 어노테이션을 붙여줘야 spring에 관리대상이 되서 핸들러매핑이 스캔이 가능
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {
    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public void ex01() {
        log.info("=============ex01=============");
    }

    @GetMapping("ex02")
    public void ex02(HttpServletRequest request) {
        log.info(request.getParameter("name"));
    }

    @GetMapping("ex03")
    public void ex03(String name){
        log.info(name);
    }

    @GetMapping("ex04")
    public void ex04(MemberVO memeberVO){
        log.info("member : " +memeberVO.toString());
    }

    @GetMapping("ex05")
    public void ex05(@RequestParam("id") String name, int age){ // 파라미터이름과 매개변수이름이 다를 때 @RequestParam어노테이션을 씀
        log.info("name: " +name);
        log.info("age: " +age);
    }

    @GetMapping("ex06")
    public void ex06(MemberVO memberVO, String id){
        log.info("member: " + memberVO.getName());
        log.info("age: " + memberVO.getAge());
        log.info("id: " + id);
    }

    @GetMapping("ex07")
    public void ex07(){}

    @GetMapping("ex08")
    public String ex08(){
        return "ex/ex08/ex08";
    }

    @GetMapping("ex09")
    public String ex09(String name, Model model/*HttpServletRequest request*/){
        model.addAttribute("name", name);
        return "ex/ex09";
    }

    @GetMapping("ex10")
    public String ex10(MemberVO memberVO){
        return "ex10";
    }

    @GetMapping("ex11")
    public void ex11(MemberVO memberVO,@ModelAttribute("gender") String gender){    //하나만 받을 때 @ModelAttribute쓰고 여러개일땐 model

    }
    @GetMapping("ex12")
        public void ex12(@RequestParam("data") List<String> datas){
            log.info("================================");
            datas.forEach(log::info);
        }

}
