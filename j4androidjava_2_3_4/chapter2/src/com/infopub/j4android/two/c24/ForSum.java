package com.infopub.j4android.two.c24;

public class ForSum {

	public static void main(String[] args) {
		int n=2345;
		int tot=0;
		for( ; n>0 ; ){
			tot=tot+ n%10;
			n=n/10;
		}
		System.out.println(tot);
	}

}
