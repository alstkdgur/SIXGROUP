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
   
   public Reservation() {}
   @Autowired
   private ReservationIf mapper;
   @Autowired
   private PlatformTransactionManager tran;

   
   public ModelAndView  entrance(Movie movie) {
      ModelAndView mav = null;
      
      if(movie.getMvCode() == null) {
         mav = this.movieCtl();
      }else {
          mav = this.DateCtl(movie);
      }
      return mav;
   }

   private ModelAndView DateCtl(Movie movie) {
      ModelAndView mav = new ModelAndView();
      mav.addObject("selmovie",this.makeMovieList(this.selMovieList(movie)));
      mav.setViewName("datepage");
      return mav;
   }



private ModelAndView movieCtl() {
      ModelAndView mav = new ModelAndView();
      /*Access Time */
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E요일");
      mav.addObject("Access",sdf.format(date));
      mav.addObject("mvList",this.makeMovieList(this.getMovieList()));
      mav.setViewName("main");
      return mav;
   }


   private String makeMovieList(ArrayList<Movie> movieList) {
         StringBuffer sb = new StringBuffer();
         int index = 0;
         for (Movie movie : movieList) {
            index++;

            if (index % 3 == 1) {
               sb.append("<div class=\"line\">");
            }
            sb.append("<div class=\"item\" onClick=\"goDate(\'" +  movie.getMvCode() + "\')\">");
            
            sb.append("<div class=\"item__top\"><img src=\"resources/image/" + movie.getMvImage() + "\" /></div>");
            sb.append("<div class=\"item__bottom\">" + movie.getMvName()+ "</div>");
            
            sb.append("</div>");

            if (index % 3 == 0) {
               sb.append("</div>");
            }
         }
         if (index % 3 != 0) {
            sb.append("</div>");
         }
         return sb.toString();
   }

   private ArrayList<Movie>  selMovieList(Movie movie) {
	return mapper.selMovieList(movie);
}
   private ArrayList<Movie> getMovieList() {
      return mapper.getMovieList();
   }
}


