import java.util.Arrays;

public class Demo {
    public static void main(String[] args){
        // short age;
        int[] marks = {1,23,4,52};
        System.out.println(Arrays.toString(marks));
        System.out.println(marks[1]);
        System.out.println(marks.length);
        int[] marks2 = new int[5];
        marks2[0] = 1;
        marks2[1] = 3;
        marks2[2] = 34;
        marks2[3] = 73;
        marks2[4] = 89;
    }
}