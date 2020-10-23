package com.lkzlee.acmcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/***
 * @author: lkzlee
 * @date: 2020-10-22 14:40
 * @desc:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()){
            int m = s.nextInt();
            int n = s.nextInt();
            String str = s.next();
            int ret = doSolve(str, m, n);
            System.out.println(ret);
        }
    }

    private static int doSolve(String str, int m, int n) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (i + n > str.length()) break;
            String subStr = str.substring(i, i + n);
            if (set.contains(subStr)) continue;
            set.add(subStr);
        }
        return set.size();
    }

}
