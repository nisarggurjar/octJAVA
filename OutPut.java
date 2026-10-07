public class OutPut {
    public static void main(String[] args) {
        
        // println: Print and move to the next line.
        System.out.println("Hello");
        System.out.println("Java");

        // print: It doesn't automatically move to the next line
        System.out.print("Hello ");
        System.out.print("Java");

        // printf: Useful for formatted output.
        String name = "Nisarg";
        int age = 26;
        System.out.printf("%nName: %s, Age: %d", name, age);
        
        double salary = 25.5;
        System.out.printf("%nSalary: %.2f%n", salary);
            /*
            commom specifiers
            ______________________________
            | Specifier | Meaning        |
            |-----------|----------------|
            | `%d`      | Integer        |
            | `%f`      | Floating-point |
            | `%s`      | String         |
            | `%c`      | Character      |
            | `%b`      | Boolean        |
            | `%n`      | New line       |
            ------------------------------
            */
    }
}
