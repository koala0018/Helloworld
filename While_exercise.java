package Homework;

import java.util.Scanner;

public class Day03 {
    public static void main(String[] args) {

/*
//2用户输入一个正整数如：1205  统计它的各位数字中零的个数，并求各位数字中的最大者。
        int a = 1;
        double max = 0.0;
        double num1;
        int number2;
        int record=0;
        Scanner scan = new Scanner(System.in);
        System.out.println("输入一个正整数");
        int number = scan.nextInt();
        while(a<=4){
            num1=number/(Math.pow(10,(a-1)))%10;
            number2 = (int)num1;
            if (number2 == 0){
                record++;
            }
            max = Math.max(max,num1);
            a++;
        }
        System.out.println(record+"个 0");
        System.out.println("最大为"+(int)max);

//3 有1020个西瓜，第一天卖掉总数的一半后又多卖出两个，以后每天卖剩下的一半多两个，问几天以后能卖完
     int num = 1020;
     int flag = 1;
     while(num>0){
         num = num/2 -2;
         flag ++;
     }
     System.out.println(flag);

 //4猴子吃桃问题： 猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，又多吃了一个，第二天早上又将剩下的桃子吃了一半，又多吃一个，以后每天都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子。求第一天共摘了多少个？
    //X=(1+1)*2
    //X=(x+1)*2;
    int x = 1;
    int sum = 0;
    while(x<=10){
        x=(x+1)*2;
        sum = sum + x;
    }
    System.out.println(sum);*/
/*5用while做 求10到20的累加和
    int a = 10;
    int sum;
    while(a<=20){
        sum = sum+a;
        a++;
    }
    System.out.println(sum);

//6用while做 求1000元钱可以买到38元的钢笔多少只？
    int pan = 0;
    int  one= 38;
    int price = 38;
    while(price<=1000){
        pan=price/one;
        price = price + 38;
}
        System.out.println(pan);
//7用while做 鸡兔同笼。鸡兔一共有50只，脚一共有160只，问鸡和兔各多少只?要求鸡兔至少一样一
        int chicken=1 ;
        while(chicken<50){
            int rabbit=1;
            while (rabbit < 50){
                if((rabbit*4 + chicken*2 ==160)&&(rabbit+chicken==50)) {
                    System.out.println("兔子："+rabbit+"鸡："+chicken);
                }
                rabbit++;
            }
            chicken++;
        }

//8计算1+4+7+...+301，写出算法的程序.
    int sum = 0;
    for (int i = 1;i <= 301;i = i+3){
        sum+=i;

    }
    System.out.println(sum);


//9、计算2/1+3/2+4/3+…+(n+1)/n，写出算法的程序.
    Scanner scan = new Scanner(System.in);
    System.out.println("输入一个正整数");
    double n = scan.nextInt();
    double sum = 0;
        for(double i = 1;i<=n;i++){
             sum += (i + 1) / i;
        }
    System.out.println(sum);


//10、给出50个数，1，2，4，7，11，„，其规律是：第1个数是1，第2个数比第1个数大1，第3个数比第2个数大2，第4个数比第3个数大3，„，以此类推. 要求计算这50个数的和. 先将下面给出的程序框图，再根据程序框图写出程序.
//n n+1 (n+1)+n+1
    Scanner scan = new Scanner(System.in);
    System.out.println("输入一个正整数");
    int n = scan.nextInt();
    int num = 1;
    int sum = 0;
    for (int i =1;i <= n;i++){
        sum = sum +num;
        num = num + i;
    }

 */

//11  用户输入一个数，判断是否为回文数。回文数即 一个五位数，它的第一位与最后一位相等 ，第二位与倒数第二位相等。12321
        int wei = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("输入一个正整数");
        int number = scan.nextInt();
        boolean flag = true;
        int number1 = number;
        while (number1 / 10 > 0) {
            wei++;
            number1 /= 10;
        }
        System.out.println("是" + wei + "位数");
        for (int i = 0; i < wei / 2; i++) {//循环取数，把数字分一半，分别取出前半段和后半段，每次循环比较一次是否一样即可
            int a = number / (int) Math.pow(10, wei - i - 1) % 10;//正常是数字除以10的数字位数减一次方，再对10取余，这里只要前半段，第一次i为0，所以第一个数就是10的（wei - 0 -1—）次方，再取余
            int b = number / (int) Math.pow(10, i) % 10;//从右往左取到中间，假设7位数，wei/2为3，i最大取到2，10的（i）次方再取余
            if (a != b) { 
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(number + " 是回文数");
        } else {
            System.out.println(number + " 不是回文数");
        }

    }

}
