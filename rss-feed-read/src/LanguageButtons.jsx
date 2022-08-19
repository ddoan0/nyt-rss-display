function LanguageButtons({ languageToggle, englishSelected }) {
  return (
    <>
      <button
        onClick={!englishSelected ? languageToggle : () => {}}
        style={{ fontWeight: englishSelected ? "bold" : "" }}
      >
        ENG
      </button>
      <span>/</span>
      <button
        onClick={englishSelected ? languageToggle : () => {}}
        style={{ fontWeight: englishSelected ? "" : "bold" }}
      >
        ESP
      </button>
    </>
  );
}

export default LanguageButtons;
