package icia.kotlin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.member;
import icia.kotlin.spring.MapperInterface;

@Service
public class Authentication {

	@Autowired
	private MapperInterface mapper;

	public ModelAndView entrance(member m) {
		ModelAndView mav = null;

		switch (m.getServiceCode()) {
		case "login":
			mav = this.loginCtl(m);
			break;
		}
		return mav;
	}

	private ModelAndView loginCtl(member m) {

		ModelAndView mav = new ModelAndView();

		// 아이디 유무 확인
		if (idCheck(m)) {
			// 아이디,비밀번호 일치 확인
			if (accessInfoCheck(m)) {
				//회원 정보 출력 
				   mav.addObject("mId", showMember(m).getMId());
				   mav.addObject("mName", showMember(m).getMName());
				   mav.addObject("mPhone", showMember(m).getMPhone());
				   mav.setViewName("loginForm");
                   
			}

		}	

		return mav;
	}
	private member showMember(member m) {
          return mapper.showMember(m);
	}

	private boolean convertToBoolean(int value) {
		return (value == 1)? true : false;
	}

	private boolean accessInfoCheck(member m) {
		return convertToBoolean(mapper.accessInfoCheck(m));
	}

	private boolean idCheck(member m) {
		return convertToBoolean(mapper.idCheck(m));
	}
	

}
