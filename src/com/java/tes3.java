package com.java;

public class tes3 {
	char state[11][101]; /* �� N <= 10 M <= 100 ��¼·�� */  
	int dp[101];         /* ʹ��һά����01���� */  
	int value[11];       /* ����ɽ��������ֵ����ͬһֵ */  
	int i, j;  
	
	void main()  
	{  
	    int N, M;  
	    scanf("%d", &N);  
	    for(i = 0; i < N; ++i)  
	    {  
	        scanf("%d",&value[i]);  
	    }  
	   
	    while(scanf("%d", &M) != EOF)  
	    {  
	        memset(dp,0,sizeof(dp));  
	   
	        /* 01���� */  
	        for(i = 0; i < N; ++i)  
	        {  
	            for(j = M; j >= value[i]; --j)  
	            {  
	                int tmp = dp[j-value[i]] + value[i];  
	                if(tmp > dp[j])  
	                {  
	                    dp[j] = tmp;  
	                    state[i][j] = 1;  
	                }  
	            }  
	        }  
	        printf("��ӽ�ֵ��%d\n",dp[M]);  
	   
	        /* ������� */  
	        i = N;  
	        j = M;  
	        while(i-- >= 0)  
	        {  
	            if(state[i][j] == 1)  
	            {  
	                printf("%d ",value[i]);  
	                j -= value[i];  
	            }  
	        }  
	        printf("\n");  
	    }  
	}  
}
