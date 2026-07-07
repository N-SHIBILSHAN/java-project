import java.util.Scanner;

interface Operations {
    void add(int a, int b);
    void subtract(int a, int b);
    void evenOdd(int n);
}

// Implementing class
class Calculator implements Operations {

    @Override
    public void add(int a, int b) {
        System.out.println("Addition = " + (a + b));
    }

    @Override
    public void subtract(int a, int b) {
        System.out.println("Subtraction = " + (a - b));
    }

    @Override
    public void evenOdd(int n) {
        if (n % 2 == 0)
            System.out.println(n + " is Even");
        else
            System.out.println(n + " is Odd");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.print("Enter a number to check Even/Odd: ");
        int n = sc.nextInt();

        // Interface reference
        Operations obj = new Calculator();

        obj.add(a, b);
        obj.subtract(a, b);
        obj.evenOdd(n);

        sc.close();
    }
}