package kr.co.infopub.j4android.c26;

import java.util.ArrayList;
import java.util.HashMap;

public class GeoMain {
	 public static void main(String[] args) {  

		 HashMap<String, Geo > cities=new HashMap<String, Geo>();   // Map 생성, 키 타입은 String, 밸류 타입은 Geo 
		 cities.clear(); // Map에 저장된 내용 제거
		 cities.put("Korea", new Geo(37.5670, 126.9807)); // Korea라는 키값에 Geo 객체를 밸류로 저장
		 cities.put("Austria", new Geo(47.01, 10.2));
		 cities.put("US", new Geo(40.714086, -74.228697));
		 cities.put("Mexico", new Geo(19.42847,-99.12766));
		 cities.put("China", new Geo(39.9075,116.39723));
		 cities.put("Rusia", new Geo(55.75222,37.61556));

		 System.out.println(cities.size());     // Map에 저장된 개수 
		 System.out.println(cities.containsKey("Austria"));   // 키값에 Austria가 있는가? 

		 Geo geo=cities.get("Austria");   // Austria에 해당되는 밸류
		 System.out.printf("%s : 위도:%f, 경도:%f\n","Austria",geo.getLatitude(), geo.getLongitude());

	}
}

