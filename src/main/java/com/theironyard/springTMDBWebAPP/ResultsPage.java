package com.theironyard.springTMDBWebAPP;

import java.util.List;

public class ResultsPage {
    List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public ResultsPage(){}

    public ResultsPage(List<Movie> results) {
        this.results = results;
    }
}
