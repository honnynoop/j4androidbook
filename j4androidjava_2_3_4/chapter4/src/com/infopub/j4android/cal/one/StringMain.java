package com.infopub.j4android.cal.one;
public class StringMain {
	public static void main(String[] args) {
		
        String city1="Asia";
        String city2="Europe";
        String city3="Asia";
        
        System.out.println(city1);
        System.out.println(city1.length());
        System.out.println(city1.equals(city2));
        System.out.println(city1==city2);
        System.out.println(city1.equals(city3));
        
        String city4=String.format("%s-%s", city1,city2);
        System.out.println(city4);
        
        String city5=city1+"-"+city2+1+2;
        System.out.println(city5);
        String city6=1+2+city1+"-"+city2;
        System.out.println(city6);
	}

}