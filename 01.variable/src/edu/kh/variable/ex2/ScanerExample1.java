package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScanerExample1 {

	public static void main(String[] args) {
		
		// Scanner : ���α׷� ���� �� Ű���� �Է��� ���� �� �ְ� �ϴ� ����
		
		// Scanner ����
		// -> ���α׷� �ȿ� ��ĳ�ʶ�� ��踦 ���� ��
		Scanner sc = new Scanner(System.in);
		//	import�� ���ؿͼ�
		//	Scanner�� ���� ���� ������ ���赵�� ����
		// import �ؿ���� ���� �߻�! ==> import �ؿ��� ���� �ذ�
		//System.out.print("���� �Է��Ͻÿ�: ");
		//int input1 = sc.nextInt();// �Է� ���� ������ input1�� ����
		// nextInt() : ���� �Էµ� ������ �о�� (Ű����� �Էµ� ������ �о��)
		//System.out.println(input1);
		
		
		//System.out.print("�Ǽ��� �Է���:");
		//double input2 = sc.nextDouble();
		//System.out.println(input2);
		
		// �ȳ�? �ݰ���! �������?
		System.out.print("�Է�1: ");
		String input3 = sc.nextLine();
		// next() : ���� �Էµ� �� �ܾ �о��
		System.out.println(input3);
		
		System.out.print("�Է�2: ");
		String input4 = input3 + sc.next();
		System.out.println(input4);
	}

}
