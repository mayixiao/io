package com.java;


/**
 * ���ַ����� �۰����
 * @�������ڣ�2017��03��05��
 *
 * @�޸ļ�¼���޸�ʱ�䡢���ߡ�ԭ�򣩣�
 *
 */
public class HalfFind {

	public static void main(String[] args) {
		//ǰ����������������
		int[] arr = {1,3,4,7,9,30,80};
		int min = 0;
		int max = arr.length-1;
		//��Ҫ�ҵ���
		int num =0;
		//��Ҫ���ҵ��±�
		int index  = -1; //Ĭ��Ϊ-1���鲻��Ҳ����-1
		while(min <= max){
			int mid = (min+max)/2;
			if(arr[mid]==num){
				index = mid;
				break;
			}else if(arr[mid]>num){//��Χ������
				max = mid -1;
			}else{//��Χ���Ұ��
				min = mid +1;
			}
		}
		System.out.println("��Ҫ���ҵ�"+num +"���ڵ��±�λ��Ϊ��"+index);
	}
}
