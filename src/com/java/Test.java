package com.java;

public class Test {

	   //����˵��

	  //@param intArray���Ӵ�С�������Ʒ��������

	  //@param start:     ���������һ��Ԫ�ؿ�ʼ���������

	  //@param left:      ������װ������

	  //@param sum:       ���ܹ�װ��������

	public static void beibao(int[] intArray,int start,int left,int sum){

	   if(intArray.length == 0){//��ѡ��Ʒ��������Ϊ�գ���û�����������ƥ���ˣ�,���Է����޽�

	    System.out.println("�޽�");

	    return;

	   }

	   if(start == intArray.length){//���Ϊ���һ������ƥ�����˻���û���ҵ��⣬��ô������ƥ         

	                                                   //�� �� һ�����飨ȥ����һ����Ʒ�����Ƿ�ƥ��ģ�

	    System.out.println("��˷��ʼ");

	    int[] another = new int[intArray.length - 1];

	    for(int i=0;i<another.length;i++){

	     another[i] = intArray[i+1];

	    }

	    beibao(another,0,sum,sum);

	   }

	   else   if(intArray[start] > left){//������ص���Ʒ����������ʣ�Ŀɷ�����,��ƥ����һ��Ʒ

	    beibao(intArray,start+1,left,sum);

	   }else if(intArray[start] == left){//������ص���Ʒ����������ʣ�Ŀɷ�����,������н�

	    System.out.println("�����н�");

	    return;

	   }else{//������ص���Ʒ����С����ʣ�Ŀɷ�����,����ʣ�ɷ�������ȥ�����Ʒ������,Ȼ��ƥ

	                                                           //����һ��Ʒ

	    beibao(intArray,start+1,left-intArray[start],sum);//�ݹ�

	   }

	}

	public static void main(String[] args){

	      int[] intArray = {9,6,5,4,2};

	      beibao(intArray,0,7,7);
	}
}
