import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private final static Scanner sc = new Scanner(System.in);

    private static void convertToBinary(int decimalNumber) {
        String result = "";
        while (decimalNumber > 0) {
            result = (decimalNumber % 2) + result;
            decimalNumber = decimalNumber / 2;
        }
        System.out.println(result);
    }

    private static boolean isBinary(String value) {
        int count = 0;
        for (int i = 0; i < value.length(); i++) {
            char temp = value.charAt(i);;
            if (temp == '0' || temp == '1') {
                count++;
            } else {
                count--;
                break;
            }
        }
        return count > 0;
    }

    private static void convertToDecimal(String value) {
        if (isBinary(value)) {
            long decimalNumber = Long.parseLong(value, 2);
            System.out.println(decimalNumber);
        } else {
            System.out.println("Not a binary");
        }
    }

    private static void equation(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (a == 0) {
            System.out.println("The solution: " + (-c / b));
        } else {
            if (delta < 0) {
                System.out.println("No solution");
            } else if (delta == 0) {
                System.out.println("The solution:" + (-b / (2 * a)));
            } else {
                System.out.println("The solution 1: " + ((-b - Math.sqrt(delta)) / (2 * a)));
                System.out.println("The solution 2: " + ((-b + Math.sqrt(delta)) / (2 * a)));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Convert to binary by decimal.");
        System.out.print("Decimal: ");
        int decimalNumber = sc.nextInt();
        if (decimalNumber < 0) {
            System.out.println("Not a positive integer");
        } else {
            System.out.print("Binary: ");
            convertToBinary(decimalNumber);
        }

        System.out.println("Convert to decimal by binary.");
        System.out.print("Binary: ");
        String value = sc.next();
        convertToDecimal(value);

        System.out.println("Quadratic equation");
        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
        double b = sc.nextDouble();
        System.out.print("c: ");
        double c = sc.nextDouble();
        equation(a, b, c);
    }

}