package com.example.demo.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.example.demo.dto.*;
import com.example.demo.service.*;

// 화면을 보여주거나 이동한다 : MVC => return 을 void 혹은 String
//                      Model 에 데이터를 담고 View 를 리턴
// 현재 화면에 머문다 : REST => return 을 ResponseEntity 객체
//                (데이터 + 상태 코드), 데이터만 리턴

@Controller
public class MemberController {
  @Autowired
  private MemberService memberService;
  
  @GetMapping("/")
  public ModelAndView index() {
    return new ModelAndView("list");
  }
  
//  ㄱ. 회원 가입 화면 보여주기
  @GetMapping("/member/join")
  public void join() {
  }
//  ㄱ-1. 아이디 중복 확인
//  /member/check/username?username=spring  @RequestParam
//  /member/check/username/spring           @RequestParam
  @GetMapping("/member/check/username/{username}")
  public ResponseEntity<String> checkUsername(@PathVariable String username) {
    Boolean result = memberService.checkUsername(username);
    if(!result) {
      return ResponseEntity.ok(null);
    }
    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
  }
//  ㄱ-2. 회원 가입
  @PostMapping("/member/join")
  public String save(@ModelAttribute MemberDto.Create dto, RedirectAttributes ra) {
    memberService.join(dto.toEntity());
//    RedirectAttributes 는 redirect 할 때 값을 가지고 이동한다.
//    값은 자동으로 사라진다.
    return "redirect:/login";
  }
  
//  로그인 화면
  @GetMapping("/member/login")
  public void login(HttpSession session, Model model) {
//    세션에 로그인 에러 메시지가 들어있는 경우, model 로 이동시킨다.
    if(session.getAttribute("msg")!=null) {
      model.addAttribute("msg", session.getAttribute("msg"));
      session.removeAttribute("msg");
    }
  }
  
//  로그인 처리
  @PostMapping("/member/login")
  public ModelAndView login(@RequestParam String username,
                            @RequestParam String password,
                            HttpSession session) {
    Boolean result = memberService.login(username, password);
    if(result) {
      session.setAttribute("username", username);
      return new ModelAndView("redirect:/");
    }else {
      session.setAttribute("msg", "로그인에 실패했습니다.");
      return new ModelAndView("redirect:/member/login");
    }
  }
  
//  로그아웃
  @PostMapping("/member/logout")
  public ModelAndView logout(HttpSession session) {
//    로그아웃하면 실행 후 이동시켜야한다 (사용자가 현재 로그인이 필요한 페이지에 있을 수 있음).
    session.invalidate();
    return new ModelAndView("redirect:/");
  }
}
