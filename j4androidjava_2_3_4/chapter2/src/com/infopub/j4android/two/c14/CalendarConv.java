package com.infopub.j4android.two.c14;

public class CalendarConv {

	public static void main(String[] args) {
		long days=System.currentTimeMillis();
		int day=(int)(days/1000/24/60/60);
		System.out.printf("밀리세컨드경과%d=> 몇일경과 %d\n",
				days,day);
	}

}
