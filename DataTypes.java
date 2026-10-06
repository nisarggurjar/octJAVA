public class DataTypes {
    public static void main(String[] args) {
        /*
        Java is a statically typed language.
        That means when you create a variable, you specify its type.
        */

        byte age1 = 27;
        short ins = 30000;
        int roll = 1231342; // age can contain an integer.
        long winnings = 98765432112234L;
        
        float disc = 10.55f;
        double price = 10.56757;

        char grade = 'A'; // use single quotes for char

        boolean active = true; 
        boolean active2 = false;

        System.out.printf(
            "age1: %d, ins: %d, roll: %d, winnings: %d, disc: %.1f, price: %.2f, grade: %c, active: %b, active2: %b%n",
            age1, ins, roll, winnings, disc, price, grade, active, active2
        );
        /*
        Data Types
        │
        ├── Primitive
        │
        └── Non-Primitive / Reference
        
        Primitive
        │
        ├── byte
        ├── short
        ├── int
        ├── long
        ├── float
        ├── double
        ├── char
        └── boolean
        
        | Type      | Size         | Example                  |
        |-----------|--------------|--------------------------|
        | `byte`    | 8-bit        | `byte age = 26;`         |
        | `short`   | 16-bit       | `short x = 1000;`        |
        | `int`     | 32-bit       | `int age = 26;`          |
        | `long`    | 64-bit       | `long x = 100000L;`      |
        | `float`   | 32-bit       | `float x = 10.5f;`.      |
        | `double`  | 64-bit       | `double x = 10.5;`.      |
        | `char`    | 16-bit       | `char c = 'A';`          |
        | `boolean` | JVM-dependent| `boolean active = true;` |
                    representation
        */
    }
}


/*

CSV : Primitive Data Types Summary

Data Type,Size,Default Value,Minimum Value,Maximum Value,Wrapper Constant Reference
byte,1 byte (8 bits),0,-128 (−27),127 (27−1),Byte.MIN_VALUE / MAX_VALUE
short,2 bytes (16 bits),0,"-32,768 (−215)","32,767 (215−1)",Short.MIN_VALUE / MAX_VALUE
int,4 bytes (32 bits),0,"-2,147,483,648 (−231)","2,147,483,647 (231−1)",Integer.MIN_VALUE / MAX_VALUE
long,8 bytes (64 bits),0L,"-9,223,372,036,854,775,808 (−263)","9,223,372,036,854,775,807 (263−1)",Long.MIN_VALUE / MAX_VALUE
float,4 bytes (32 bits),0.0f,≈±1.4×10−45 (smallest positive),≈±3.4028235×1038,6–7 decimal digits precision
double,8 bytes (64 bits),0.0d,≈±4.9×10−324 (smallest positive),≈±1.7976931348623157×10308,15–17 decimal digits precision
char,2 bytes (16 bits),'\u0000' (null),0 ('\u0000'),"65,535 ('\uffff')",Unsigned 16-bit Unicode character
boolean,JVM-dependent (typically 1 byte),false,false,true,Only two possible states

*/