class eventhread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.println("Even Thread: " + i);
            }
        }
    }
}

class oddthread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd Thread: " + i);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        eventhread thread1 = new eventhread();
        oddthread thread2 = new oddthread();

        thread1.start();
        thread2.start();
    }
}