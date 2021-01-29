package icia.kotlin.spring;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.member;
import icia.kotlin.services.Authentication;
import lombok.Setter;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private Authentication auth;
	@Autowired
	private MapperInterface mapper;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, ModelAndView mv) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		mv.addObject("serverTime", formattedDate );
		mv.addObject("welcome", "어서오세요~ 환영합니다");
		
		mv.setViewName("home");

	
		
		return mv;
	}
	
	@RequestMapping(value = "/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	
	public ModelAndView logInForm() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");

		return mav;
		
	}


	@RequestMapping(value ="/login", method = {RequestMethod.POST})
	public ModelAndView logIn(@ModelAttribute member m) {
		
	
		return  auth.entrance(m,mapper);
		
	}
	

	


	
}