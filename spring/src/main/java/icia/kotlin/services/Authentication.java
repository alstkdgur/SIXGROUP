package icia.kotlin.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.servlet.ModelAndView;


import icia.kotlin.beans.Movie;
import icia.kotlin.beans.member;
import icia.kotlin.spring.MapperInterface;

@Service
public class Authentication {
	 

	public Authentication() {}
	@Autowired
	private MapperInterface mapper;
	@Autowired
	private PlatformTransactionManager tran;
		
		public ModelAndView entrance(member m) {
			ModelAndView mav=null;
			
			if(m.getCode().equals("A")) {
				mav=loginCtl(m);
			}
			
			return mav;
		
	}

		private ModelAndView loginCtl(member m ) {
			
			TransactionStatus status=tran.getTransaction(new DefaultTransactionDefinition());
			
			ModelAndView mav = new ModelAndView();
			
			try {
				if (this.isMember(m)) {
					if (this.isAccess(m)) {

						System.out.println("성공 ");
						mav.addObject("mId", this.info(m).getMId());
						mav.addObject("mName", this.info(m).getMName());
						mav.addObject("mPhone", this.info(m).getMPhone());		
					}
				}
			} catch (Exception e) {
				tran.rollback(status);
				e.printStackTrace();
			}
			mav.setViewName("loginForm");

			return mav;
			
		}
		private boolean converToBoolean(int count) {
			return count==1?true:false;
		}
		
		/*액세스 가능 여부 확인 */
		private boolean isAccess(member member) {
			return converToBoolean(mapper.isMember(member));
		}
		/*멤버 여부 확인 */
		private boolean isMember(member member) {
			return converToBoolean(mapper.isAccess(member));
		}
		/* 회원정보 가져오기  */
		private member info(member member) {
			
			return mapper.isInfo(member);
		}
		/*insert customer */
		private int insCustomer(member member) {
			return mapper.insCustomer(member);
		}
		/*insert customer */
		private int insMovie(Movie movie) {
			return mapper.insMovie(movie);
		}
		
}
