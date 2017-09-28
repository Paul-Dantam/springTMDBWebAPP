package com.theironyard.springTMDBWebAPP;

public class MovieResult {

    Object results;
    int page;
    int total_results;
    Object dates;
    int total_pages;

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public Object getDates() {
        return dates;
    }

    public void setDates(Object dates) {
        this.dates = dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=be2a38521a7859c95e2d73c48786e4bb";
    MovieResult movieResult = restTemplate.getForObject(movieURL, MovieResult.class)
}