package org.example;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        try(Scanner scanner = new Scanner(System.in)){

            System.out.print("Введите размер списка: ");
            String input = scanner.nextLine();
            int listSize = Integer.parseInt(input);

            System.out.print("Введите верхнюю границу для значений: ");
            input = scanner.nextLine();
            int upperLimit = Integer.parseInt(input);

            logger.log("Создаём и наполняем список");
            List<Integer> list = new Random()
                    .ints(0, upperLimit + 1)
                    .limit(listSize)
                    .boxed()
                    .toList();

            System.out.print("Случайный список: ");
            list.forEach(i -> System.out.print(i + " "));
            System.out.println();

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            input = scanner.nextLine();
            int lowerTreshhold = Integer.parseInt(input);

            Filter filter = new Filter(lowerTreshhold);
            List<Integer> fList = filter.filterOut(list);
            logger.log("Прошло фильтр " + fList.size() + " Элемента из " + listSize);

            logger.log("Выводим результат на экран");
            System.out.print("Отфильтрованный список: ");
            fList.forEach(i -> System.out.print(i + " "));
            System.out.println();

        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.log("Завершаем программу");
    }
}