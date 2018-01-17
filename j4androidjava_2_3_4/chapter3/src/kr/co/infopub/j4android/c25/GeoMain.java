package kr.co.infopub.j4android.c25;

import java.util.ArrayList;

public class GeoMain {
	 public static void main(String[] args) {  

		 ArrayList<Geo> geolist=new ArrayList<Geo>();
		 geolist.clear();                                    // 내용 지우기
		 geolist.add(new Geo(37.5670, 126.9807));           // 저장하기
		 geolist.add(new Geo(47.01, 10.2));
		 geolist.add(new Geo(40.714086, -74.228697));
		 geolist.add(new Geo(19.42847,-99.12766));
		 geolist.add(new Geo(39.9075,116.39723));
		 geolist.add(new Geo(55.75222,37.61556));
		 System.out.println(geolist.size());                        // 리스트에 저장된 개수 6개
		 Geo gt=geolist.get(1);  // index 1의 객체 가져온다. 47.01, 10.2
		 System.out.printf("위도:%f, 경도:%f\n",gt.getLatitude(), gt.getLongitude());

	}
}

