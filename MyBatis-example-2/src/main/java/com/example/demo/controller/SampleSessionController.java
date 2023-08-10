package com.example.demo.controller;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

// 1. /ex2  세션이 새로 만들어지고 NULL
// 2. /ex1  세션에 홍길동을 저장하고 /ex2 로 이동, 홍길동을 출력
// 3. /ex3  세션을 파괴 후 /ex2 로 이동

@Controller
public class SampleSessionController {
  @GetMapping("/ex1")
  public String example1Start(HttpSession session) {
    session.setAttribute("name", "홍길동");
    return "redirect:/example2";
  }
  
  @GetMapping("/ex2")
  public void example1End(HttpSession session) {
    String name = (String)session.getAttribute("name");
    System.out.println(name);
  }
  
  @GetMapping("/ex3")
  public String example3(HttpSession session) {
//    세션 파괴
    session.invalidate();
    return "redirect:/ex2";
  }
}
