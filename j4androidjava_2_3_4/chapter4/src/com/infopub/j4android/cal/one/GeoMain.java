package com.infopub.j4android.cal.one;
public class GeoMain {
	public static void main(String[] args) {
		double latitude1=37.52127220511242;
	    double logitude1=127.0074462890625;

		Geo geo1=new Geo() ;
		geo1.latitude=latitude1;
		geo1.logitude=logitude1;
		
		System.out.printf("위도:%f, 경도:%f\n",geo1.latitude, geo1.logitude);
		
		Geo geo2=geo1;
		System.out.printf("위도:%f, 경도:%f\n",geo2.latitude, geo2.logitude);// 가져오기
	}
}
