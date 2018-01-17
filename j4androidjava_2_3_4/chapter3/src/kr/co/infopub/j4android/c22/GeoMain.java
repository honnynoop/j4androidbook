package kr.co.infopub.j4android.c22;

public class GeoMain {
	 public static void main(String[] args) {  

		Geo seoul = new Geo(37.5670, 126.9807);  
		Geo austria = new Geo(47.01, 10.2);  
		Geo newyork = new Geo(40.714086, -74.228697);
		Geo mexico = new Geo(19.42847,-99.12766);
		Geo china = new Geo(39.9075,116.39723);
		Geo rusia = new Geo(55.75222,37.61556);

		 showGeo(seoul,austria,newyork);      // 3개 인자
		 showGeo(seoul,austria,newyork,mexico,china,rusia);   // 6개 인자
	}
	public static void showGeo(Geo ...goose){   // 인자가 여러 개 와도 된다. 
		 for(Geo gg: goose){ 
			 System.out.printf("위도:%f, 경도:%f\n",gg.getLatitude(), gg.getLongitude());
		}
	}
}

