package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import com.example.demo.member.dao.*;

@SpringBootTest
public class MemberDaoTest {
//  설정 => DataSource (Hikari) => SqlSessionFactory (MyBatis)
//     => SqlSessionTemplate
  @Autowired
  private MemberDao memberDao;
  
//  @Test
  public void existsByUsernameTest() {
    assertEquals(true, memberDao.existsByUsername("spring"));
    assertEquals(false, memberDao.existsByUsername("summer"));
  }
  
//  @Test
  public void existsUsernameByEmailTest() {
    assertNotNull(memberDao.existsUsernameByEmail("spring.naver.com"));
    assertNull(memberDao.existsUsernameByEmail("summer@naver.com"));
  }
}
