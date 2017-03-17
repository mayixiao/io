package com.java;

public class Test {

	   //参数说明

	  //@param intArray：从大到小排序的物品重量数组

	  //@param start:     从数组的哪一个元素开始往包里面放

	  //@param left:      包还能装的重量

	  //@param sum:       包能够装的总重量

	public static void beibao(int[] intArray,int start,int left,int sum){

	   if(intArray.length == 0){//所选物品件数不能为空（即没有数组可以再匹配了）,所以返回无解

	    System.out.println("无解");

	    return;

	   }

	   if(start == intArray.length){//如果为最后一个包都匹配完了还是没有找到解，那么就重新匹         

	                                                   //配 下 一组数组（去掉第一个物品再找是否匹配的）

	    System.out.println("回朔开始");

	    int[] another = new int[intArray.length - 1];

	    for(int i=0;i<another.length;i++){

	     another[i] = intArray[i+1];

	    }

	    beibao(another,0,sum,sum);

	   }

	   else   if(intArray[start] > left){//如果最重的物品重量大于所剩的可放重量,则匹配下一物品

	    beibao(intArray,start+1,left,sum);

	   }else if(intArray[start] == left){//如果最重的物品重量等于所剩的可放重量,则此题有解

	    System.out.println("此题有解");

	    return;

	   }else{//如果最重的物品重量小于所剩的可放重量,则所剩可放重量减去这个物品的重量,然后匹

	                                                           //配下一物品

	    beibao(intArray,start+1,left-intArray[start],sum);//递归

	   }

	}

	public static void main(String[] args){

	      int[] intArray = {9,6,5,4,2};

	      beibao(intArray,0,7,7);
	}
}
