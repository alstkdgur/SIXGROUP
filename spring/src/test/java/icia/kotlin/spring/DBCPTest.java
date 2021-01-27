package icia.kotlin.spring;
import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)//스프링 프레임 워크 기반의jUnit 테스트를 위한 세팅
//테스트를 실행하는 환결설정 ""안에 참조해서 환결설정 
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//- 스프링 빈(Bean) 설정 파일의 위치를 지정할 떄 사용되는 어노테이션이다

//로그 기록을 남길떄 사용 --lombok사용   log는 Juint사용
@Log4j 
public class DBCPTest {
	//Setter 는 Log4j 를 만들떄 setter 를 자동으로 만들어 주어 Log4j 에다가 넣어준다
   @Setter(onMethod_ = {@Autowired})
   //lombok 이 사용하는 어노테이션 spring관련 Annotation
   //AutoWired 는 xml에 올려 놓은걸 자동으로 쓰게 해주기 위함(스프링의 핵심)
   private DataSource data;
   
   @Setter(onMethod_= {@Autowired})
   private SqlSessionFactory sqlSession;
   //DataSource는  DBCP에 참조할떄 사용
   @Setter(onMethod_ = {@Autowired})
  
   
   private MapperInterface mapper;
   
   
   @Test//@Test 메서드가 호출할 때 마다 새로운 인스턴스를 생성하여 독립적인 테스트가 이루어지게 한다.
   public void connectTest() {
      try {
    SqlSession  session = sqlSession.openSession();
      Connection connect = data.getConnection();
      log.info(session);
      log.info(connect);
      log.info(mapper.getDate());
      log.info(mapper.getDate2());
      }catch(Exception e) {
         e.printStackTrace();
      }
      
   }
   
}