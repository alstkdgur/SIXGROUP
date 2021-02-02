
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
			System.out.println("이거지워죠 ");
		}else {
			
		}
		return mav;
	}


	private ModelAndView movieCtl() {
		ModelAndView mav = new ModelAndView();
		System.out.println("moviectl ");
		/*Access Time */
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E요일");
		mav.addObject("Access",sdf.format(date));
		mav.addObject("gList",this.makeMovieList(this.getMovieList()));
		mav.setViewName("main");
		System.out.println(this.getMovieList().size());
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

				sb.append("<div class=\"item\" onClick=\"goDetail(\'" +  movie.getMvImage() + "\')\"><input type=\"hidden\" name=\"pk\" value=\"" + movie.getMvCode() + "\"/>");
				sb.append("<div class=\"item__top\"><img src=\"image/" + movie.getMvImage() + "\" /></div>");
				sb.append("<div class=\"item__bottom\"><div class=\"item-name\">" + movie.getMvName()
						+ "</div>");
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


	private ArrayList<Movie> getMovieList() {
		return mapper.getMovieList();
	}


	
	
}

