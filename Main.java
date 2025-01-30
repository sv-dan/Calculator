import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например,7 - 4):");
        String input = scanner.nextLine();
        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        // Разделяем строку на части по пробелам
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода. Используйте формат: число операция число");
        }

        // Преобразуем строки в целые числа
        int a, b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат чисел. Используйте целые числа.");
        }

        // Проверяем диапазон чисел
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }

        // Определяем операцию
        String operation = parts[1];
        int result;

        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль недопустимо.");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемая операция. Используйте +, -, *, /.");
        }

        // Возвращаем результат в виде строки
        return String.valueOf(result);
    }
}


