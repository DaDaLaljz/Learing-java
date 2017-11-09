## java 控制语句
### 1.判断闰年
输出从公元1990年到2007年所有闰年的年号，每输出两个年号换一行。判断年号是
否为闰年的条件是：
（1）若年号能被4整除，而不能被100整除，则是闰年；
（2）若年号能被400整除也是闰年。
``` 
   {
        int mark=0;
		int a = 1990;
		for(int i=0;a<=2007;i++){
			if(a%4==0 && a%100!=0){
				System.out.print(a);
				System.out.print(" ");
				mark++;
				if(mark%2==0){
				System.out.println("");}
				}else if(a%400==0){
					System.out.print(a);
					System.out.print(" ");
					mark++;
					if(mark%2==0){
						System.out.println("");
					}
				}
			  a++;
     }
 ```
此题重点就是：需要设一个标志位mark，对mark除2取余，判断输出两个年号换行。mark初值为0，输出一次年号，则mark+1。每次输出都对mark进行判断一次，如果mark整除2，则表示输出两次，所以换行，若取余为1，表示输出的单次，不用换行。
### 2.实现方法ToGradeScore，将百分制成绩转化为等级成绩。要求对一组数据，实现批量转化。
等级与百分制对照
（1）优：[90,100]
（2）良：[89,80]
（3）中：[79,70]
（4）及格：[69,60]
（5）不及格：[0,59]
```
  {
		Scanner in=new Scanner(System.in);
		System.out.println("输入五个成绩：");
		double a[];
		a=new double[5];
		for(int i=0;i<5;i++){
			a[i]=in.nextDouble();
		}
		for(int i=0;i<a.length;i++){
			if(a[i]>=90&&a[i]<100){
				System.out.println("优");
			}
			if(a[i]>=80&&a[i]<90){
				System.out.println("良");
			}
			if(a[i]>=70&&a[i]<80){
				System.out.println("中");
			}
			if(a[i]>=60&&a[i]<70){
				System.out.println("及格");
			}
			if(a[i]<60){
				System.out.println("不及格");
			}
		}
	}
```
此题重点就是：if判断语句。分多个if对成绩进行等级判断。
### 3.打印图案
利用for循环编写一个程序，将如下图案分别打印输出。
```     
     *
    ***
   *****
  *******               
   *****
    ***
     *
```
```
    {
		int max=7;
		for(int i=0;i<max;i++){
			if(i<4){
				int n=2*i+1;
				for(int j=0;j<3-i;j++){
					System.out.print(" ");
				}
				for(int k=0;k<n;k++){
					System.out.print("*");
				}
				System.out.println();
			}
			if(i>=4){
				int n=max-2*(i-3);
				for(int j=0;j<i-3;j++){
					System.out.print(" ");
				}
				for(int k=0;k<n;k++){
					System.out.print("*");
				}
				System.out.println();
			}		
		}
	}
```
此题重点就是先打印前面三行，再来打印后面四行。
### 4.水仙花数
编写程序找出所有的水仙花数；水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
```
{
		for(int i=1;i<10;i++)
			for(int j=0;j<10;j++)
				for(int k=0;k<10;k++){
					if((i*i*i+k*k*k+j*j*j)==(i*100+j*10+k)){
						System.out.println((i*100+j*10+k));
					}
				}
}
```
此题重点就是找到规律：i\*i\*i+j\*j\*j+k\*k\*k=i\*100+j\*10+k。
### 5.运行结果：
![运行截图][1]
  
### 6.总结
这次实验是比较基础的java控制语句，都能独立完成。就是在打印图形那题，花费了一些时间，但是基本思路都能想出来，基本解决。（2017.10.7）
  
  


  [1]: ./images/%5BA%60UQ7$FX$%7D8PT%7BTZHJ48EI.png "[A`UQ7$FX$}8PT{TZHJ48EI.png"