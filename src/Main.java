import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Введите номер месяца (1 - Январь, 12 - Декабрь): ");
                int month = scanner.nextInt();
                if (month > 0 && month < 13) {
                    System.out.println("Введите день месяца от 1 до 30: ");
                    int day = scanner.nextInt();
                    if (day > 0 && day < 31) {
                        System.out.println("Введите количество шагов: ");
                        int steps = scanner.nextInt();
                        stepTracker.addSteps(month, day, steps);
                    } else {
                        System.out.println("Введите значение от 1 до 30");
                        System.out.println();
                    }
                } else {
                    System.out.println("Введите значение от 1 до 12");
                    System.out.println();
                }

            } else if (command == 2) {
                System.out.println("Введите новую цель по шагам: ");
                int goal = scanner.nextInt();
                stepTracker.setDailyStep(goal);

            } else if (command == 3) {
                System.out.println("Введите номер месяца для статистики (1 - Январь, 12 - Декабрь): ");
                int month = scanner.nextInt();
                stepTracker.printStatistic(month);

            } else if (command == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Неверная команда. Попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Изменить цель по количеству шагов");
        System.out.println("3 - Напечатать статистику за месяц");
        System.out.println("0 - Выйти из приложения");
    }
}