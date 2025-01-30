import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например,7 - 4):");
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println(result);

    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода. Используйте формат: число операция число");
        }

        int a, b;
        a = Integer.parseInt(parts[0]);
        b = Integer.parseInt(parts[2]);

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть в диапазоне от 1 до 10 включительно.");
        }

        String operation = parts[1];
        int result = 0;

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
                    throw new Exception("Деление на ноль недопустимо.");
                }
                result = a / b;
                break;
            default:
                throw new Exception("Неподдерживаемая операция. Используйте +, -, *, /.");

        }
        return String.valueOf(result);
    }
}



