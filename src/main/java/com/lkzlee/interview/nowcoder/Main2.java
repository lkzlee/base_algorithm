package com.lkzlee.interview.nowcoder;

import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;
        import java.util.TreeSet;

public class Main2 {
    public static Map<Character, Integer> hexMap = new HashMap<Character, Integer>();

    static {
        hexMap.put('0', 0);
        hexMap.put('1', 1);
        hexMap.put('2', 1);
        hexMap.put('3', 1);
        hexMap.put('4', 1);
        hexMap.put('5', 1);
        hexMap.put('6', 1);
        hexMap.put('7', 1);
        hexMap.put('8', 1);
        hexMap.put('9', 1);
        hexMap.put('a', 10);
        hexMap.put('b', 11);
        hexMap.put('c', 12);
        hexMap.put('d', 13);
        hexMap.put('e', 14);
        hexMap.put('f', 15);

    }

    public static int toBase10(String hexStr) {
        if (hexStr == null || hexStr.isEmpty()) return 0;
        if (hexStr.length() <= 2) return 0;
        int n = 0;
        for (int i = hexStr.length() - 1; i >= 2; i--) {
            if (!hexMap.containsKey(hexStr.charAt(i))){
                return 0;
            }
            n += n * 16 + hexMap.get(hexStr.charAt(i));
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String n = scan.next();
            System.out.println(toBase10(n.toLowerCase()));
        }
    }
}