package com.infopub.j4android.two.c23;

public class IfCondition3 {

	public static void main(String[] args) {
		
		int temp=99;
		if(temp%2==1){    //99-> 홀수 
			temp=temp*3+1;
		}else{
			temp=temp/2;
		}
		System.out.printf("계산 후=%d\n",temp);
	}

}
