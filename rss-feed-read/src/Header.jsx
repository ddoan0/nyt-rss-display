import { useState } from "react";
import "./Header.css";
import LanguageButtons from "./LanguageButtons";

function Header() {
  const [englishSelected, setEnglishSelected] = useState(true);

  function languageToggle() {
    setEnglishSelected(!englishSelected);
  }

  return (
    <div className="header">
      <ul className="headerList">
        <li>Mon, 15 Aug 2022</li>
        <li>The New York Times</li>
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
