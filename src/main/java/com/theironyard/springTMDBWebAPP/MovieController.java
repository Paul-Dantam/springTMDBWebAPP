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
        model.addAttribute("movies", getMovies(url)
                .stream()
                .filter(e -> e.getTitle().length()>=10)
                .filter(e ->e.getPopularity()>=30 && e.getPopularity()<=80)
                .collect(Collectors.toList()));
        return "medium-popular-long-name";
    }

    public static List<Movie> getMovies(String route) {
        ResultsPage resultsPage = restTemplate.getForObject(route, ResultsPage.class);
        return resultsPage.getResults();
    }
}



