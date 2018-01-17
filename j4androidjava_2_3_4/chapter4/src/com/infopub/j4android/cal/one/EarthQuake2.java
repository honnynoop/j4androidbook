package com.infopub.j4android.cal.one;

import java.util.Scanner;

public class EarthQuake2 {
	public static void main(String[] args) {
		double magnitude=0.0;
		Scanner scann=new Scanner(System.in);
		magnitude =scann.nextDouble();
		
		String st= (magnitude >= 8.0) ?
			String.format("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"RED")
		: (magnitude >= 7.0) ?
			String.format("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"BLUE")
		: (magnitude >= 6.0) ?
		    String.format("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"BLACK")
		:   String.format("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"GREEN");
		System.out.println(st);
	}
	
}
