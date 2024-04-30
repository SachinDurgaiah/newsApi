package com.apiService.newsApi.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiService.newsApi.Service.NewsAPIService;


@RestController
public class NewsDataController {

    public int articleLimit = 5;

    @Autowired
    private NewsAPIService newsAPIService;

    @GetMapping("/")
    public String hello(){
        return "Welcome to the NewsArticle API.";
    }

    // This method helps users look for articles which are trending and also provide the number of articles they want to see which is an optional field.
    // Sample URL to hit this end-point: http://localhost:8080/newsArticles/trending?limit=3
    @GetMapping("/newsArticles")
    @Cacheable("articles")
    public @ResponseBody Object getTrendingArticles(@RequestParam (name="limit", required = false) String limit) {
        String param = "";
        if(limit != null && Integer.parseInt(limit) > 0){
            param = param+"&size="+limit;
        }
        return newsAPIService.fetchArticles(param);
    }

    // This method helps users look for articles with title and also provide the number of articles they want to see.
    // Sample URL to hit this end-point: http://localhost:8080/newsArticles/findByTitle?title=pizza&limit=3
    @GetMapping("/newsArticles/findByTitle")
    @Cacheable("titles")
    public @ResponseBody Object getArticlesByTitle(@RequestParam (name="title") String title, @RequestParam (name="limit", required = false) String limit) {
        String param = "";
        if(title != null){
            param = "&qInTitle="+title;
        } 
        if(limit != null && Integer.parseInt(limit) > 0){
            param = param+"&size="+limit;
        }
        return newsAPIService.fetchArticles(param);   
    }

    // This method helps users look for articles with specific keywords and also provide the number of articles they want to see.
    // Sample URL to hit this end-point: http://localhost:8080/newsArticles/findByKeyword?keyword=nyc&keyword=hotel&limit=1
    @GetMapping("/newsArticles/findByKeyword")
    @Cacheable("keyword")
    public @ResponseBody Object getArticlesByKeyword(@RequestParam(name="keyword") List<String> keyword, @RequestParam (required = false) String limit) {
        String param = "";
        if(keyword != null && keyword.size() > 0 ){
            String keywords = keyword.get(0);
            for (int i=1; i< keyword.size(); i++) {
                keywords = keywords + " AND " + keyword.get(i);
                
            }
            System.out.println(keywords);
            param = "&q="+keywords; 
            System.out.println(param);

        }
        if(limit != null && Integer.parseInt(limit) > 0){
            param = param+"&size="+limit;
        }
        return newsAPIService.fetchArticles(param);
    }
}
