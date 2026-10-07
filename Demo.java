import java.util.Scanner;

public class Demo {
    public static void main(String[] args){
        // short age;
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        String name = sn.nextLine();
        System.out.print("Enter your Age: ");
        short age = sn.nextShort();
        System.out.printf("Your name is : %s\nage is %d",name, age);
    }
}
