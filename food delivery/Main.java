class Chef extends Thread {
    public void run() {
        System.out.println("Chef: Cooking started...");
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("Chef: Food is ready.");
    }
}

class Payment extends Thread {
    public void run() {
        System.out.println("Payment: Processing...");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        System.out.println("Payment: Successful.");
    }
}

class Delivery extends Thread {
    public void run() {
        System.out.println("Delivery: Delivering food...");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
        }
        System.out.println("Delivery: Order delivered.");
    }
}

public class Main{
    public static void main(String[] args) {

        System.out.println("========= ONLINE FOOD DELIVERY =========");
        System.out.println();
        System.out.println("Customer placed an order.");
        System.out.println();

        Chef chef = new Chef();
        Payment payment = new Payment();
        Delivery delivery = new Delivery();

        chef.start();
        payment.start();
        delivery.start();

        try {
            chef.join();
            payment.join();
            delivery.join();
        } catch (Exception e) {
        }

        System.out.println();
        System.out.println("Order completed successfully.");
        System.out.println("Thank you for ordering!");
    }
}