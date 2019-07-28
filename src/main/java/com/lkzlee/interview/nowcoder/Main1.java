package com.lkzlee.interview.nowcoder;

import java.util.Scanner;
import java.util.TreeSet;

public class Main1 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            for (int i = 0; i < n; i++) {
                int b = scan.nextInt();
                set.add(b);
            }
            for (Integer t : set) {
                System.out.println(t);
            }
        }
    }
}