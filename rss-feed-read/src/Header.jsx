import { useState, useEffect } from "react";
import "./Header.css";
import LanguageButtons from "./LanguageButtons";

function Header() {
  const [englishSelected, setEnglishSelected] = useState(true);
  const [today, setDate] = useState(new Date());

  function languageToggle() {
    setEnglishSelected(!englishSelected);
  }

  return (
    <div className="header">
      <ul className="headerList">
        <li className="date">
          {today.toLocaleDateString("en", { weekday: "short" }) +
            ", " +
            today.toLocaleDateString("en", {
              day: "2-digit",
              month: "short",
              year: "numeric",
            })}
        </li>
        <li>
          <img
            src="https://static01.nyt.com/images/misc/NYT_logo_rss_250x40.png"
            alt="NYT Logo"
          />
        </li>
        <li>
          <LanguageButtons
            languageToggle={languageToggle}
            englishSelected={englishSelected}
          />
        </li>
      </ul>
    </div>
  );
}

export default Header;
