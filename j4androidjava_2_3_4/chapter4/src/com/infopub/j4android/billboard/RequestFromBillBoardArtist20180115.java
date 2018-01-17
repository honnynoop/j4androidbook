package com.infopub.j4android.billboard;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class RequestFromBillBoardArtist20180115 {
	
	ArrayList<String> htmls=new ArrayList<String>();
	ArrayList<Billbaord> billbaords=new ArrayList<Billbaord>();
	public RequestFromBillBoardArtist20180115() {
		htmls.clear();
		billbaords.clear();
	}

	public ArrayList<Billbaord> getBillbaords() {
		return billbaords;
	}

	boolean isConnection=false;
	
	public void getAllHtml(String newUrls){
		htmls.clear();
		InputStream inputStream;
		URL url=null;
		try {
			url= new URL(newUrls);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	
			inputStream = new BufferedInputStream(urlConnection.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "euc-kr"), 8);
	
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				if(!line.trim().equals("")){

					htmls.add(line.trim());
				}
			}
			inputStream.close();
			isConnection=true;

		} catch (Exception e) {
			isConnection = false;
			System.out.println(e);
		} 
	}
	
	
	public synchronized void getBillboardData(String msg){
		billbaords.clear();
		int count=0;
		for (int i=0; i<htmls.size(); i++) {
			String ss=htmls.get(i);
			if(ss.contains(msg)){  
				count++ ;
				//System.out.println(count+":");
				String rank=ss.substring(ss.indexOf("chart-row--")+"chart-row--".length());
				rank=rank.substring(0,rank.indexOf("js")-1).trim();
				//System.out.println(rank);
				String song=ss.substring(ss.indexOf("Song Hover-")+"Song Hover-".length());
				song=song.substring(0,song.indexOf("\"")).trim();
				//System.out.println(replace(song));
				int j=1;
				String imageurl=htmls.get(i+j);
				while(j<10){
					if(imageurl.contains("images/pref_images")){
						break;
					}else{
						j++;
						imageurl=htmls.get(i+j);
					}
				}
				
				if(imageurl.contains("images/pref_images")){
					if(imageurl.contains("http://")){
						imageurl=imageurl.substring(imageurl.indexOf("http://"));
						imageurl=imageurl.substring(0,imageurl.indexOf(".jpg")+".jpg".length());
					}else{
						imageurl="http://www.billboard.com/images/pref_images/q__________.jpg";
					}
				}else{
					imageurl="http://www.billboard.com/images/pref_images/q__________.jpg";
				}

				//System.out.println(imageurl);
				
				Billbaord board=new Billbaord(
						toInt(rank), "", 
						0, imageurl, "", replace(song));
				billbaords.add(board);
				//System.out.println("-------------------------------------------------");
			}
		}
	}
			
			
			
	public String replace(String msg){
		String ss=msg;
		ss=ss.replaceAll("&#039;", "'");
		ss=ss.replaceAll("&amp;", "&");
		ss=ss.replaceAll("&quot;", "\"");
		
		return ss.trim();
	}
	private String __toStr(String lastweek){
		return lastweek.contains("--")?101+"":lastweek;
	}
	private int toInt(String msg){
		return Integer.parseInt(msg==null ?"-1":msg.trim());
	}
	public String toArtis(String msg){
		return msg.replaceAll("-", " ");
	}
	public void printHtml(){
		for (String dto : htmls) {
			System.out.println(dto);
		}
	}
	public void printBillboard(){
		for (Billbaord dto : billbaords) {
			System.out.println(dto);
		}
	}
	
	public Calendar todate(String ss){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dd=new Date();
		try {
			dd=sdf.parse(ss);
		} catch (ParseException e) {
		}
		Calendar cal=Calendar.getInstance();
		cal.setTime(dd);
		return cal;
	}
	
	public String todate(String ss,int totals, int round){
		Calendar cal=todate(ss);
		//Calendar calTemp = (Calendar) cal.clone();
		cal.add(Calendar.DAY_OF_YEAR, -(totals-round)*7);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}
	
	//정해진 날짜 기준    1-> 일주일 전       2-> 이주전
		public String toWantedDay(String ss,int round){
			Calendar cal=todate(ss);
			//-7일을 더하면 일주전
			cal.add(Calendar.DAY_OF_YEAR, -(round*7));
			//칼렌더를 문자열로 
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(cal.getTime());
		}
	
	public static void main(String[] args) {
		RequestFromBillBoardArtist20180115 rfw=new RequestFromBillBoardArtist20180115();

		String a="http://www.billboard.com/charts/greatest-billboard-200-artists";
		rfw.getAllHtml(a);

		//rfw.printHtml();
		String str="<article class=\"chart-row";
		rfw.getBillboardData(str);
        rfw.printBillboard();
	}
}
