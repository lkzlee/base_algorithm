package com.lkzlee.interview.nowcoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * 有一个商场购物活动，同一时间内，用户可免单，同一秒内只能有一个用户免单。
 * 下单时间格式：yyyy-MM-dd HH:mm:ss.SSS
 * 限制条件：
 *   0<n<=50000  这个条件没用到,最多有5w个顾客免单
 *   2000<=y<=2020
 *   0<MM<=12
 *   0<dd<=28
 *   0<=HH<=23
 *   0<=mm<=59
 *   0<=ss<=59
 *   0<=SSS<=999
 *
 * 如：
 * 2019-07-01 00:00:00.001
 * 2019-07-01 00:00:00.001
 * 2019-07-01 00:00:00.003
 * 2019-08-02 10:18:10.773
 * 输出：
 * 3
 *
 * 2019-07-01 00:00:00.001
 * 2019-07-01 00:00:00.002
 * 2019-07-01 00:00:00.003
 *
 * 输出：
 * 1
 *
 * 时间限制：2s
 * 内存限制：31072k
 *
 */
public class Main3 {

    public int normalFree() {
        Scanner scanner = new Scanner(System.in);

        int freeCount = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            //key用到秒格式，value是对应到毫秒
            //内存有限制 ，大约在128MB左右
            //利用限制条件做优化
            Map<Long, Long> freeMap = new HashMap<Long, Long>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                try {
                    //调试用
                    //if (line.equals("-1")) break;
                    Date time = sdf.parse(line);
                    long secondKey = time.getTime() / 1000;
                    if (freeMap.containsKey(secondKey)) {
                        if (freeMap.get(secondKey) == time.getTime())
                            freeCount++;
                    } else {
                        freeMap.put(secondKey, time.getTime());
                        freeCount++;
                    }
                } catch (ParseException e) {
                    throw new RuntimeException("handler input line error,plz check input format");
                }
            }
            return freeCount;
        } catch (Exception e) {
            //todo
            //做异常处理
        } finally {
            scanner.close();
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int freeCount = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            //key用到秒格式，value是对应到毫秒
            //内存有限制 ，大约在128MB左右
            //利用限制条件做优化
            /***
             * 题目限制条件：
             * 0<n<=50000  这个条件没用到,最多有5w个顾客免单
             * 2000<=y<=2020
             * 0<MM<=12
             * 0<dd<=28
             * 0<=HH<=23
             * 0<=mm<=59
             * 0<=ss<=59
             * 0<=SSS<=999
             */
            //20  5 bit
            //12 4 bit
            //28 5 bit
            //24 5 bit
            //59 6 bit
            //59 6 bit
            //拆开来存
            //SSS 11 bit
            //total:37 == 5 byte
//            Set<Long> freeSet=new HashSet<>(50000);
            Map<Integer, Short> freeMap = new HashMap<Integer, Short>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                try {
                    //调试用
                    //if (line.equals("-1")) break;
                    Date time = sdf.parse(line);
                    int s = (time.getYear() - 2000) & 0x1F;
                    s = (s << 5) | (time.getMonth() & 0xF);
                    s = (s << 4) | (time.getDay() & 0x1F);
                    s = (s << 5) | (time.getHours() & 0x3F);
                    s = (s << 6) | (time.getMinutes() & 0x3F);
                    s = (s << 6) | (time.getSeconds() & 0x3F);
                    short millSec = Long.valueOf(time.getTime() % 1000).shortValue();
                    if (freeMap.containsKey(s)) {
                        if (freeMap.get(s) == millSec)
                            freeCount++;
                    } else {
                        freeMap.put(s, millSec);
                        freeCount++;
                    }


                } catch (ParseException e) {
                    throw new RuntimeException("handler input line error,plz check input format");
                }
            }
            System.out.println(freeCount);
        } catch (Exception e) {
            //todo
            //做异常处理
        } finally {
            scanner.close();
        }

    }
}
