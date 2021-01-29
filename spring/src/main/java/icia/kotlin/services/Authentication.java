package icia.kotlin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.member;
import icia.kotlin.spring.MapperInterface;

@Service
public class Authentication {
	
	
	public Authentication() {
		}
	
	@Autowired
	private MapperInterface mapper;
	
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
			ModelAndView mav = new ModelAndView();
			
			 	if(this.isMember(m)) {
			 		if(this.isAccess(m)) {
			 			System.out.println("로그인성공");
			 			mav.addObject("mId",this.memberInfo(m).getMId());
			 			mav.addObject("mName",this.memberInfo(m).getMName());
			 			mav.addObject("mPhone",this.memberInfo(m).getMPhone());
			 			
			 			
			 		}
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
		
		
	}

