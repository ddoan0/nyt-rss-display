# RSS Reader
This project has a java spring boot backend that reads RSS from nyt technology page and makes it an available resource the /rss endpoint. The react front end consumes from that endpoint and displays the items as a list.

### Software Requirements

Java Development Kit 11+

Node JS 14+

### To run the frontend

`cd rss-feed-read`

`npm install`

`npm run dev`

This will start a react app on localhost:5173

### To run the backend

`cd rss-reader`

`./mvnw clean install`

`./mvnw spring-boot:run`

This will start a spring boot app on localhost:8080
