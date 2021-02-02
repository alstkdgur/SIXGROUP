package icia.kotlin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.Movie;
import icia.kotlin.beans.member;
import icia.kotlin.spring.MapperInterface;

@Service
public class Authentication {
	
	
	public Authentication() {
		}
	
	@Autowired
	private MapperInterface mapper;
	@Autowired
	private PlatformTransactionManager tran;
	
		public ModelAndView entrance(member m) {
			
			
			 ModelAndView mav =null;
			 switch (m.getServicecode()) {
			case "A":
				mav=loginctl(m);
				break;
				
			}			 
			 return mav;
		}

		private ModelAndView loginctl(member m) {
			ModelAndView mav = null;
			 
			TransactionStatus status= tran.getTransaction(new DefaultTransactionDefinition());
			//상태값가지고 처리status (commit, rollback) = transaciton 시작						
			mav=new ModelAndView();
			try {
			if(this.isMember(m)) {
			 		if(this.isAccess(m)) {
			 			
			 			mav.addObject("mId",this.memberInfo(m).getMId());
			 			mav.addObject("mName",this.memberInfo(m).getMName());
			 			mav.addObject("mPhone",this.memberInfo(m).getMPhone());
			 			/*TRANSACTION 처리를 위한 메서드 1: ST INSERT*/
			 			
			 			m.setMId("YYYY");
			 			m.setMName("연이DD");
			 			m.setMPwd("1234");
			 			m.setMPhone("01022223223");
			 			this.insCustomer(m);
			 			
			 			
			 			/*TRANSACTION 처리를 위한 메서드 2: MV INSERT*/
						Movie movie = new Movie();
						movie.setMvCode("00019980");
						movie.setMvName("코코");
						movie.setMvGrade("A");
						movie.setMvStatus("I");
						movie.setMvImage("019980.jpg");
						movie.setMvComments("뮤지션을 꿈꾸는 소년 미구엘은 전설적인 가수 에르네스토의 기타에 손을 댔다 ‘죽은 자들의 세상’에 들어가게 된다.");
						this.insMovie(movie);

			 			tran.commit(status);
			 			}
			 		}
			 	
			
			}catch(Exception e) {
				e.printStackTrace();
				tran.rollback(status);
			}
			 	mav.setViewName("loginForm");
			 	
			
			  return mav;
		}
		
		private boolean convertToBoolean(int value) {
			return value==1?true:false;
		}

		private boolean isMember(member m) {
			return convertToBoolean( mapper.isMember(m));			
			
		}
		private boolean isAccess(member m) {
			
			return convertToBoolean(mapper.isAccess(m));
		}

		private member memberInfo(member m) {
			return mapper.memberInfo(m);
			
		}
		
		/*spring framework 에서의 transaction 
		*1.@Transactional을 이용한 Transaction 
		*2.AOP 이용한 Transaction  
		*3.Programmatic Transaction -->수동처리  (명시적 transaction)
		 */
		
		/*TRANSACTION 처리를 위한 메서드 1: ST INSERT*/
			private int insCustomer(member m) {
				return mapper.insCustomer(m);
			}
			/*TRANSACTION 처리를 위한 메서드 2: MV INSERT*/
			private int insMovie(Movie movie) {
				return mapper.insMovie(movie);
	}
}
