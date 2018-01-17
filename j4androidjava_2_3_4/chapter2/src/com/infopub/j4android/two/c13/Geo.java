package com.infopub.j4android.two.c13;

public class Geo {
	public double latitude;
	public double longitude;
	public Geo(double latitude, double logitude) {
		this.latitude = latitude;
		this.longitude = logitude;
	}
	public Geo() {
	}
	@Override
	public String toString() {
		return "Geo [latitude=" + latitude + ", logitude=" + longitude + "]";
	}
	
}
