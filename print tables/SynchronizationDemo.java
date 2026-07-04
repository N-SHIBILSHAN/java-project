import java.util.Scanner;

class Table {
    synchronized void printTable(int n) {
        System.out.println("\nTable of " + n);
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class MyThread1 extends Thread {
    Table t;
    int num;

    MyThread1(Table t, int num) {
        this.t = t;
        this.num = num;
    }

    public void run() {
        t.printTable(num);
    }
}
public class SynchronizationDemo {8
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();
        Table obj = new Table();
        MyThread1 t1 = new MyThread1(obj, n1);
        t1.start();
        sc.close();
    }
}