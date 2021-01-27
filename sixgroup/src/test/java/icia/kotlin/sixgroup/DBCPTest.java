package icia.kotlin.sixgroup;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j 
public class DBCPTest {
   @Setter(onMethod_ = {@Autowired})
   private DataSource data;
   @Setter(onMethod_ = {@Autowired})  //Setter=저장 onMethod=핸들링하는거 Autowired=이미 올라와있는 힙영역에서 찾아서 인젝션해줌
   private SqlSessionFactory sqlSession;
   @Setter(onMethod_= {@Autowired})
   private MapperInterface mapper;
   
   @Test
   public void connectTest() {
      try {
      SqlSession session = sqlSession.openSession();	  
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