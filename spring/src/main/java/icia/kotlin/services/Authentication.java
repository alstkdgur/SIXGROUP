package icia.kotlin.services;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class Authentication {

	public Authentication() {}
		
		public ModelAndView entrance() {
			ModelAndView mav = null;
			
			System.out.println("진입성공 ");
			return mav;
		
	}
}
