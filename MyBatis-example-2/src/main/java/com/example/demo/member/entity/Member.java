package com.example.demo.member.entity;

import java.time.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
  private String username;
  private String password;
  private String email;
  private LocalDate birthday;
  private LocalDate joinday = LocalDate.now();
}
