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
                System.out.println("Введите день месяца (1-30): ");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов: ");
                int steps = scanner.nextInt();
                stepTracker.addSteps(month, day, steps);

            } else if (command == 2) {
                System.out.println("Введите новую цель по шагам: ");
                int goal = scanner.nextInt();
                stepTracker.setDailyStepGoal(goal);

            } else if (command == 3) {
                System.out.println("Введите номер месяца для статистики (1 - Январь, 12 - Декабрь): ");
                int month = scanner.nextInt();
                stepTracker.printStatistic(month);

            } else if (command == 4) {
                System.out.println("Выход из программы.");
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
        System.out.println("4 - Выйти из приложения");
    }
}