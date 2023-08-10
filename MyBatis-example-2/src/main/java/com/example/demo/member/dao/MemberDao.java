package com.example.demo.member.dao;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.demo.member.entity.*;

@Repository
public class MemberDao {
  @Autowired
  private SqlSessionTemplate tpl;
  
//  메서드명과 매퍼의 이름이 다르면 Invalid Bound Statement
  public Boolean existsByUsername(String username) {
    return tpl.selectOne("memberMapper.existsByUsername", username);
  }
  
  public Integer save(Member member) {
    return tpl.insert("memberMapper.save", member);
  }
  
  public String existsUsernameByEmail(String email) {
    return tpl.selectOne("memberMapper.existsUsernameByEmail", email);
  }
  
  public Member findById(String username) {
    return tpl.selectOne("memberMapper.findById", username);
  }
  
  public Integer changePassword(Member member) {
    return tpl.update("memberMapper.update", member);
  }
  
  public Integer changeEmail(Member member) {
    return tpl.update("memberMapper.update", member);
  }
  
  public Integer delete(String loginId) {
    return tpl.delete("memberMapper.delete", loginId);
  }
}
