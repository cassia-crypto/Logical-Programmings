import java.util.Scanner;

public class Numguess {
    public static void toguess() {

        Scanner sc = new Scanner(System.in);

        int x = 1 + (int) (100 * Math.random());
        // int x=90; (to check the code)
        int k = 5;
        int c = 0;

        for (int i = 0; i < k; i++) {

            c++;
            System.out.println("Enter the number");
            int t = sc.nextInt();

            if (t == x) {
                c++;
                System.out.println("Congratulations you have guessed the number right");
                break;
            }

            else if (t < x) {
                System.out.println("Your number is less than the actual number");

            } else {
                System.out.println("Your number is greater than the actual number");

            }
        }
        if (c == 0) {
            System.out.println("\n");
            System.out.println("You have exhausted " + k + " trials!");
            System.out.println("The actual number is:" + x);
            System.out.println("Nice try though!");
        }
        sc.close();

    }

    public static void main(String args[]) {
        toguess();
    }
}
