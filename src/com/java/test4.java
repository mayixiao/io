package com.java;

import java.util.ArrayList;

//����
public class test4 {
	
	public static void main(String[] args) {
		
		beiBao();
	}
	
	public static void beiBao() {

		int[] deal_Array = new int[9];
		deal_Array[0] = 30;
		deal_Array[1] = 20;
		deal_Array[2] = 10;
		deal_Array[3] = 10;
		deal_Array[5] = 5;
		deal_Array[6] = 3;
		deal_Array[7] = 3;
		deal_Array[8] = 1;
		// ������������С����������Ϊ50w��10%����5w���ٽ�100������Ϊ500  
		int dp[] = new int[501];
		char state[][] = new char[deal_Array.length][501]; /* ��¼·���Ķ�ά���� */
		int i, j;
		int M = 30; // �����ҽ���ֵ  
		/* 01���� */
		for (i = 0; i < deal_Array.length; ++i) {
			for (j = M; j >= deal_Array[i]; --j) {
				int tmp = dp[j - deal_Array[i]] + deal_Array[i];
				if (tmp > dp[j]) {
					dp[j] = tmp;
					state[i][j] = 1;
				}
			}
		}
		i = deal_Array.length; // �ڼ�����Ʒ  
		j = M;// ��ǰ��������  
		System.out.println("============================");
		while ((--i) >= 0) {
			if (state[i][j] == 1) {
				System.out.print(deal_Array[i] + " ");
				j -= deal_Array[i];
			}
		}
	}  
}
