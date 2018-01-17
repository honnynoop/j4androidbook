package com.infopub.j4android.cal.one;
public class SwitchMain {
	public static final int PHYSICAL = 23;
	public static final int EMOTIONAL = 28;
	public static final int INTELLECTUAL = 33;
	public static void main(String[] args) {
		int index=PHYSICAL;
		double value=0.86;
		String st=generateTextInformation( index,  value) ;
		System.out.println(st);
	}
	public static String generateTextInformation(int index, double value) {
		String result = "";
		switch( index ) {
			case PHYSICAL : result = "신체지수: " ;break;
			case EMOTIONAL : result = "감정지수: "; break;
			case INTELLECTUAL : result = "지성지수: "; break;
			default : result = "미결정: "; break;
		}
		return result + (value*100);
	}
}
