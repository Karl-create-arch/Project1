public class Converter {
    // TODO итоги работы этих методов вынести в переменные. Сделать общий метод по конвертации
    public int convertToKm(int steps) {
        return (steps * 75) / 100000;
    }

    public int convertStepsToKilocalories(int steps) {
        return (steps * 50) / 1000;
    }
}