package Homework;
import java.util.Scanner;
public class Day04 {
    public static void main(String[] args){
        //数组一
        //1 定义一个5个元素组成的一维数组，对其进行赋值 ，再把该值输出来。

/*
        int[] array = {1,2,3,4,5};
        for (int a : array){
            System.out.println(array[a-1]);
        }

        //2 定义一个5个元素组成的一维数组，对其赋值，再把该数组反向输出。
        int[] array = new int[5];
        System.out.println("输入数字");
        Scanner scan = new  Scanner(System.in);

        for (int i = 0;i < array.length;i++){
            int num = scan.nextInt();
            array[i] = num;
        }
        for (int i = array.length-1;i >=0 ;i--){
            System.out.println(array[i]);
        }


        //3 定义一个10个元素组成的一维数组，求该数组中的最大值和最小值。及最大值和最小值的平均值 。
        int[] array = new int[10];
        System.out.println("输入数字");
        Scanner scan = new  Scanner(System.in);
        for (int i = 0;i < array.length;i++){
            int num = scan.nextInt();
            array[i] = num;
        }
        int max = array[1];
        int min = array[1];
        for (int i = 0;i < array.length;i++){
            max = Math.max(max,array[i]);
            min = Math.min(min,array[i]);
        }
        double avg = (max + min)/2;
        System.out.println("最大值："+max+" 最小值是"+min+" 平均数："+avg);


        //4定义一个10个元素组成的一维数组，求该数组中的最大值，以及最大值在该数组中的位置。
        int[] array = new int[10];
        System.out.println("输入数字");
        Scanner scan = new  Scanner(System.in);
        int index = 0;
        int max = array[1];
        for (int i = 0;i < array.length;i++){
            int num = scan.nextInt();
            array[i] = num;
            max = Math.max(max,array[i]);
        }
        for(int i = 0;i < array.length;i++){
            if (array[i]==max){
                index = i;
                break;
            }
        }
        System.out.println("最大值为："+max+"    位置在下标："+index);

         */

        //5在一个由5个元素组成的一维数组中 查找一个已经定义好的数字，如果该有数组中有此元素，由提示“此数组中有***数字”，如果此数组中没有则提示“该数字不在此数组中”
        /*
        int[] array = new int[5];
        System.out.println("输入数字");
        Scanner scan = new  Scanner(System.in);
        for (int i = 0;i < array.length;i++){
            int num = scan.nextInt();
            array[i] = num;
        }
        System.out.println("输入要查找的数字");
        int num = scan.nextInt();
        for (int i = 0;i < array.length;i++){
           if ( array[i] == num){
               System.out.println("此数组中有"+num);
               break;
           }else if((i == array.length-1)&&(array[i] != num)){
               System.out.println("此数组中没有"+num);
            }
        }

        //6求一个由10个元素组成的一维数组中，所有元素的平均值
        /*
        int[] array = new int[10];
        System.out.println("输入数字");
        Scanner scan = new  Scanner(System.in);
        double avg =0;
        int sum =0;
        for (int i = 0;i < array.length;i++){
            int num = scan.nextInt();
            sum+=num;
            if (i==9){
                avg = sum / (i+1);//或者直接写10
                break;
            }
        }
        System.out.println("平均值为： "+avg);

         */
    }
}
