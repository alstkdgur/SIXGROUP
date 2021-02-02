package icia.kotlin.spring;

import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.Movie;
import icia.kotlin.beans.member;
import icia.kotlin.services.Authentication;
import icia.kotlin.services.Reservation;
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
	private Reservation res;

	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView main(@ModelAttribute Movie movie) {
		ModelAndView mav = new ModelAndView();
		
		mav = res.entrance(movie);

		return mav;
	}
	
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public ModelAndView date(@ModelAttribute Movie movie) {
		ModelAndView mav = new ModelAndView();
		mav = res.entrance(movie);
		System.out.println("이거지워죠 ");

		return mav;
	}
	
	@RequestMapping(value = "/screen", method = RequestMethod.GET)
	public ModelAndView screen(@ModelAttribute Movie movie) {
		ModelAndView mav = new ModelAndView();
		
		mav = res.entrance(movie);

		return mav;
	}
	
	@RequestMapping(value = "/loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	
	public ModelAndView logInForm() {

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("loginForm");

		return mav;
		
	}


	@RequestMapping(value ="/login", method = {RequestMethod.POST})
	public ModelAndView logIn(@ModelAttribute member m) {
		
		return  auth.entrance(m);
		
	}
	

	


	
}