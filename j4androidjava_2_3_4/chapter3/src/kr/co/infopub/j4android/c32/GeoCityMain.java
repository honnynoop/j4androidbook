package kr.co.infopub.j4android.c32;

import java.util.ArrayList;

public class GeoCityMain {

	public static void main(String[] args) {
		ArrayList<ClockCity> cities=new ArrayList<ClockCity>();
		cities.clear();
		cities.add(new ClockCity(37.5670, 126.9807, "Asia/Seoul", "Korea"));   
		cities.add(new ClockCity(47.01, 10.2,"Europe/Vienna","Austria"));
		cities.add(new ClockCity(40.714086, -74.228697,"America/New_York","US"));
		cities.add(new ClockCity(19.42847,-99.12766,"America/Mexico_City","Mexico"));
		cities.add(new ClockCity(39.9075,116.39723,"Asia/Shanghai","China"));
		cities.add(new ClockCity(55.75222,37.61556,"Europe/Moscow","Rusia"));

		ClockCity city=cities.get(1);
		System.out.println(city.getLatitude());    // ºÎ¸ðÀÎGeo
		System.out.println(city.getLongitude ());

        System.out.println(city);
	}

}
