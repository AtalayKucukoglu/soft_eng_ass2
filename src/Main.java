import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int base = input.nextInt();
        System.out.print("Enter the exponent: ");
        int exp = input.nextInt();


        Values values = new Values();
        values.setBase(base);
        values.setExp(exp);

        IntegerPower integerPower = new IntegerPower(values);
        long result = integerPower.intPower();

        System.out.println(result);
    }
}
