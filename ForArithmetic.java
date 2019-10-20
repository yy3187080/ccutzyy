package ccut.zyy.software.arithmetic;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;
class ForArithmetic {
		/*
		 * 张洋洋
		 * 四则运算软件工程作业
		 */
	int count, isMulandchu, complex, res, number1, number2, fh, rest;//定义全局变量
	BigDecimal scope;
	char opera;

	void show() throws FileNotFoundException {//show方法输出提示信息和从键盘获取相应值
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {//判断是否存在不符合数据类型的值
			System.out.println("请输入生成题目的数量");
			count = scanner.nextInt();
			System.out.println("请输入操作数的范围(如1或100等)");
			scope = scanner.nextBigDecimal();
		} catch (Exception e) {//当输入值不符合数据类型时执行以下操作
			System.out.println("----------------------程序重新启动---------------------------");
			show();
		}
		System.out.println("是否包含乘除法？ 1是  0否");
		isMulandchu = scanner.nextInt();
		while (isMulandchu != 0 && isMulandchu != 1) {//判断输入的的值是否为0或1否则执行以下操作
			System.out.println("输入有误，重新输入：");
			isMulandchu = scanner.nextInt();
		}
		System.out.println("是否有负数吗？1是 0否 ");
		complex = scanner.nextInt();
		while (complex != 0 && complex != 1) {//判断输入的的值是否为0或1否则执行以下操作
			System.out.println("输入有误，重新输入：");
			complex = scanner.nextInt();
		}
		System.out.println("是否需要输出结果？1是  0否 ");
		res = scanner.nextInt();
		randomOperation();//调用randomOperation方法
	}

	void randomNumber() {//生成两个随机数number1，number2
		int num = (int) (Math.random() * scope.intValue());//生成随机数赋值给num
		if (complex == 1) {//生成负数随机数1
			int c = (int) (Math.random() * 2);
			switch (c) {
			case 0:
				number1 = num * -1;
				break;

			case 1:
				number1 = num;
				break;
			}
		} else {//生成正数的随机数
			number1 = num;
		}
		int nu = (int) (Math.random() * scope.intValue());
		if (complex == 1) {//生成负数随机数2
			int c = (int) (Math.random() * 2);
			switch (c) {
			case 0:
				number2 = nu * -1;
				break;

			case 1:
				number2 = nu;
				break;
			}
		} else {//生成正数随机数2
			number2 = nu;
		}
	}

	char operator() {//生成+，-，*，/运算符
		if (isMulandchu == 0) {//生成+，-
			fh = (int) (Math.random() * 2);
			switch (fh) {
			case 0:
				opera = '+';

				break;

			case 1:
				opera = '-';
				break;
			}
		}
		if (isMulandchu == 1) {//生成+，-，*，/
			fh = (int) (Math.random() * 4);
			switch (fh) {
			case 0:
				opera = '+';

				break;

			case 1:
				opera = '-';
				break;
			case 2:
				opera = '*';
				break;
			case 3:
				opera = '/';
				break;
			}
		}
		return opera;
	}

	int result() {//此方法生成运算结果
		if (isMulandchu == 0){//加减法的结果
			switch (fh) {
			case 0:
				rest = number1 + number2;

				break;

			case 1:
				rest = number1 - number2;
				break;
			}
			}
		if (isMulandchu == 1){//四则运算的结果
			switch (fh) {
			case 0:
				rest = number1 + number2;

				break;

			case 1:
				rest = number1 - number2;
				break;
			case 2:
				rest = number1 * number2;

				break;

			case 3:
				rest = number1 / number2;
				break;

			}
			}
		return rest;
	}

	void randomOperation() throws FileNotFoundException {//控制生成题目并打印和输出算式
		PrintStream ps = new PrintStream("d:/result.txt"); // 在d盘生成txt文档
		System.setOut(ps);//把以下输出内容打印到"d:/result.txt"
		for (int i = 0; i < count; i++) {//利用for循环控制生成题目的数量
			if (res == 1) {//判断是否需要输出结果，res=1需要输出结果
				randomNumber();//调用生成随机数方法
				operator();//调用生成运算符方法
				result();//调用计算结果方法
				System.out.print(number1);//输出随机数1
				System.out.print(" " + opera + " ");//输出运算符
				if (number2 < 0) {//number2为负数时输出随机数2和等式结果
					System.out.println("(" + number2 + ")" + " " + "=" + " "
							+ rest);
				} else if (number2 >= 0) {//number2为正数时输出随机数2和等式结果
					System.out.println(number2 + " " + "=" + " " + rest);
				}
			} else if (res == 0) {//res=0不需要输出结果执行以下操作
				randomNumber();//调用生成随机数方法
				operator();//调用生成运算符方法
				System.out.print(number1);//输出随机数1
				System.out.print(" " + opera + " ");//输出运算符
				if (number2 < 0) {//number2为负数时输出随机数2和等号
					System.out.println("(" + number2 + ")" + " " + "=" + " ");
				} else if (number2 >= 0) {//number2为正数时输出随机数2和等号
					System.out.println(number2 + " " + "=" + " ");
				}
			}
		}
	}

}