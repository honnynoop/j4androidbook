package com.infopub.j4android.cal.one;

import java.util.Scanner;

public class EarthQuake1 {
	public static void main(String[] args) {
		
		
		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		double magnitude=0.0;
		
		Scanner scann=new Scanner(System.in);
		magnitude =scann.nextDouble();
		
		if (magnitude >= 8.0) {
			System.out.printf("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"RED");
			//showCircle(magnitude, "RED");
		} else if (magnitude >= 7.0) {
			System.out.printf("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"BLUE");
			//showCircle(magnitude, "BLUE");
		} else if (magnitude >= 6.0) {
			System.out.printf("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"BLACK");
			//showCircle(magnitude, "BLACK");
		} else {
			System.out.printf("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.\n", magnitude,"GREEN");
			//showCircle(magnitude, "GREEN");
		}
	}
	
	public  static void showCircle(double magnitude, String color){
		String st=String.format("지진 진도는 %1$.2f입니다. 지진색상은 %2$s입니다.", magnitude,color);
		System.out.println(st);
    }
}
