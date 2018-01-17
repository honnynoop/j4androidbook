package com.jungbo.billboard2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class RequestFromBillToQr {
	
	public static void main(String[] args) {
		RequestFromBillboardHot2 rfw=new RequestFromBillboardHot2();
		//RequestFromBillBoardHot2 rfw=new RequestFromBillBoardHot2();
		String a="https://www.billboard.com/charts/hot-100/";
		String str="<article class=\"chart-row";
		rfw.getAllHtml(a);
		rfw.getBillboardData(str);
		
		ArrayList<Billbaord> boardList=new ArrayList<Billbaord>();
		boardList=rfw.getBillbaords();
		
		String baseurl="https://www.last.fm/music";
        String dir="d:\\billboardimage";
        
		for (Billbaord dto : boardList) {
			//http://www.last.fm/music/The+Chainsmokers/_/Closer
			String artis=String.format("%s/%s/_/%s", 
					baseurl, 
					qreq(ep(dto.getArtist())),
					qreq(ep(dto.getSong())));
			//System.out.println(artis);
			String png=String.format("%d.png", dto.getRank());
			//System.out.println("---------------"+png);
			
			//qr
			Thread t=new Thread(new Runnable(){
				@Override
				public synchronized void run() {
					BillBoardQrSave.saveQr(artis,dir+"\\qr", png);
				}
			});
			t.start();
		}
		toHtml(boardList, dir+"\\artis.html");
		
	}
	
	public static  String ep(String msg){
		return msg.replaceAll(" ", "+");
	}
	public static  String qreq(String msg){
		return msg.replaceAll("\'", "%27");
	}
	//Can%27t+Stop+The+Feeling!+(Original+Song+From+Dreamworks+Animation%27s+%22Trolls%22)
	public static void toHtml(ArrayList<Billbaord>  bills, String fname){
		
		String html="";
		html+="<table border='1'>";
		html+="<tr>";
		html+="<td>";
		  html+="번호";
		html+="</td>";
		html+="<td>";
		  html+="가수";
		html+="</td>";
		html+="<td>";
		  html+="노래";
		html+="</td>";
		html+="<td>";
		  html+="qr";
		html+="</td>";
		html+="</tr>\n";
		for (Billbaord dto : bills) {
			String png=String.format("%d.png", dto.getRank());
			html+="<tr>";
			html+="<td>";
			  html+=dto.getRank();
			html+="</td>";
			html+="<td>";
			  html+=dto.getArtist();
			html+="</td>";
			html+="<td>";
			  html+=dto.getSong();
			html+="</td>";
			html+="<td>";
			  html+="<img src='qr/"+png+"' width='100px' hight='100px'  />";
			html+="</td>";
			html+="</tr> \n";
		}
		html+="</table>";
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(
					new FileWriter(fname,false),true);
			pw.println(html);
			pw.close();
		} catch (IOException e) {
			System.out.println();
		}
	}
	
	
}
