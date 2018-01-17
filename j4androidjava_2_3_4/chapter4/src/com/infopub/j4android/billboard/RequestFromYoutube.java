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

public class RequestFromYoutube {
	
	    boolean isConnection=false;
	    ArrayList<String> htmls=new ArrayList<String>();
	    String youtubeUrl = "https://www.last.fm/music/";
	    String result;

	    public RequestFromYoutube(){
	    	htmls.clear();
	    }
	   
	    public ArrayList<String> getHtmls() {
			return htmls;
		}
//https://www.youtube.com/watch?v=oHmBf4ExtZk
		public static void main(String[] args) {
	    	RequestFromYoutube rfy=new RequestFromYoutube();
	    	String youtubeUrl = "https://www.last.fm/music/";
	    	String songName="Ariana+Grande";
	    	String artist="Everyday";
	    	rfy.getAllHtml(youtubeUrl, songName, artist);
	    	String aa=rfy.getHtmls().get(0);
	    	String result = cutResultTwo(cutResultOne(aa), "\"");
	    	System.out.println(aa);
	    	System.out.println(result);
		}
	    public String replace(String msg){
	        String ss=msg;
	        ss=ss.replaceAll("&#039;", "'");
	        ss=ss.replaceAll("&amp;", "&");
	        ss=ss.replaceAll("&quot;", "\"");

	        return ss.trim();
	    }
	    public void getAllHtml(String newUrls, String songName, String artist) {
	        htmls.clear();
	        URL url = null;
	        BufferedReader br=null;
	        try {
	            url = new URL(newUrls +artist+"/_/"+songName );
	            //Log.i("getAllHtml","000000000------------------------"+newUrls +artist+"/_/"+songName );
	            br = new BufferedReader(new InputStreamReader(url.openStream()));
	            int count = 0;
	            String msg = "";
	            while ((msg = br.readLine()) != null) {
	                System.out.println(msg);
	                if(msg.trim().contains("tube.com/embed/")){
	                    count = 1;
	                   // Log.i("getAllHtml","222222222------------------------"+msg);
	                }
	                if(count== 1){
	                    if(!msg.trim().equals("")){
	                        htmls.add(msg.trim());
	                        count++;
	                    }
	                }
	            }
	            //inputStream.close();
	            isConnection = true;

	        } catch (Exception e) {
	            isConnection = false;
	            System.out.println(e);
	        }
	    }

	    
	    public  String getResult(){
	        return result;
	    }

	   
	    // 짜르기
	    public static String cutResultOne(String msg){
	        String t = "";
	        if(msg.indexOf("embed/") == -1){
	            t = "";
	        }
	        else {
	            t = msg.substring(msg.indexOf("embed/")+6);
	        }
	        return t;
	    }
	    public static String cutResultTwo(String msg, String c){
	        String t = "";
	        if(msg.indexOf(c) == -1){
	            t = "";
	        }
	        else{
	            t= msg.substring(0, msg.indexOf(c));
	        }
	        return t;
	    }
}
