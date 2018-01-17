package com.infopub.j4android.two.c23;

public class BioRythim {

	public static void main(String[] args) {
		int myIndex=28;
		double value=0.56;
		String result=generateTextInformation(myIndex,value);
		System.out.printf("index %d, value %f => %s\n", myIndex,value,result);
	}
	public static String generateTextInformation(int index, double value) {
		String result = "";
		switch( index ) {
			case 23 : result = "신체지수: " ;break;
			case 28 : result = "감정지수: "; break;
			case 33 : result = "지성지수: "; break;
		}
		return result + (value*100);
	}

}
