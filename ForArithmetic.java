package ccut.zyy.software.arithmetic;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;
class ForArithmetic {
		/*
		 * ������
		 * �����������������ҵ
		 */
	int count, isMulandchu, complex, res, number1, number2, fh, rest;//����ȫ�ֱ���
	BigDecimal scope;
	char opera;

	void show() throws FileNotFoundException {//show���������ʾ��Ϣ�ʹӼ��̻�ȡ��Ӧֵ
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		try {//�ж��Ƿ���ڲ������������͵�ֵ
			System.out.println("������������Ŀ������");
			count = scanner.nextInt();
			System.out.println("������������ķ�Χ(��1��100��)");
			scope = scanner.nextBigDecimal();
		} catch (Exception e) {//������ֵ��������������ʱִ�����²���
			System.out.println("----------------------������������---------------------------");
			show();
		}
		System.out.println("�Ƿ�����˳����� 1��  0��");
		isMulandchu = scanner.nextInt();
		while (isMulandchu != 0 && isMulandchu != 1) {//�ж�����ĵ�ֵ�Ƿ�Ϊ0��1����ִ�����²���
			System.out.println("���������������룺");
			isMulandchu = scanner.nextInt();
		}
		System.out.println("�Ƿ��и�����1�� 0�� ");
		complex = scanner.nextInt();
		while (complex != 0 && complex != 1) {//�ж�����ĵ�ֵ�Ƿ�Ϊ0��1����ִ�����²���
			System.out.println("���������������룺");
			complex = scanner.nextInt();
		}
		System.out.println("�Ƿ���Ҫ��������1��  0�� ");
		res = scanner.nextInt();
		randomOperation();//����randomOperation����
	}

	void randomNumber() {//�������������number1��number2
		int num = (int) (Math.random() * scope.intValue());//�����������ֵ��num
		if (complex == 1) {//���ɸ��������1
			int c = (int) (Math.random() * 2);
			switch (c) {
			case 0:
				number1 = num * -1;
				break;

			case 1:
				number1 = num;
				break;
			}
		} else {//���������������
			number1 = num;
		}
		int nu = (int) (Math.random() * scope.intValue());
		if (complex == 1) {//���ɸ��������2
			int c = (int) (Math.random() * 2);
			switch (c) {
			case 0:
				number2 = nu * -1;
				break;

			case 1:
				number2 = nu;
				break;
			}
		} else {//�������������2
			number2 = nu;
		}
	}

	char operator() {//����+��-��*��/�����
		if (isMulandchu == 0) {//����+��-
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
		if (isMulandchu == 1) {//����+��-��*��/
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

	int result() {//�˷�������������
		if (isMulandchu == 0){//�Ӽ����Ľ��
			switch (fh) {
			case 0:
				rest = number1 + number2;

				break;

			case 1:
				rest = number1 - number2;
				break;
			}
			}
		if (isMulandchu == 1){//��������Ľ��
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

	void randomOperation() throws FileNotFoundException {//����������Ŀ����ӡ�������ʽ
		PrintStream ps = new PrintStream("d:/result.txt"); // ��d������txt�ĵ�
		System.setOut(ps);//������������ݴ�ӡ��"d:/result.txt"
		for (int i = 0; i < count; i++) {//����forѭ������������Ŀ������
			if (res == 1) {//�ж��Ƿ���Ҫ��������res=1��Ҫ������
				randomNumber();//�����������������
				operator();//�����������������
				result();//���ü���������
				System.out.print(number1);//��������1
				System.out.print(" " + opera + " ");//��������
				if (number2 < 0) {//number2Ϊ����ʱ��������2�͵�ʽ���
					System.out.println("(" + number2 + ")" + " " + "=" + " "
							+ rest);
				} else if (number2 >= 0) {//number2Ϊ����ʱ��������2�͵�ʽ���
					System.out.println(number2 + " " + "=" + " " + rest);
				}
			} else if (res == 0) {//res=0����Ҫ������ִ�����²���
				randomNumber();//�����������������
				operator();//�����������������
				System.out.print(number1);//��������1
				System.out.print(" " + opera + " ");//��������
				if (number2 < 0) {//number2Ϊ����ʱ��������2�͵Ⱥ�
					System.out.println("(" + number2 + ")" + " " + "=" + " ");
				} else if (number2 >= 0) {//number2Ϊ����ʱ��������2�͵Ⱥ�
					System.out.println(number2 + " " + "=" + " ");
				}
			}
		}
	}

}