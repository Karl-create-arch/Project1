public class StepTracker {
    MonthData[] months = new MonthData[12];
    // TODO лучше бы удалить эти дурацкие комментарии
    int dailyStep = 10000; // Цель по умолчанию
    Converter converter = new Converter();
    String[] monthNames = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};

    public StepTracker() {
        for (int i = 0; i < months.length; i++) {
            months[i] = new MonthData();
        }
    }

    public void addSteps(int month, int day, int steps) {
        months[month - 1].setSteps(day, steps);
        System.out.println("Шаги успешно добавлены.");
    }

    public void setDailyStep(int target) {
        if (target > 0) {
            dailyStep = target;
            System.out.println("Новая цель установлена: " + target + " шагов в день.");
            System.out.println("Ты Поляква");
        } else {
            System.out.println("Цель должна быть положительным числом.");
        }
    }

    public void printStatistic(int month) {
        // TODO лучше бы удалить эти дурацкие комментарии
        MonthData monthData = months[month - 1]; // Преобразуем месяц в индекс массива
        System.out.println("Статистика за " + monthNames[month - 1] + ":");
        System.out.println("Шаги по дням:");
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + monthData.getSteps(i + 1));
        }

        int totalSteps = monthData.getTotalSteps();
        System.out.println("Общее количество шагов за месяц: " + totalSteps);
        System.out.println("Максимальное количество шагов за месяц: " + monthData.getMaxSteps());
        // TODO это можно вынести в единый метод конвертации, оставив тут только его вызов
        System.out.println("Среднее количество шагов за месяц: " + monthData.getAverageSteps());
        System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(totalSteps));
        System.out.println("Сожжённые килокалории: " + converter.convertStepsToKilocalories(totalSteps));
        System.out.println("Лучшая серия дней с выполненной целью: " + monthData.getBestSeries(dailyStep));
    }
}