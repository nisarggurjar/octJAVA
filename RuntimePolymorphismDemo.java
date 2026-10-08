// Base Class
class PaymentMethod {
    public void processPayment(double amount) {
        System.out.printf("Processing generic payment of $%.2f%n", amount);
    }
}

// Derived Class 1
class CreditCardPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Charged $%.2f to Credit Card (includes 2%% interchange fee).%n", amount);
    }
}

// Derived Class 2
class UpiPayment extends PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Transferred $%.2f directly via UPI (Zero transaction fee).%n", amount);
    }
}

public class RuntimePolymorphismDemo {
    public static void main(String[] args) {
        // UPCASTING: Parent reference variable pointing to Child objects in Heap
        PaymentMethod payment1 = new CreditCardPayment();
        PaymentMethod payment2 = new UpiPayment();

        // DYNAMIC METHOD DISPATCH:
        // Although the reference type is PaymentMethod, the JVM resolves which
        // method to execute at RUNTIME based on the actual object instance.
        payment1.processPayment(150.0); // Executes CreditCardPayment's version
        payment2.processPayment(75.0);  // Executes UpiPayment's version

        // Heterogeneous collection demonstrating polymorphic dispatch
        PaymentMethod[] batch = { new CreditCardPayment(), new UpiPayment(), new PaymentMethod() };
        System.out.println("\n--- Processing Payment Batch ---");
        for (PaymentMethod p : batch) {
            p.processPayment(10.0);
        }
    }
}