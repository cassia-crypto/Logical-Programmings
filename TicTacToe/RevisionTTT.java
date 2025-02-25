
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

class TicTacToe {
    TicTacToe() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        char[] var2 = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        int var3 = 0;
        int var4 = 88;

        String var5;
        for (var5 = "Dil dukha hai par toota nhi hai!"; var3 < 9; var4 = var4 == 88 ? 79 : 88) {
            printtheboard(var2);
            System.out.println("Choose a board:" + var4);
            int var6 = var1.nextInt();
            if (Character.isDigit(var2[var6 - 1])) {
                var2[var6 - 1] = (char) var4;
            } else {
                System.out.println("Sorry the Square is already taken!");
            }

            if (var2[0] + var2[1] + var2[2] == var4 * 3 || var2[3] + var2[4] + var2[5] == var4 * 3
                    || var2[6] + var2[7] + var2[8] == var4 * 3 || var2[0] + var2[4] + var2[8] == var4 * 3
                    || var2[0] + var2[3] + var2[6] == var4 * 3 || var2[1] + var2[4] + var2[7] == var4 * 3
                    || var2[2] + var2[5] + var2[8] == var4 * 3 || var2[2] + var2[4] + var2[6] == var4 * 3) {
                printtheboard(var2);
                var5 = "Badhayi ho aapko!";
                break;
            }

            ++var3;
        }

        System.out.println("\n");
        System.out.println(var5);
    }

    private static void printtheboard(char[] var0) {
        System.out.println(var0[0] + " | " + var0[1] + " | " + var0[2]);
        System.out.println("\n---------");
        System.out.println(var0[3] + " | " + var0[4] + " | " + var0[5]);
        System.out.println("\n---------");
        System.out.println(var0[6] + " | " + var0[7] + " | " + var0[8]);
    }
}
