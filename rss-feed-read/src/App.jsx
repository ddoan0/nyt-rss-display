import { useEffect, useState } from "react";
import Header from "./Header";
import "./App.css";

function App() {
  const URL = "http://localhost:8080/rss";
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch(URL)
      .then((res) => res.json())
      .then((data) =>
        data.forEach((item) => {
          setData([
            ...data,
            {
              id: item.id,
              title: item.title,
              link: item.link,
              description: item.description,
              pubDate: item.pubDate,
              imageUrl: item.url,
              imageHeight: item.imageHeight,
              imageWidth: item.imageWidth,
            },
          ]);
        })
      );
  }, []);

  return (
    <div className="Wrapper">
      <Header />
      <div className="App">
        {data.map((item) => (
          <div className="panel" key={item.id}>
            <div className="textColumn">
              <a className="text" href={item.link}>
                <h2>{item.title}</h2>
              </a>
              <p className="text">{item.description}</p>
              <p className="text">{item.pubDate}</p>
            </div>
            <img
              src={item.imageUrl}
              alt={"alt"}
              width={item.imageWidth}
              height={item.imageHeight}
            />
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
