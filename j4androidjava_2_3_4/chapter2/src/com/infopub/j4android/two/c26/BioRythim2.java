package com.infopub.j4android.two.c26;

public class BioRythim2 {

	public static void main(String[] args) {
		double phyval  =  getBioRhythmValue( 16649, 23,  100);
		System.out.printf("바이오리듬 => %.2f\n",phyval);
	}
	public static double getBioRhythmValue(  long days,  int index ,  int max )  {
		return   max * Math.sin( (days  % index) * 2 * 3.14 / index );
	}

	

}
