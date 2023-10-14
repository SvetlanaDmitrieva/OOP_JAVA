public enum GameStatus {
    INIT("Игра инициирована"), START("Игра началась"),
    WIN(" Поздравляем! Вы выиграли!"), LOSE("Увы...Вы проиграли..."),
    STOP("Игра остановалена"),
    EXIT("Игра закончена");

    private String value;

    GameStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
