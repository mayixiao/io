package com.java;

import java.util.ArrayList;
import java.util.List;

public class TestMy {

	/**
	 * @��������: 2017��03��10��9:34:29 PM
	 *
	 * @����:
	 * @����ֵ:
	 *
	 * @�޸ļ�¼���޸�ʱ�䡢���ߡ�ԭ�򣩣�
	 */
	public static void main(String[] args) {
		
		int max = 30;
		
		int[] deal_Array = new int[9];
		deal_Array[0] = 30;
		deal_Array[1] = 20;
		deal_Array[2] = 10;
		deal_Array[3] = 10;
		deal_Array[5] = 5;
		deal_Array[6] = 3;
		deal_Array[7] = 3;
		deal_Array[8] = 1;
		deal_Array[9] = 1;

		int temp = 0;
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<deal_Array.length;i++){
			for(int j=0;j<deal_Array.length;j++)
			if(i==0){
				temp = Math.abs(deal_Array[i]-max);
			}else{
				temp = temp<Math.abs(deal_Array[i]-max)?temp:Math.abs(deal_Array[i]-max);
			}
			
		}
		
		
		
	}

}
