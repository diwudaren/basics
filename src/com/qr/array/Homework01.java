package com.qr.array;

/**
 * 循环的作业
 * @author zjt
 * @date 2021/3/8
 */
public class Homework01 {

    public static void main(String[] args) {
        //第一题
//        TaskOne.whileCalculation();
        //第er题
//        TaskOne.calculation();
        //第三题
//        TaskOne.outNumber();
        //第四题
        TaskOne.outLetter();
    }


    /**
     * 循环的作业
     */
    static class TaskOne {

        /**
         * 第四题
         * 输出小写的a~z和大写的A~Z
         */
        public static void outLetter() {
            for (int i = 'a'; i <= 'z'; i++) {
                System.out.print((char) i + " ");
                System.out.print((char) (i - 32) + " ");
            }
            System.out.println();

        }

        /**
         * 第三题
         * 输出1~100之间不能被5整除的数，每行打印5个
         */
        public static void outNumber() {
            int count = 0;
            for (int i = 1; i <= 100; i++) {
                if (i % 5 != 0) {
                    System.out.print(i + "\t");
                    count++;
                    if (count % 5 == 0) {
                        System.out.println();
                    }
                }
            }

        }


        /**
         * 作业二
         * 判断一个整数是否为一个水仙花数
         * 如：153 = 1*1*1 + 5*5*5 + 3*3*3
         */
        public static void calculation() {
            System.out.print("水仙花数\n");
            for (int i = 111; i < 1000; i++) {
                int hundred = i / 100;
                int tens = i % 100 / 10;
                int mono = i % 10;
                if (hundred * hundred * hundred + tens * tens * tens + mono * mono * mono == i) {
                    System.out.print(i + " = " + hundred + "*" + hundred + "*" +
                            hundred + " + " + tens + "*" + tens + "*" + tens + " + " + mono + "*" + mono + "*" + mono + "\n");
                }
            }
        }

        /**
         * 作业一
         * 某人有100，000元，没经过一次路口，需要缴费
         * 规则：
         * 当现金>50000时，每次缴纳5%
         * 当现金<= 50000时，每次缴纳1000
         * 编程计算该人可以经过多少次路口，
         * 要求：
         * 使用while + break 完成
         */
        public static void whileCalculation() {
            double money = 100000;
            int conut = 0;
            while (true) {
                conut++;
                if (money > 50000) {
                    money *= 0.95;
                    continue;
                }
                money -= 1000;
                if (money <= 1000) {
                    break;
                }
            }
            System.out.println(conut);
        }
    }
}
