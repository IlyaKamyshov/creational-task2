package org.example;

public class Logger {
    protected int num = 1;

    public void log(String msg) {
        System.out.println("[" + java.time.LocalDate.now() + " "
                + java.time.LocalTime.now() + " " + num++ + "] " + msg);
    }

    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static final Logger LOGGER = new Logger();

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {
    }

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле
    public static Logger getInstance() {
        return LOGGER;
    }
}
