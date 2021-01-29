package icia.kotlin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.member;
import icia.kotlin.spring.MapperInterface;

@Service
public class Authentication {
	 

	public Authentication() {}
	@Autowired
	private MapperInterface mapper;
		
		public ModelAndView entrance(member m,MapperInterface mapper) {
			ModelAndView mav=null;
			
			if(m.getCode().equals("A")) {
				mav=loginCtl(m, mapper);
			}
			
			return mav;
		
	}

		private ModelAndView loginCtl(member m,MapperInterface mapper ) {
			
			ModelAndView mav = new ModelAndView();
			
			if(this.isMember(m)) {
				if(this.isAccess(m)) {
					System.out.println("성공 ");
				}
			}

			return mav;
			
		}
		private boolean converToBoolean(int count) {
			return count==1?true:false;
		}

		private boolean isAccess(member member) {
			return converToBoolean(mapper.isMember());
		}

		private boolean isMember(member member) {
			return converToBoolean(mapper.isAccess());
		}

	
		
		
		
}
