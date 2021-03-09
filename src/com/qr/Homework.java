package com.qr;


/**
 * @author zjt
 * @date 2021/3/8
 */
class Homework {
    public static void main(String[] args) {
        int in = 0;
        int[] number = {23, 48, 50, 67, 100, 120, 130, 140};
        int[] numbers = {10, 12, 45, 90};
        int[] newNumbers = new int[numbers.length + number.length];
        long startTime = System.nanoTime();
        //第一种方式
        AscendingSort.ascending(0, 0, in, number, numbers, newNumbers);
        //第二种方式
        AscendingSort.ascending1(in, number, numbers, newNumbers);
        //第二种方式
        AscendingSort.ascending2(in, number, numbers, newNumbers);
        long endTime = System.nanoTime();
        System.out.print("升序数组:  ");
        for (int newNumber : newNumbers) {
            System.out.print(newNumber + "\t");
        }
        System.out.println("\n程序运行时间： " + (endTime - startTime) + "ns");
        System.out.println("\n===========================================================================");

        RandomAscendingSort.sort();
    }


    /**
     * 练习题二
     * 随机生成10个整数（1~100）保存到数组，
     * 并且倒叙打印，
     * 并且倒叙排序，
     * 打印及求平均值，
     * 最大值，
     * 最大值下标，
     * 查找里面是否有8
     */

    static class RandomAscendingSort {

        public static void sort() {
            int cont = 0;
            int max = 0;
            int maxIndex = 0;
            boolean isNumber = false;
            int[] numbers = new int[10];
            System.out.print("随机生成数: ");
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = (int) (Math.random() * 100) + 1;
                //平均值
                cont += numbers[i];
                //最大值
                if (numbers[maxIndex] < numbers[i]) {
                    max = numbers[i];
                    maxIndex = i;
                }
                if (numbers[i] == 8) {
                    isNumber = true;
                }
                System.out.print(numbers[i] + "\t");
            }
            System.out.print("\n倒叙打印:  ");
            for (int i= numbers.length -1; i >= 0;i--) {
                System.out.print(numbers[i]+ "\t");
            }
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers.length - 1 - i; j++) {
                    if (numbers[j] < numbers[j + 1]) {
                        int maxNumber = numbers[j + 1];
                        numbers[j + 1] = numbers[j];
                        numbers[j] = maxNumber;
                    }
                }
            }
            System.out.println("\n-----------------------------------------------------");
            System.out.print("倒叙排序: ");
            for (int number : numbers) {
                System.out.print(number + "\t");
            }
            System.out.println("\n打印及求平均值： " + cont);
            System.out.println("最大值： " + max);
            System.out.println("最大值下标： " + maxIndex);
            System.out.println("查找里面是否有8： " + isNumber);
        }
    }

    /**
     * 练习题一
     * 已知有个升序数组，要插入一个元素，该数组顺序依然是升序
     * 比如：[10, 12, 45, 90]，添加 {23, 48,50,67} 后 [10, 12, 23, 45, 48, 50, 67, 90]
     */
    static class AscendingSort {
        /**
         * 第一种方法遍历递归形式完成
         *
         * @param i          第一个数组的指针
         * @param j          第二个数组的指针
         * @param in         要添加数组的指针
         * @param number     要添加的数组
         * @param numbers    第一个数组
         * @param newNumbers 第二个数组
         */
        public static void ascending(int i, int j, int in, int[] number, int[] numbers, int[] newNumbers) {
            //1、遍历第一个数组
            for (; i < numbers.length; i++) {
                //2、校验要添加的数组指针是否小于要添加数组的长度，并且第一个元素大于要添加的数组元素
                if (in < number.length && numbers[i] > number[in]) {
                    //3、第二个数组元素等于要添加的元素
                    newNumbers[j] = number[in];
                    //4、重点  迭代第一个数组指针不变，第二个数组指针加一，要添加的数组指针加一
                    ascending(i, j + 1, in + 1, number, numbers, newNumbers);
                    break;
                }
                //3、第二个数组元素等于第一个数组元素，第二个指针加一
                newNumbers[j++] = numbers[i];
                //5、校验第一个数组遍历完成，添加的数据大于第一个数组的元素，添加到最后位置
                if (numbers.length - 1 - i == 0 && in < number.length) {
                    for (; j < newNumbers.length; j++) {
                        newNumbers[j] = number[in++];
                    }
                }
            }
        }

        /**
         * 第二种方法遍历完成
         *
         * @param in         要添加数组的指针
         * @param number     要添加的数组
         * @param numbers    第一个数组
         * @param newNumbers 第二个数组
         */
        public static void ascending1(int in, int[] number, int[] numbers, int[] newNumbers) {
            //1、遍历第二个数组
            for (int i = 0, j = 0; i < newNumbers.length; i++) {
                //2、校验要添加的数组指针是否小于要添加数组的长度，并且第一个元素大于要添加的数组元素
                if (in < number.length && numbers[j] > number[in]) {
                    //3、第二个数组元素等于要添加的元素
                    newNumbers[i] = number[in++];
                    continue;
                }
                //3、第二个数组元素等于第一个数组元素，第一个数组指针加一
                newNumbers[i] = numbers[j++];
                //4、校验第二个数组遍历完成，添加的数据大于第一个数组的元素，将大于的数据添加到最后位置
                if (numbers.length - j == 0 && in < number.length) {
                    for (i += 1; i < newNumbers.length; i++) {
                        newNumbers[i] = number[in++];
                    }
                    break;
                }
            }
        }

        /**
         * 第三种方法遍历完成
         *
         * @param in         要添加数组的指针
         * @param number     要添加的数组
         * @param numbers    第一个数组
         * @param newNumbers 第二个数组
         */
        public static void ascending2(int in, int[] number, int[] numbers, int[] newNumbers) {
            //1、遍历第二个数组
            for (int i = 0, j = 0; i < numbers.length; ) {
                //2、校验要添加的数组指针是否小于要添加数组的长度，并且第一个元素大于要添加的数组元素
                if (in < number.length && numbers[i] > number[in]) {
                    //3、第二个数组元素等于要添加的元素
                    newNumbers[j++] = number[in++];
                    continue;
                }
                //3、第二个数组元素等于第一个数组元素，第一个数组指针加一
                newNumbers[j++] = numbers[i++];
                //4、校验第二个数组遍历完成，添加的数据大于第一个数组的元素，将大于的数据添加到最后位置
                if (numbers.length - i == 0 && in < number.length) {
                    for (; j < newNumbers.length; j++) {
                        newNumbers[j] = number[in++];
                    }
                    break;
                }
            }
        }
    }
}
