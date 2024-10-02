public class MonthData {
    int[] days = new int[30];

    public void setSteps(int day, int steps) {
        days[day - 1] = steps;
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

    // TODO переделать тип возвращаемого значения, чтоб не было знаков после запятой
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