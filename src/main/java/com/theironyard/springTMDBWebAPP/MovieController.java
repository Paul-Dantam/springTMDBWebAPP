package com.theironyard.springTMDBWebAPP;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MovieController {
   static final String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";
    private static RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }



    @RequestMapping(path = "/now-playing", method = RequestMethod.GET)
    public String nowPlaying(Model model) {
        model.addAttribute("movies", getMovies(url));
        return "now-playing";
    }


    @RequestMapping(path = "/medium-popular-long-name", method = RequestMethod.GET)
    public String mediumPopularLongName(Model model) {
        return "medium-popular-long-name";
    }


    @RequestMapping(path = "/overview-mashup", method = RequestMethod.GET)
    public String overviewMashup(Model model) {
        return "overview-mashup";
    }


    public static List<Movie> getMovies(String route) {
        ResultsPage resultsPage = restTemplate.getForObject(route, ResultsPage.class);
        return resultsPage.getResults();
    }


}



