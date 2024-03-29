public interface Game {
    void start(Integer sizeWord, Integer maxTry);
    Answer inputValue(String value);
    GameStatus getGameStatus();
    Integer getSizeWord();
    Integer getMaxTry();
    String getWord();
}
