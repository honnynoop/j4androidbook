package kr.co.infopub.j4android;
//https://en.wikipedia.org/wiki/Haversine_formula
public class HaversineDistance {
	 
 public static void main(String[] args) {	 
	 
	double latitude1=37.52127220511242;
    double logitude1=127.0074462890625;
	double latitude2=35.137879119634185;
	double logitude2=129.04541015625;
	
	double d=distance(latitude1,logitude1,latitude2,logitude2);
	System.out.println(d);
}
 public static double distance(double lat1, double lng1, double lat2, double lng2) {
	 double earthR = 6371; // km
	 double dLat = (lat2-lat1);
	 double dLng = (lng2-lng1);
	 double a = Math.sin(Math.toRadians(dLat/2))  * Math.sin(Math.toRadians(dLat/2)) +
	            Math.cos(Math.toRadians( lat1))   * Math.cos(Math.toRadians( lat2)) * 
	            Math.sin(Math.toRadians( dLng/2)) * Math.sin(Math.toRadians( dLng/2)); 
	 double c = 2 * Math.asin(Math.sqrt(a)); 
	 //double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
	 double d = earthR * c;
    return d;
 }
}

/*

서울: 직선 323km
Latitude: 37.52127220511242
Longitude: 127.0074462890625
부산
Latitude: 35.137879119634185
Longitude: 129.04541015625
*/