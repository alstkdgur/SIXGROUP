package icia.kotlin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.member;
import icia.kotlin.spring.MapperInterface;

@Service
public class Authentication {
	 

	public Authentication() {}
		
		public ModelAndView entrance(member m,MapperInterface mapper) {
			ModelAndView mav=null;
			
			if(m.getCode().equals("A")) {
				mav=loginCtl(m, mapper);
			}
			
			return mav;
		
	}

		private ModelAndView loginCtl(member m,MapperInterface mapper ) {
			
			ModelAndView mav = new ModelAndView();
			
			mav.addObject("mId",m.getMId());
			mav.addObject("mPwd",m.getMPwd());

			mav.setViewName("loginForm");

			return mav;
			
		}

	
		
		
		
}
