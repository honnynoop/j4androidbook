package com.infopub.j4android.two.c25;

public class Divisioin {

	public static void main(String[] args) {
		int n=10;
		System.out.print("[1,");
		for (int i = 2; i < n; i++) { 
			if(n%i==0){ 
				System.out.printf("%d,",i);
			}
		}
		System.out.println(n+"]");

	}

}
