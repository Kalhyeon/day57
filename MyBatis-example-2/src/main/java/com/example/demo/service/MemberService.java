package com.example.demo.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.member.dao.*;
import com.example.demo.member.entity.*;

@Service
public class MemberService {
  @Autowired
  private MemberDao memberDao;
  
  public Boolean checkUsername(String username) {
    return !memberDao.existsByUsername(username);
  }
  
  public Boolean join(Member member) {
    return memberDao.save(member)==1;
  }
  
//  DB 에서 select 하는 경우에 반드시 NULL Check
  public Boolean login(String username, String password) {
    Member member = memberDao.findById(username);
    if(member==null)
      return false;
    return member.getPassword().equals(password);
  }
}
