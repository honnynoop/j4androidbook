package com.infopub.j4android.cal.one;
public class SwitchMain2 {
	public static void main(String[] args) {
		int index=23; 
		double value=0.86;
		String st=generateTextInformation( index,  value) ;
		System.out.println(st);
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
