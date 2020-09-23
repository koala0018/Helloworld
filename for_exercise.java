public class Homework02 {
    public static void main(String[] args) {
        /*1  输出图型
        *
        **
        ***
        ****
        *****

        for (int hang = 1;hang <= 7 ;hang ++){
            for(int star =0;star < hang;star++){
                System.out.print("*");
            }
            System.out.println();
        }
        2  输出图型
         *******
         ******
         *****
         ****
         ***
         **
         *

        for (int hang = 0;hang <= 7 ;hang ++){
            for(int star =7;star > hang;star--){
                System.out.print("*");
            }
            System.out.println();
        }
       3 把12题的两个图型合成一个。

            for (int hang = 1;hang <= 13 ;hang ++){
                if (hang <= 7){
                    for(int star =0;star < hang;star++){
                        System.out.print("*");
                    }
                    System.out.println();
                }else if(hang > 7){
                    for(int star1 =13;star1 > hang;star1--){
                        System.out.print("*");
                    }
                    System.out.println();
                }

        //4九九乘法表
        for (int hang = 1;hang <= 9 ;hang ++){
            for(int star =0;star < hang;star++){
                System.out.print(hang+"*"+star+" = "+(hang*star)+"   ");
            }
            System.out.println();
        }
    5 百钱买百鸡，有100元钱，要去买100只鸡，公鸡5元一只，母鸡3元一只，小鸡1元3只，问公，母，小鸡各买多少只。
    提示： a+b+c=100  只
       5a+3b+1/3c=100钱

        int gongji = 0;
        int muji = 0;
        int xiaoji = 0;
        for (int a = 0;a<=20;a++){
            for (int b =0;b<33;b++){
                for (int c = 0;c < 100;c++){
                    if ((a+b+c==100)&&( 5*a+3*b+c/3==100)){
                        System.out.println(a+"只公鸡   " + b+"只母鸡     " + c+"只小鸡    ");
                    }
                }
            }
        }


      6 星型图案
        *
       ***
      *****
     *******
    *********



       for (int hang = 1;hang <= 5 ;hang ++){
            for(int star =0;star<=5-hang;star++){
                System.out.print(" ");
            }
            for(int star =0;star <+ 2*hang - 1;star++){
                System.out.print("*");
            }
            System.out.println();
        }
        7  把上图形再倒过来，合成一个菱形图案

        for (int hang = 1; hang <= 9; hang++) {
            if (hang <= 5) {
                for (int star = 1; star <= 5 - hang; star++) {
                    System.out.print(" ");
                }
                for (int star = 1; star <= 2*hang - 1; star++) {
                    System.out.print("*");
                }
                System.out.println();
            } else if (hang > 5) {
                for (int star = 1; star <= hang - 5; star++) {
                    System.out.print(" ");
                }
                for (int star = 1; star <= (9-hang)*2 + 1; star++) {
                    System.out.print("*");
            }
                System.out.println();
            }
        }
/*
        8  打印出一个空菱形图案
        for (int hang = 1; hang <= 9; hang++) {
            if (hang <= 5) {
                for (int star = 1; star <= 5 - hang; star++) {
                    System.out.print(" ");
                }
                for (int star = 1; star <= 2 * hang - 1; star++) {
                    if ((star == 1) || (star == 2 * hang - 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");

                    }
                }
                System.out.println();
            } else if (hang > 5) {
                for (int star = 1; star <= hang - 5; star++) {
                    System.out.print(" ");
                }
                for (int star = 1; star <= (9 - hang) * 2 + 1; star++) {
                    if ((star == 1) || (star==(9 - hang) * 2 + 1)) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    System.out.println();
                }
            }




        9 100以内所有能被11整除的数（要求用continue 做）
            for(int number=0;number<=100;number++){
			if(number%11!=0){
				continue;
			}
			System.out.println(number);
		}
        10  求100以内第一个被11整除的数（break）
			for(int number=1;number<=100;number++){
			if(number%11==0){
				System.out.println(number);
				break;
			}

		}
        11 定义一个整数，判断它是否为素数
        12求300-400之间的素数

        for(int a=300;a<=400;a++){
            boolean flag = true;
            for(int n=2;n<=(int)(Math.sqrt(a));n++){
                if(a%n==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(a);
            }
        }
        13 找出一个数的所有因子数
        Scanner scan = new Scanner(System.in);
        System.out.println("输入一个数");
        int number = scan.nextInt();
        for(int n=1;n<=number;n++){
            if(number%n==0){
                System.out.println(n);
            }

        }

         */
        }
    }
