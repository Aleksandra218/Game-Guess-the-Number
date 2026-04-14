package presentation;

public enum Message {
    HINT_LESS(MessageType.HINT,"Меньше!"),
    HINT_MORE(MessageType.HINT,"Больше!"),
    HINT_PROVIDE(MessageType.HINT,"Подсказка: %s"),

    ERROR_NOT_NUMBER(MessageType.ERROR,"Ошибка: вы ввели текст или дробное число. Пожалуйста, введите целое положительное число."),
    ERROR_NUMBER_OUT_OF_BOUNDS(MessageType.ERROR,"Ошибка: Число за пределами границ. Введите целое число от 1 до %d"),
    ERROR_OUT_OF_BOUNDS_LEVEL(MessageType.ERROR, "Ошибка: Число за пределами границ. Введите число от 1 до 4."),
    ERROR_TEXT_REPLAY(MessageType.INFO,"Пожалуйста, введите 'да' или 'нет'."),

    LOSE_END_GAME_RECORD(MessageType.LOSE,"Спасибо за игру! Игра завершена. Ваш рекорд: %d"),
    LOSE_END_GAME_SCORE(MessageType.LOSE,"Спасибо за игру! Игра завершена. Количество очков: %d"),
    //вычислить разницу между бест рекорд и бестрезалт строка 25 инпут валидэйшен,
    LOSE_GAME_OVER(MessageType.LOSE,"К сожалению, вы не угадали число. Загаданное число было: %d"),

    INFO_SCORE_END_GAME(MessageType.INFO, "Количество очков: %d"),
    WIN_MESSAGE(MessageType.WIN,"Поздравляю! Вы угадали число %d за %d попыток!"),


    INFO_NUMBER_MAX_NUMBER(MessageType.INFO,"Введите целое положительное число от 1 до %d"),
    INFO_ASK_REPLAY(MessageType.INFO,"Хочешь сыграть ещё? (да/нет)"),
    INFO_CURRENT_RECORD(MessageType.INFO,"Текущий рекорд: %d ещё нет"), //вычислить какое тут число
    INFO_ATTEMPTS_HISTORY(MessageType.INFO,"Ваши попытки: %s"),
    INFO_SELECTED_LEVEL(MessageType.INFO,"Выбран уровень: %s. Угадай число от 1 до %d. Попыток: %d"),
    INFO_ASK_LEVEL(MessageType.INFO,"Выбери уровень сложности:  \n" +
                "1 — Лёгкий (1–50, 12 попыток)  \n" +
                "2 — Средний (1–100, 10 попыток)  \n" +
                "3 — Сложный (1–200, 8 попыток) \n" +
                "4 - Эксперт (1-500, 6 попытки)"),
    INFO_START_GAME_MESSAGE(MessageType.INFO,"Добро пожаловать в игру \"Угадай число!\"");

    private final MessageType type;
    private final String template;

    Message(MessageType type, String template) {
        this.type = type;
        this.template = template;
    }

    public MessageType getType() {
        return type;
    }

    public String getTemplate() {
        return template;
    }
}
