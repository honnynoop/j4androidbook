package kr.co.infopub.j4android.c27;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.infopub.j4android.c25.Geo;

public class GeoMain {
	 public static void main(String[] args) {  
		 Geo[ ] geo=new Geo[]{ 
				 new Geo(37.5670, 126.9807), new Geo(47.01, 10.2),
				 new Geo(40.714086, -74.228697),new Geo(19.42847,-99.12766),
				 new Geo(39.9075,116.39723), new Geo(55.75222,37.61556) };
		 
		 showGeo(geo);
		 System.out.println("-----------------------------------");
		 ArrayList<Geo> geolist=new ArrayList<Geo>();
		 geolist.clear();                                    // 내용 지우기
		 geolist.add(new Geo(37.5670, 126.9807));           // 저장하기
		 geolist.add(new Geo(47.01, 10.2));
		 geolist.add(new Geo(40.714086, -74.228697));
		 geolist.add(new Geo(19.42847,-99.12766));
		 geolist.add(new Geo(39.9075,116.39723));
		 geolist.add(new Geo(55.75222,37.61556));
		 
		 showGeo(geolist);
	}
	public static void showGeo(Geo ...goose){    //var args …
		for(Geo gg: goose){
			System.out.printf("위도:%f, 경도:%f\n",gg.getLatitude(), gg.getLongitude());
		}
	}
	public static void showGeo(ArrayList<Geo>  goose){  // ArrayList
		for(Geo gg: goose){
			System.out.printf("위도:%f, 경도:%f\n",gg.getLatitude(), gg.getLongitude());
		}
	}

}

