import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game {
    Integer sizeWord;
    Integer maxTry;
    String computerWord;
    GameStatus gameStatus = GameStatus.INIT;

    public AbstractGame() {
        super();
    }

    abstract ArrayList<String> generateCharList();

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;

        computerWord = generateWord();
        gameStatus = GameStatus.START;
        // value = gameStatus.getValue();
        System.out.println(gameStatus.getValue());
        System.out.println(computerWord);
    }

    private String generateWord() {
        List<String> alphabet = generateCharList();
        Random random = new Random();
        String res = "";
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(alphabet.size());
            res += alphabet.get(randomIndex);
            alphabet.remove(randomIndex);
        }
        return res;
    }

    public Integer getSizeWord() {
        return sizeWord;
    }

    public Integer getMaxTry() {
        return maxTry;
    }

    public String getWord() {
        return computerWord;
    }

    @Override
    public Answer inputValue(String value) {
        int bull = 0;
        int cow = 0;
        if (value.contains("111") ||
                value.contains("000")) {
            if (value.contains("111")) {
                gameStatus = GameStatus.STOP;
            }
            if (value.contains("000")) {
                gameStatus = GameStatus.EXIT;
            }
            System.out.println(gameStatus.getValue());
            return new Answer(bull, cow, maxTry);
        }
        int limit = computerWord.length();
        String subStr = value.length() > limit ? value.substring(0, limit) : value;
        // System.out.println(" Подстрока :" + subStr);
        for (int i = 0; i < subStr.length(); i++) {
            if (subStr.charAt(i) == computerWord.charAt(i)) {
                bull++;
                cow++;
            } else if (computerWord.contains(String.valueOf(subStr.charAt(i)))) {
                cow++;
            }
        }
        if (bull == computerWord.length()) {
            gameStatus = GameStatus.WIN;
        }
        maxTry--;
        if (maxTry == 0 && gameStatus != GameStatus.WIN) {
            gameStatus = GameStatus.LOSE;
        }
        return new Answer(bull, cow, maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
