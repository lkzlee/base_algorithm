package com.lkzlee.acmcoder;

import java.text.DecimalFormat;
import java.util.Scanner;

/***
 * @author: lkzlee
 * @date: 2020-10-22 14:40
 * @desc:
 */
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            int m = s.nextInt();
            int n = s.nextInt();
            boolean flag = false;
            for (int i = m; i <= n; i++) {
                if (isShuixian(i)) {
                    flag = true;
                    System.out.print(i+" ");
                }
            }
            if (!flag)
                System.out.println("no");
            else
                System.out.println();
        }
    }
//    public static void main(String[] args) {
//
//        Scanner s = new Scanner(System.in);
//        while (s.hasNext()) {
//            int m = s.nextInt();
//            int n = s.nextInt();
//            boolean flag = false;
//            for (int i = m; i <= n; i++) {
//                if (isShuixian(i)) {
//                    flag = true;
//                    System.out.print(i+" ");
//                }
//            }
//            if (!flag)
//                System.out.println("no");
//            else
//                System.out.println();
//        }
//
//    }

    private static boolean isShuixian(int s) {
        int h = s / 100;
        int m = (s % 100) / 10;
        int l = s % 10;
        return s == h * h * h + m * m * m + l * l * l;
    }
}
