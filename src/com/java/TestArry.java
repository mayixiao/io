package com.java;

import java.util.Arrays;

public class TestArry {

	public static void main(String[] args) {
		
		int[] arr = new int[]{7,4,1,8,9,2,6};
		
//		for(int i=0;i<arr.length;i++){
//			for(int j=arr.length-1;j>i;j--){
//				int t;
//				if(arr[i]>arr[j]){
//					t = arr[j];
//					arr[j]=arr[i];
//					arr[i] = t;
//				}
//			}
//		}
		System.out.println(Arrays.toString(arr));
		
		TestArry testArry = new TestArry();
		testArry.sort(arr);
		
	}
	
	//√∞≈›≈≈–Ú
	public void sort(int[] arr){
		
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int t = arr[j];
					arr[j]=arr[i];
					arr[i] = t;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}




