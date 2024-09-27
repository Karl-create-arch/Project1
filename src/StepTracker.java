public class StepTracker {
    MonthData[] months = new MonthData[12]; // Массив данных для каждого месяца
    int dailyStepGoal = 10000; // Цель по умолчанию
    Converter converter = new Converter();
    String[] monthNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public StepTracker() {
        for (int i = 0; i < months.length; i++) {
            months[i] = new MonthData();
        }
    }

    public void addSteps(int month, int day, int steps) {
        if (month >= 1 && month <= 12 && day > 0 && day <= 30) {
            months[month - 1].setSteps(day, steps); // Преобразуем месяц в индекс массива
            System.out.println("Шаги успешно добавлены.");
        } else {
            System.out.println("Неверный ввод месяца или дня.");
        }
    }

    public void setDailyStepGoal(int goal) {
        if (goal > 0) {
            dailyStepGoal = goal;
            System.out.println("Новая цель установлена: " + goal + " шагов в день.");
        } else {
            System.out.println("Цель должна быть положительным числом.");
        }
    }

    public void printStatistic(int month) {
        if (month >= 1 && month <= 12) {
            MonthData monthData = months[month - 1]; // Преобразуем месяц в индекс массива
            System.out.println("Статистика за " + monthNames[month - 1] + ":");
            System.out.println("Шаги по дням:");
            for (int i = 0; i < 30; i++) {
                System.out.println((i + 1) + " день: " + monthData.getSteps(i + 1));
            }

            int totalSteps = monthData.getTotalSteps();
            System.out.println("Общее количество шагов за месяц: " + totalSteps);
            System.out.println("Максимальное количество шагов за месяц: " + monthData.getMaxSteps());
            System.out.println("Среднее количество шагов за месяц: " + monthData.getAverageSteps());
            System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(totalSteps));
            System.out.println("Сожжённые килокалории: " + converter.convertStepsToKilocalories(totalSteps));
            System.out.println("Лучшая серия дней с выполненной целью: " + monthData.getBestSeries(dailyStepGoal));
        } else {
            System.out.println("Неверный номер месяца.");
        }
    }
}