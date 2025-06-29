package service;

import java.util.Scanner;

public class PaymentService {

    public enum PaymentOption {
        CREDIT_CARD,
        DEBIT_CARD,
        CASH_ON_DELIVERY
    }

    private Scanner scanner = new Scanner(System.in);

    public PaymentOption choosePaymentMethod() {
        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Debit Card");
        System.out.println("3. Cash on Delivery");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: return PaymentOption.CREDIT_CARD;
            case 2: return PaymentOption.DEBIT_CARD;
            case 3: return PaymentOption.CASH_ON_DELIVERY;
            default:
                System.out.println("Invalid choice. Defaulting to Cash on Delivery.");
                return PaymentOption.CASH_ON_DELIVERY;
        }
    }

    public void processPayment(PaymentOption option, double amount) {
        System.out.println("Processing payment of ₹" + amount + " via " + option);

        switch (option) {
            case CREDIT_CARD:
            case DEBIT_CARD:
                System.out.println("Payment successful! Card charged ₹" + amount);
                break;
            case CASH_ON_DELIVERY:
                System.out.println("Payment will be collected on delivery.");
                break;
        }

        System.out.println("Order confirmed. Thank you for shopping!");
    }
}

