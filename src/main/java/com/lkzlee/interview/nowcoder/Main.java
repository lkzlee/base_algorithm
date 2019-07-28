package com.lkzlee.interview.nowcoder;

import java.util.Scanner;

public class Main {
    public int exchanges(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return 1;
        }
        return n / 3 + exchanges(n / 3 + n % 3);
    }

    public int mathExchange(int n) {
        if (n < 0) return 0;
        return n / 2;
    }

    public static void main(String[] args) {
        //if (args == null || args.length <= 0) return;
        Scanner scan = new Scanner(System.in);
        Main s = new Main();
        try {
            while (true) {
                int n = scan.nextInt();
                if (n <= 0) break;
                if (n < 1 || n > 100) break;
//            System.out.println(s.exchanges(n));
                System.out.print("\n" + s.mathExchange(n));

            }
        } catch (Exception e) {

        } finally {
            scan.close();
        }
    }
}