This project contains springBoot api to get news articles based on the title, topic of interest and also get the trending news articles. 

Getting project up and running.

mvn spring-boot:run should get the project up and running.

Here are some sample queries to hit the end-point in this app.

If a users wants to look for articles which are trending and also provide the number of articles they want to see.
End-point URL with sample query variables: http://localhost:8080/newsArticles/trending?limit=3

If a users wants to look for articles with title and also provide the number of articles they want to see.
End-point URL with sample query variables: http://localhost:8080/newsArticles/findByTitle?title=pizza&limit=3

If a users wants to look for articles with specific keywords and also provide the number of articles they want to see.The user can look up articles which would match multiple keywords.
End-point URL with sample query variables: http://localhost:8080/newsArticles/findByKeyword?keyword=nyc&keyword=hotel&limit=1

The limit parameter in the URL is optional.