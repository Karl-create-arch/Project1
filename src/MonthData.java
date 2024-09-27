public class MonthData {
    int[] days = new int[30]; // Массив для хранения шагов за каждый день месяца

    public void setSteps(int day, int steps) {
        days[day - 1] = steps; // День - 1 для корректной индексации
    }

    public int getSteps(int day) {
        return days[day - 1];
    }

    public int getTotalSteps() {
        int total = 0;
        for (int steps : days) {
            total += steps;
        }
        return total;
    }

    public int getMaxSteps() {
        int max = 0;
        for (int steps : days) {
            if (steps > max) {
                max = steps;
            }
        }
        return max;
    }

    public double getAverageSteps() {
        return getTotalSteps() / 30.0;
    }

    public int getBestSeries(int stepGoal) {
        int bestSeries = 0;
        int currentSeries = 0;
        for (int steps : days) {
            if (steps >= stepGoal) {
                currentSeries++;
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return bestSeries;
    }
}