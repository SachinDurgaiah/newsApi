package com.apiService.newsApi.Article;

import java.util.List;

import com.apiService.newsApi.Article.Article;

public class Articles {
    private List<Article> results;
    private String status;
    

    public List<Article> getResults() {
        return results;
    }

    public void setResults(List<Article> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
