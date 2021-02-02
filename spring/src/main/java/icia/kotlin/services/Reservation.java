package icia.kotlin.services;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.ModelAndView;

import icia.kotlin.beans.Movie;
import icia.kotlin.spring.ReservationIf;

@Service
public class Reservation {
  @Autowired
  private ReservationIf mapper;
  @Autowired
  private PlatformTransactionManager tran;
  
  public ModelAndView entrance(Movie movie) {
	  ModelAndView mav = null;
	  
	  if(movie.getMvCode() == null) {
		  mav = this.movieListCtl();
	  }else {
		  switch(movie.getSCode()) {
		  case "" :
			  break;
		  }
	  }
	  
	  return mav;
  }

private ModelAndView movieListCtl() {
	ModelAndView mav = new ModelAndView();
	
	/* AccessTime */
    Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E요일");
	mav.addObject("Access", sdf.format(date));
	
	mav.addObject("mList", getMovieList());
	
	mav.setViewName("home");	
	return mav;
  }

  private ArrayList<Movie> getMovieList(){
	  return mapper.getMovieList();
  }
}
