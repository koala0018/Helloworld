package Homework;

import java.util.Scanner;
import java.util.Arrays;

public class Day04_2 {
    public static void main(String[] args) {

        // 1.静态初始化一维数组{10，20，11，35，6}，进行冒泡排序
        /*
        int[] array = {10,20,11,35,6};
        int index = 0;
        for (int i = 0;i < array.length-1;i++){
            for (index = array.length-1;index>i;index--){
                if (array[index]<array[index-1]){
                    int tem =array[index];
                    array[index]=array[index-1];
                    array[index-1]=tem;
                }

            }
            System.out.println(array[index]);
        }




       // 2.静态初始化二维数组 {{1}，{2，3}，{4，5，6}}，输出每个元素的值
        int[][] array = {{1},{2,3},{4,5,6}};
        for (int []a:array){
            for (int as:a){
                System.out.print(as+" ");

            }
            System.out.println("");
        }

         */


        // 3.静态初始化二维数组 {{11，15，32，21}，{2，3}，{4，5，6}}，输出每个元素的值，并从小到大排序。     *****
       /* int[][] array = {{11,15,32,21},{2,3},{4,5,6}};
        //定义新一维数组，存所有数据
        int length = 0;
        //先确定长度,即每个二维数组中所以一维数组的长度和
        for (int i = 0;i < array.length;i++){
            for (int j =0;j < array[i].length;j++){
                length += array[i].length;
            }
        }
        int [] array1 = new int[length];
        int index = 0;
        //存数据
        for (int i = 0 ;i < array.length;i++){
            for (int j = 0;j < array[i].length;j++){
                array1[index] = array[i][j];
                index++;
                //System.out.println(array1[index]);
            }
        }
       //开始排序
        for (int i = 0;i < array1.length-1;i++){
            for (index = array1.length-1;index>i;index--){
                if (array1[index]<array1[index-1]){
                    int tem =array1[index];
                    array1[index]=array1[index-1];
                    array1[index-1]=tem;
                }

            }
        }
        for(int a:array1){
            System.out.println(a);
        }

        */


         /*
       // 4.打印一个杨辉三角形

        1
        1   1
        1   2   1
        1   3   3   1
        1	 4	 6 	 4   1
        1	 5   10  10  5  1


        int [][] arrays = new int[6][];
        arrays [0] = new int []{1};
        arrays [1] = new int []{1,1};
        arrays [2] = new int []{1,2,1};
        arrays [3] = new int []{1,3,3,1};
        arrays [4] = new int []{1,4,6,4,1};
        arrays [5] = new int []{1,5,10,1,5,1};
        for (int[] a :arrays){
            for (int as:a){
                System.out.print(as+" ");
            }
            System.out.println();
        }
 */
        //升级版杨辉三角
        /*
        Scanner scan = new Scanner(System.in);
        System.out.println("输入杨辉三角的行数:");
        int length = scan.nextInt();
        //定义一个二维数组，用来保存杨辉三角中的数据
        int[][] arrays = new int[length][];
        //编写循环对二维数组中的每一个一维数组进行初始化（创建一阶数组，每次创建的数量多一）
        for(int i=0;i<arrays.length;i++){
            arrays[i] = new int[i+1];
        }
        //编写循环对二维数组中的数据进行赋值完成杨辉三角
        for(int i=0;i<arrays.length;i++){
            for(int j=0;j<arrays[i].length;j++){
                //判断是否是每一个一维数组的第0个下标和最后一个下标的元素
                if(j==0||j==arrays[i].length-1){
                    arrays[i][j] = 1;
                }else{
                    arrays[i][j] = arrays[i-1][j]+arrays[i-1][j-1];
                }
            }
        }

        //编写循环输出杨辉三角
        for(int[] as:arrays){
            for(int a:as){
                System.out.print(a+"	");
            }
            System.out.println();
        }
    }
}

         */

        /*1、	将一个给定的整型数组转置输出，
        例如：	源数组，1 2 3 4 5 6
        转置之后的数组，6 5 4 3 2 1
        要求创建一个新的数组，将旧数组的倒叙存入新数组中输出
        int[] array = {1,2,3,4,5,6};
        int[] array1 = new int [6];
        int index = 0;
        for (int i = array.length-1;i >= 0;i--){
            array1[index] = array [i];
            index++;
        }
        for (int a:array1){
            System.out.println(a);
        }

         */
        /*2、	现在有如下的一个数组：
        int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ;
        要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：
        int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5} ;
        思路：生活中的问题解决 = 程序中的解决；
        1、	确定出不为0的个数，这样可以开辟新数组；
        2、	从旧的数组之中，取出内容，并将其赋给新开辟的数组；

        int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5} ;
        int count = 0;
        for (int i = 0; i < oldArr.length; i++) {//计算几个0
            if (oldArr[i] != 0) {
                count++;
            }
        }

        int[] newarr = new int[count];// 数组的长度
        count = 0;

        for (int i = 0; i < oldArr.length; i++) {// 将不为零的放到新数组中去
            if (oldArr[i] != 0) {
                newarr[count] = oldArr[i];//易错，别将count写成i
                count++;
            }
        }
        for (int a : newarr) {
            System.out.println(a);

        }

         */


        /*3、	现在给出两个数组：
	· 数组A：{1，7，9，11，13，15，17，19}
	· 数组b：{2，4，6，8，10}
        两个数组合并为数组c，按升序排列。
        主要的目的是熟悉这两个操作的方法，数组扩大，必须要将原始数组的内容拷贝进去。



        int[] A = new int[]{1,7,9,11,13,15,17,19};
        int[] B = new int[]{2,4,6,8,10};
        int count=0;
        for (int i = 0;i < A.length+B.length;i++){
            count ++;
        }

        int[] C = new int[count];
        count = 0;
        for (int i = 0;i < A.length;i++){
            C[count] = A[i];
            count++;
        }
        for (int i = 0;i < B.length;i++){
            C[count] = B[i];
            count++;
        }
        for (int as : C) {
            System.out.println(as);

        }

         */
        //4.创建一个数组的对象，由用户输入数字，要求用户输入的数字必须是正整数或者是0，如果输入的数字满足要求则一直输入并保存到数组中，如果不满足要求，则打印输入已经保存的数据，程序停止。
/*         1.copy of办法：

                int[] arr = new int[5];
                Scanner scan = new Scanner(System.in);
                int temp = 0;
                int index = 0;
                System.out.println("请输入数字,按999结束输入:");
                while (true) {
                    temp = scan.nextInt();
                    if (temp <= 0)
                        break;
                    if (index >= arr.length)
                        arr = kuoRong(arr);
                        arr[index] = temp;
                        index++;
                }
                for (int as : arr) {
                    System.out.println(as);
                }
        public static int[] kuoRong(int[] arrOld) {
            int[] arrNew = null;
            arrNew = Arrays.copyOf(arrOld, arrOld.length + 5);
            return arrNew;
        }


        //4-2:
        int []arr = new int[0];//如果第一个就为负数，也不能输出默认值，所以一开始给0
        Scanner scan = new Scanner(System.in);
        System.out.println("输入");
        int num = scan.nextInt();
        int index = 0;
        while(num >= 0 ){
            //判断下标有没有超过数组长度
            if(index> arr.length-1){
                //越界就创一个新数组，旧的把值赋给他
                int []newarr = new int [arr.length+1];
                for (int i =1;i<arr.length;i++){
                    newarr[i]=arr[i];
                }
                newarr[arr.length]=num;
                //把旧数组内存也指向新的数组
                arr = newarr;
                index ++;
            }else {
                arr[index] = num;
                index++;
            }
            num = scan.nextInt();
        }
        if(arr.length>0){
            System.out.println("输入的结果是:");
            for(int a:arr){
                System.out.println(a);
            }
        }else{
            System.out.println("输入的结果是:无");
        }


 */
        /*5.输入一个正整数n（1<=n<=6）,形成一个n阶矩阵，计算该矩阵除副对角线、最后一列、最后一行以外的数据的和（副对角线是指矩阵从右上角到左下角的斜线）
        1 1 1 1 2
        1 1 1 2 1
        1 1 2 1 1
        1 2 1 1 1
        21 1 1 1





        Scanner scan = new Scanner(System.in);
        System.out.println("输入n");
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n;
            }
        }
        for (int[] a : arr) {
            for (int as : a) {
                System.out.print(a);
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i - 1 + j == n || i == n - 1 || j == n - 1) {
                    continue;
                } else {
                    sum += n;
                }

            }
        }
        System.out.println(sum);


         */


        /*6.输入一个正整数n，输入n个数，生成一个n*n的矩阵并输出出来，矩阵第一行是输入的n个数，以后每一行都是上一行循环左移的一个元素
        举例：
        输入的n=5;
        输入的数字是：2 5 8 4 9
        得到的矩阵是:
        2 5 8 4 9
        5 8 4 9 2
        8 4 9 2 5
        4 9 2 5 8
        9 2 5 8 4

*/
        System.out.println("请输入一个正整数n：");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] array = new int[n][n];
        int[] array1 = new int[n];//一个一阶数组存所有输入的数据

        for(int i = 0;i<array.length;i++){
                System.out.println("请输入数组数据：");
                int num = scan.nextInt();
                array1[i]=num;
        }
        //再用一个二阶数组来把一阶数组的数按情况加入二阶数组
        int index = 0;
        for(int i = 0;i<array.length;i++){
            index = i;
            for(int j = 0;j<array[i].length;j++){
                if (index >= array[i].length){
                    index = 0;
                }
                array[i][j] = array1[index];
                index ++;
            }
        }

        for(int[] as:array){
            for(int a:as){
                System.out.print(a + "  ");
            }
            System.out.println();
        }



    }


}
