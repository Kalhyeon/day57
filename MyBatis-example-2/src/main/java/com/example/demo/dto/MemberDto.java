package com.example.demo.dto;

import java.time.*;

import org.springframework.format.annotation.*;

import com.example.demo.member.entity.*;

import lombok.*;

// 내부 클래스 : 클래스 안의 클래스
// static 을 붙인 이유
// - static 은 객체가 없어도 존재한다.
// - 내부 클래스에 static 이 없으면 내부 객체를 만들려면 MemberDto
//   객체부터 new 를 해야한다.

public class MemberDto {
  private MemberDto() {
  }
  
  @Data
  public static class Create {
    private String username;
    private String password;
    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate birthday;
    public Member toEntity() {
      return new Member(username, password, email, birthday, LocalDate.now());
    }
  }
  
  @Data
  public static class Update {
    private String username;
    private String password;
    private String email;
  }
  
  @Data
  public static class Read {
    private String username;
    private String password;
    private String email;
    private String birthday;
    private String joinday;
    private Long days;
  }
}
