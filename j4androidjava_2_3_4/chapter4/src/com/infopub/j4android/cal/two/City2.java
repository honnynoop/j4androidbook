package com.infopub.j4android.cal.two;

public class City2 {
	
	private double latitude;
	private double logitude;
	public City2(double latitude, double logitude) {
		this.latitude = latitude;
		this.logitude = logitude;
	}
	public City2() {
		this(37.5,127.0);
	}
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLogitude() {
		return logitude;
	}

	public void setLogitude(double logitude) {
		this.logitude = logitude;
	}

	@Override
	public String toString() {
		return "City [위도=" + latitude + ", 경도=" + logitude +"]";
	}
	//37°30′N 127°00′E -> 37.5, 127.0
	public void setLatLng(String latlng) {
		String first="";
		String second="";
		if(latlng.contains("N")){
			first=latlng.substring(0,latlng.indexOf("N")+1).trim();
			second=latlng.substring(latlng.indexOf("N")+1).trim();
		}else if(latlng.contains("S")){
			first=latlng.substring(0,latlng.indexOf("S")+1).trim();
			second=latlng.substring(latlng.indexOf("S")+1).trim();
		}
		//System.out.println(first);
		//System.out.println(second);
		this.latitude=toLatLng(first);
		this.logitude=toLatLng(second);
		//this.latitude = latitude;
	}
	
	//------------------------공개안됨
	//37°30′N
	private double toLatLng(String latlng){
		String first="";
		String second="";
		if(latlng.contains("°")){
			first=latlng.substring(0,latlng.indexOf("°")).trim();  //37
			second=latlng.substring(latlng.indexOf("°")+1).trim();//30′N
		}
		if(second.contains("′")){
			second=second.replace("′", "").trim();
		}
		//System.out.println(first);
		//System.out.println(second);
		return toM(first,second);
	}
	private double toDb(String msg){
		return Double.parseDouble(msg);
	}
	private double toM(String first, String second){ //minus 붙이기
		String mt="";
		double toMt=0.0;
		if(second.contains("N") || second.contains("E")){
			mt=second.replace("N", "");
			mt=mt.replace("E", "");
			toMt=toDb(first.trim())+toDb(mt.trim())/60.0;
		}else{
			mt=second.replace("S", "");
			mt=mt.replace("W", "");
			toMt=toDb(first.trim())+toDb(mt.trim())/60.0;
			toMt*=-1;    //음수
		}
		return toMt;
	}
	
	public static void main(String[] args) {
		City2 geo=new City2();
		geo.setLatLng("37°30′N 127°00′E");//Seoul
		System.out.println(geo);
		geo.setLatLng("12°39′N 8°00′W");//Mali
		System.out.println(geo);
		geo.setLatLng("12°03′S 77°03′W"); //Peru
		System.out.println(geo);
	}
	
	

}
//37°30′N 127°00′E
//https://en.wikipedia.org/wiki/Latitude_and_longitude_of_cities,_I-P