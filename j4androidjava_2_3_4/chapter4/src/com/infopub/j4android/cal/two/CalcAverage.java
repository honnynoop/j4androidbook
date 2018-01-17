package com.infopub.j4android.cal.two;

import java.util.Scanner;

public class CalcAverage {
	public static void main(String[] args) {
		String s1="Enter 3 integers separarated only by spaces: <example 20 30 40>";
		System.out.println(s1);
		Scanner scann=new Scanner(System.in);
		int a=scann.nextInt();
		int b=scann.nextInt();
		int c=scann.nextInt();
		int average=(a+b+c)/3;
		System.out.println("Average = "+average);
		scann.close();
	}
}
