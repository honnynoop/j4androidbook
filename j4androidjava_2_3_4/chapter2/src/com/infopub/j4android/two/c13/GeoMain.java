package com.infopub.j4android.two.c13;
public class GeoMain {
	public static void main(String[] args) {
		
		double latitude1=37.52127220511242;
	    double longitude1=127.0074462890625;

		Geo geo1=new Geo() ;
		geo1.latitude=latitude1;
		geo1.longitude=longitude1;
		
		System.out.printf("위도:%f, 경도:%f\n",geo1.latitude, geo1.longitude);
		
		Geo geo2=geo1;
		System.out.printf("위도:%f, 경도:%f\n",geo2.latitude, geo2.longitude);// 가져오기
	}
}
