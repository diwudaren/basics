package com.qr.object;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author zjt
 * @date 2021/3/9
 */
public class Homework02 {

    public static void main(String[] args) {
        Circle circle = new Circle(2);
        System.out.println("计算周长: " + circle.perimeter());
        System.out.println("计算面积: " + circle.area());
        Cale cale = new Cale(2, 10);
        System.out.println("加: " + cale.addition());
        System.out.println("减: " + cale.subtract());
        System.out.println("乘: " + cale.multiplication());
        Double division = cale.division();
        if (division != null) {
            System.out.println("商: " + division);
        }
        System.out.println(method(method(10.0, 20.0), 100));

        new Tom().game();
    }

    /**
     * 第三题
     * 写出定义方法的名字
     * 调用语句
     * System.out.println(method(method(10.0,20.0),100));
     */
    private static double method(double v, double v1) {
        return v + v1;
    }

}


/**
 * 第四题
 * 小游戏
 * Tom给电脑猜拳
 * 电脑每次生成 0、 1、 2、 0表示石头、 1表示剪刀、 2、表示 布
 * 玩三次并显示Tom输赢次数
 */
class Tom {
    int count = 0;
    int wiSum = 0;
    int loseSum = 0;
    // 利用正则表达式判断字符串是否是数字
    Pattern pattern = Pattern.compile("[0-9]*");

    public void game() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请出：0、1、2 (0表示 石头, 1表示 剪刀, 2、表示 布)");
            for (int i = 0; i < 3; i++) {
                int anInt = gitNumber(scanner);
                int random = (int) (Math.random() * 3);
                String anStr = anInt == 0 ? "石头" : anInt == 1 ? "剪刀" : "布";
                String randomStr = random == 0 ? "石头" : random == 1 ? "剪刀" : "布";
                if ((anInt == random)) {
                    System.out.println("你出的是 " + anStr + " 电脑出的是 " + randomStr + " 平局");
                    continue;
                }
                if ((anInt == 0 && random == 1) ||
                        (anInt == 1 && random == 2) ||
                        (anInt == 2 && random == 0)) {
                    System.out.println("你出的是 " + anStr + " 电脑出的是 " + randomStr + "  你赢了 " + (++wiSum) + " 次");
                    continue;
                }
                System.out.println("你出的是 " + anStr + " 电脑出的是 " + randomStr + "  电脑赢了 " + (++loseSum) + " 次");
            }
        System.out.println("⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐");
        System.out.println("平局" + (3 - wiSum - loseSum) + " 次" +
                " \n你总共赢" + (wiSum) + " 次" +
                " \n电脑总共赢" + (loseSum) + " 次");
    }

    public int gitNumber(Scanner scanner){
        while (true) {

            String next = scanner.next();
            boolean isNum = pattern.matcher(next).matches();
            if (!isNum || Integer.parseInt(next) >= 3) {
                System.out.println("输出有误请从新输入：0、1、2 (0表示 石头, 1表示 剪刀, 2、表示 布)");
                continue;
            }
            return Integer.parseInt(next);
        }
    }
}

/**
 * 第二题
 * 定义一个圆类Cale
 * 两个变量
 * 四个方法
 * 和
 * 差
 * 乘
 * 商
 */
class Cale {
    /**
     *
     */
    double numberOne;
    double numberTwo;

    public Cale(double numberOne, double numberTwo) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
    }


    /**
     * 计算周长
     *
     * @return 计算结果
     */
    public double addition() {
        return numberOne + numberTwo;
    }

    /**
     * 计算面积
     *
     * @return 计算结果
     */
    public double subtract() {
        return numberOne - numberTwo;
    }


    /**
     * 乘
     *
     * @return 计算结果
     */
    public double multiplication() {
        return numberOne * numberTwo;
    }

    /**
     * 商
     *
     * @return 计算结果
     */
    public Double division() {
        if (numberTwo == 0) {
            System.out.println("numberTwo, 不能为0");
            return null;
        }
        return numberOne / numberTwo;
    }

}

/**
 * 第一题
 * 定义一个圆类Circle，
 * 属性半径
 * 方法计算周长
 * 计算面积
 */
class Circle {
    /**
     * 半径
     */
    double redius;

    public Circle(double redius) {
        this.redius = redius;
    }

    /**
     * 计算周长
     *
     * @return 计算结果
     */
    public double perimeter() {
        return redius * redius * Math.PI;
    }

    /**
     * 计算面积
     *
     * @return 计算结果
     */
    public double area() {
        return 2 * redius * Math.PI;
    }

}
