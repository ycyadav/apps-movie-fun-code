package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    MoviesBean moviesBean;

    public HomeController(MoviesBean moviesBean){
        this.moviesBean = moviesBean;
    }

    @GetMapping("/")
    public String homeAction(){
        return "index";
    }

    /*@GetMapping("/moviefun")
    public String addAction(Model model){
        model.addAttribute("movies", moviesBean.getMovies());
        return "moviefun";
    }*/

    @GetMapping("/setup")
    public String setUpAction(Model model){
        moviesBean.addMovie(new Movie("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005));
        moviesBean.addMovie(new Movie("Starsky & Hutch", "Todd Phillips", "Action", 6, 2004));
        moviesBean.addMovie(new Movie("Shanghai Knights", "David Dobkin", "Action", 6, 2003));
        moviesBean.addMovie(new Movie("I-Spy", "Betty Thomas", "Adventure", 5, 2002));
        moviesBean.addMovie(new Movie("The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001));
        moviesBean.addMovie(new Movie("Zoolander", "Ben Stiller", "Comedy", 6, 2001));
        moviesBean.addMovie(new Movie("Shanghai Noon", "Tom Dey", "Comedy", 7, 2000));
        model.addAttribute("movies", moviesBean.getMovies());
        return "setup";
    }
}
