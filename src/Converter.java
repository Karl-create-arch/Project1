public class Converter {
    public int convertToKm(int steps) {
        return (steps * 75) / 100000; // 1 шаг = 75 см, делим на 100000 для получения км
    }

    public int convertStepsToKilocalories(int steps) {
        return (steps * 50) / 1000; // 1 шаг = 50 калорий, делим на 1000 для получения килокалорий
    }
}