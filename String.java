import java.util.Scanner;

public class Day05 {
    public static void main(String[] args){
/*
1.charAt(int index):返回指定的下标处的字符。

2.codePointAt(int index)：返回指定的下标处的字符的Unicode编码

3.compareTo(String anotherString)：返回当前调用方法的字符串与参数字符串在字典中的位置的差，原理就是用调用方法的字符串的位置-参数字符串的位置等到的结果，通常用此方法比较两个字符串在字典中位置的前后，如果返回的结果是负数，则调用方法的字符串在参数字符串之前，如果返回的结果是0，则证明两个字符串内容一致，如果返回的是正数，则调用方法的字符串在参数字符串之后。

4.compareToIgnoreCase(String anotherString):作用与compareTo类似，唯一的却别是忽略大小写进行比较

5.concat(String str)：此方法会将调用方法的字符串与参数字符串进行拼接，形成一个新的字符串。

6.contains(CharSequence s):此方法会判断调用方法的字符串中是否包含参数字符串，如果包含则返回true否则返回false

7.endsWith(String suffix)：此方法是用来判断调用方法的字符串是否以参数字符串结尾。如果是则返回true否则返回false

8.startsWith(String prefix):此方法是用来判断调用方法的字符串是否以参数字符串开头。如果是则返回true否则返回false

9.equals(Object anObject)：此方法是用来判断调用方法的字符串与参数字符串的内容是否一致，如果是则返回true否则返回false

10.equalsIgnoreCase(String anotherString)：此方法是用来判断调用方法的字符串与参数字符串的内容是否一致（忽略大小写），如果是则返回true否则返回false

11.getBytes():将字符串转变为一个字节型数字，一般都是在进行数据传递的时候我们使用。

12.indexOf(int ch)：此方法使用获取参数字符在调用方法的字符串中第一次出现的位置。如果不存在则返回-1

13.indexOf(String str)：此方法使用获取参数字符串在调用方法的字符串中第一次出现的位置。如果不存在则返回-1

14.lastIndexOf(int ch)：此方法使用获取参数字符在调用方法的字符串中最后一次出现的位置。如果不存在则返回-1

15.lastIndexOf(String str)：此方法使用获取参数字符串在调用方法的字符串中最后一次出现的位置。如果不存在则返回-1

16.length():返回字符串的长度。

17.replace(char oldChar, char newChar)：使用newChar参数字符替换调用方法的字符串中的所有的oldChar字符，形成一个新的字符串.

18.replace(CharSequence target, CharSequence replacement):使用replacement参数字符串替换调用方法的字符串中的所有的target字符串，形成一个新的字符串.

19.split(String regex)：可以将调用此方法的字符串按照参数字符串的内容进行拆分，形成一个字符串类型的数组。使用.的时候需要注意，.在这里代表任意的字符，如果向单纯的代表.则写\\.

20.substring(int index):将调用方法的字符串进行截取，从指定的索引处开始截取到最后，得到一个新的字符串

21.substring(int beginIndex,int endIndex)将调用方法的字符串进行截取，从指定的索引处beginIndex开始截取到endIndex,但是不包含endIndex，得到一个新的字符串

22.toCharArray()：将字符串变成字符型数组

23.toLowerCase():将字符串中所有的字母变成小写的。

24.toUpperCase():将字符串中所有的字母变成大写的。

25.trim():去掉字符串两边的空格
26.valueOf(参数)：可以将任意类型的参数转变为字符串的形式。

        //1.判断输入的字符串是否是 .java 结束
        Scanner scan = new Scanner(System.in);
        System.out.println("输入字符");
        String str = scan.nextLine();
       // String str = new String();
        if (str.endsWith(".java")){
            System.out.println("是以.java结尾");
        }else {System.out.println("不是以.java结尾");}


        //2. 输出"北京欢迎你"中"欢迎"是第几位。
        String str = "北京欢迎你";
        System.out.println(str.indexOf("欢迎"));



        //3. 把输入的小写字母改成大写字母输出。
        Scanner scan = new Scanner(System.in);
        System.out.println("输入字符");
        String str = scan.nextLine();
        System.out.println(str.toUpperCase());


        //4. "那车水马龙的人世间，那样地来 那样地去，太匆忙"最后一次出现"那"的位置。
        String str = "那车水马龙的人世间，那样地来 那样地去，太匆忙";
        System.out.println(str.lastIndexOf("那"));


        //5. "美丽呀 倒影在心房 美丽呀 泪珠挂腮上  美丽呀 花儿吐芬芳  美丽呀 你让我慌张"把这个字符串所有"美丽"替换成"倒霉"。
        String str = "美丽呀 倒影在心房 美丽呀 泪珠挂腮上  美丽呀 花儿吐芬芳  美丽呀 你让我慌张";
        System.out.println(str.replace("美丽","倒霉"));




        //6. "白 毕 卞 蔡"把这个字符串以空格为分隔，分到字符串数组中，


        //再输出。然后再以"_"为分隔符，连接成一个字符中
        String str = "白 毕 卞 蔡";
        String s1 = str.replace(' ','-');
        String[] strs = str.split(" ");
        for(String s:strs){
            System.out.println(s);
        }
        System.out.println(s1);

 */



        //*****7.求出字符串中有多少种字符，以及每个字符的个数，意思就是只要不是同一个就是不同种
        /*
        比如输入 “Helloworld”

		Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您想要的内容");
        String str = scanner.nextLine();//str=wrd
        int num=0;//num=4
        while(!"".equals(str)){//判断字符串不为空，即用空字符串引用.equals方法和str比较，不相等则循环
            String temp = str;//
            System.out.print("字符："+str.substring(0, 1));//
            str=str.replace(str.substring(0, 1), "");
            System.out.println(" 个数："+(temp.length()-str.length()));//str每次循环都存着截取以后被替换为的数组，长度在减少，temp一直没被截取，temp长-str就是替换的次数
            num++;
        }
        System.out.println("字符种类数："+num);

        //8.去掉字符串右边的空格
        Scanner scan = new Scanner(System.in);
        System.out.println("输入字符");
        String str = scan.nextLine();
        int n  =0;
        char [] arr = str.toCharArray();
        for (int i =arr.length-1;i>0;i--){
            if (str.charAt(i)==' '){
                n++;
            }else {
                break;
            }
        }
        System.out.println(str.substring(0,arr.length-n));




        //9.将s所指字符串的正序和反序进行连接,例如 "ok"->"okko"（手动编写方法与API方法两种方式）

        Scanner scan = new Scanner(System.in);
        System.out.println("输入字符");
        String s1 = scan.nextLine();
        char []s2 = s1.toCharArray();
        String s = "";
        for (int i = s2.length-1;i>=0;i--){//此循环只是把他逆序拼接到一个String对象:s里
            s = s +s2[i];
        }
        System.out.println(s1+s);






            //10.字符串右移n位,例如   "hello world" 右移两位 后ldhello wor
        Scanner scan = new Scanner(System.in);
        System.out.println("输入字符");
        String s1 = scan.nextLine();
        System.out.println("输入右移几位n");
        int wei = scan.nextInt();
        //确定几位要右移以后，写两个字符串对象，分别存截下来的两个字符数据，最后拼接
        String s3 = s1.substring(0,s1.length()-wei);
        String s4 = s1.substring(s1.length()-wei);
        System.out.println(s4+s3);





        //11.求5个字符串中最长的那个，把最长的字符串打印出来
        Scanner scan = new Scanner(System.in);
        String[] s2 = new String[5]; //String 数组已经是每个元素都是字符串了，所以5次输入的时候每次都是直接输入字符串，不用再写个字符串存
        for (int i =0;i<s2.length;i++){
            System.out.println("输入字符串");
            s2[i] = scan.nextLine();//将字符串输入
            }
        int max = s2[0].length();
        String s =s2[0];
        for (int i =0;i<s2.length;i++){
            if (max < s2[i].length()){
                max = s2[i].length();//核心是比较出长度最大的，然后把代表的字符串赋值给一个中间字符串存储，最后输出
                s = s2[i];
            }
        }
        System.out.println(s);

         */


/*

        //12.若可以从一个源字符串中， 找到一个相符的字符串， 则返回第一个字符的索引位置，否则返回-1。
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = scan.nextLine();
        System.out.println("请输入想要寻找的字符串：");
        String s = scan.nextLine();
        int index = -1;
        for (int i = 0; i < str.length() - s.length(); i++) {
            if(str.contains(s)){
                index = str.indexOf(s);
                break;
            }
        }
        System.out.println(index);
        //13.判断一个字符串是否是回文
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = scan.nextLine();
        StringBuffer sb = new StringBuffer(str);
        if (str.equals(sb.reverse().toString())){
            System.out.println("是回文");
        }else {
            System.out.println("不是回文");
        }
    }
}
