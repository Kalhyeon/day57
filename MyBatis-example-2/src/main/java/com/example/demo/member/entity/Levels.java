package com.example.demo.member.entity;

// Levels levels = Levels.BRONZE;
// System.out.println(levels.name());

public enum Levels {
  BRONZE("일반 회원"), SILVER("우수 회원"), GOLD("VIP 회원");
  private Levels(String string) {
  }
}
