package com.java;

public class BackTrack {

	/**
	 * @创建日期: 2017年03月10日12:18:04 AM
	 *
	 * @参数:
	 * @返回值:
	 *
	 * @修改记录（修改时间、作者、原因）：
	 */
	
//	 public static void main(String[] args) {
//	        int[] input = {9,8,7,6,5,4,1};
//	        int[] record = new int[input.length];
//	        int key = 10;
//	        backtrack(input, record, key, 0, 0);
//	    }
	 
	    public static void backtrack(int[] input,int[] record,int key,int sum,int n) {
	        if(n == input.length){
	            return;
	        }else{
	            for(int i=0; i<=1; i++){
	                sum += i*input[n];
	                record[n] = i;
	                if(sum == key){
	                    for(int j=0; j<=n; j++){
	                        if(record[j]==1)
	                            System.out.print(input[j]);
	                    }
	                    System.out.println();
	                }
	                if(sum<key){
	                    backtrack(input, record, key, sum, n+1);
	                }
	                sum -= i*input[n];
	            }
	        }
	    }

	    
	        public static void main(String []args) {  
	            int[] arr = new int[5];  
	            arr[0] = 11;  
	            arr[1] = 8;  
	            arr[2] = 7;  
	            arr[3] = 5;  
	            arr[4] = 3;  
	            System.out.println(knapsack(arr, 0, 20, 20));  
	        }  
	      
	        /** 
	         *@param arr    all of items in knapsack 
	         *@param start  the start item to be put into the knapsack 
	         *@param left   the remaining capacity of knapsack 
	         *@param sum    capacity of knapsack 
	         */  
	        public static boolean knapsack(int[] arr, int start, int left, int sum) {  
	      
	            if (arr.length == 0) {  
	                return false;  
	            }  
	      
	            // start from the next item in original array  
	            if (start == arr.length) {  
	                int[] tempArr = new int[arr.length - 1];  
	                for (int i = 0; i < tempArr.length; i++) {  
	                    tempArr[i] = arr[i + 1];  
	                }  
	                return knapsack(tempArr, 0, sum, sum);  
	            } else if (arr[start] > left) {  
	                return knapsack(arr, start + 1, left, sum);  
	            } else if (arr[start] == left) {  
	                for (int i = 0; i < start + 1; i++) {  
	                    System.out.print(arr[i] + "\t");  
	                }  
	                System.out.println();  
	                return true;  
	            } else {  
	                return knapsack(arr, start + 1, left - arr[start], sum);  
	            }  
	        }  
	    
	    
}
