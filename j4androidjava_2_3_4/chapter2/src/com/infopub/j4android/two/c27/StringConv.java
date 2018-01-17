package com.infopub.j4android.two.c27;

public class StringConv {

	public static void main(String[] args) {
		String city1="Asia";       // (1) 문자열
		String city2="Europe";
		city2=city1;             // (2) 값이 복사되므로 city2="Asia"
		System.out.println(city1.length());  // (3) 문자열의 길이를 구한다.
		String city4=String.format("%s-%s", city1,city2);   // (4) 원하는 포맷 만들기
		System.out.println(city4);
	}

}
