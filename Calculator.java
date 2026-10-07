import java.util.Scanner;

public class Calculator{
    public static void main(String[] arg){
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter First number: ");
        double firstNumber = sn.nextDouble();
        System.out.print("Enter Second number: ");
        double secondNumber = sn.nextDouble();

        System.out.printf("Addition is: %d\n", firstNumber + secondNumber);
        System.out.printf("Subtraction is: %d\n", firstNumber - secondNumber);
        System.out.printf("Multiplication is: %d\n", firstNumber*secondNumber);
        System.out.printf("Division: %d\n", (double) firstNumber/secondNumber);
    }
}