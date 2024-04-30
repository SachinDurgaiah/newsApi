package com.apiService.newsApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiService.newsApi.Article.Articles;

@Service
public class NewsAPIService {

    String apiKey = "";
    
    @Autowired
    private RestTemplate restTemplate;

    // This method will hit the newsData end-point and return articles based on the condition in the query.
    public Object fetchArticles(String param) {
        String url = "https://newsdata.io/api/1/news?apikey="+apiKey+param;        
        return restTemplate.getForObject(url, Articles.class);
    }
}
