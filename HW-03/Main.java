import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean fl = true;
        Integer sizeWord = 0, maxTry = 0;
        String scannerString;
        Game game1 = new NumberGame();
        Game game2 = new LatinGame();
        Game game3 = new CyrillicGame();
        Scanner scanner = new Scanner(System.in);
        List<String> allTry = new ArrayList<String>();
        String enter;
        allTry.add("");
        while (fl) {
            allTry.clear();
            System.out.println("Введите длину слова:");
            sizeWord = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите количество попыток:");
            maxTry = Integer.parseInt(scanner.nextLine());
            System.out.println("Для ввода строки цифр - нажмите 1");
            System.out.println("Для ввода строки латиницы - нажмите 2");
            System.out.println("Для ввода строки кириллицы - нажмите 3");
            scannerString = scanner.nextLine();
            String strEnter = "цифр";

            Game game = game1;
            if (scannerString.contains("2")) {
                game = game2;
                strEnter = "букв латиницы";
            }
            if (scannerString.contains("3")) {
                game = game3;
                strEnter = "букв кириллицы";
            }

            game.start(sizeWord, maxTry);
            while (game.getGameStatus() != GameStatus.WIN && game.getGameStatus() != GameStatus.LOSE) {
                System.out.println("Осталось " + game.getMaxTry() + " попыток");
                System.out.println(" Введите комбинацию из " + game.getSizeWord() + " " +
                        strEnter + "; для остановки игры - 111, для прекращения - 000");
                scannerString = scanner.nextLine();
                Answer answer = game.inputValue(scannerString);

                if (game.getGameStatus() == GameStatus.STOP) {
                    continue;
                }
                if (game.getGameStatus() == GameStatus.EXIT) {
                    fl = false;
                    break;
                }
                enter = "answer = " + scannerString + " " + answer;
                System.out.println(answer);
                allTry.add(enter);
            }
            // System.out.println("game.getGameStatus() = " + game.getGameStatus());
            if (game.getGameStatus() == GameStatus.WIN) {
                System.out.println((GameStatus.WIN.getValue()));
            } else {
                if (game.getGameStatus() == GameStatus.LOSE) {
                    System.out.println((GameStatus.LOSE.getValue()));
                }
            }
            System.out.println("Новая игра - 222, выйти - 000");
            scannerString = scanner.nextLine();

            // System.out.println( "Введено :" + scannerString.toUpperCase());

            if (scannerString.contains("0")) {
                fl = false;
            }
            System.out.println("Показать искомую строку? yes/no");
            scannerString = scanner.nextLine();
            if (scannerString.toLowerCase().contains("y")) {
                System.out.println(" Искомая строка:" + game.getWord());
            }

            System.out.println("Вывести историю попыток? yes/no");
            scannerString = scanner.nextLine();
            if (scannerString.toLowerCase().contains("y")) {
                for (int i = 0; i < allTry.size(); i++) {
                    System.out.println(allTry.get(i));
                }
            }
        }
        scanner.close();
    }
}
