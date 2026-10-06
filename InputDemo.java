import java.util.Scanner;

public class InputDemo{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter you name");
        String name = scanner.nextLine();
        System.out.printf("your name is: %s%n", name);
    }
}