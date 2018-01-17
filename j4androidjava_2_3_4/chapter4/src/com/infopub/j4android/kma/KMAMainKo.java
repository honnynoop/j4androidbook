package com.infopub.j4android.kma;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class KMAMainKo {
//국내 지진정보 테스트
	public static void main(String[] args) {
		String urls="http://web.kma.go.kr/weather/earthquake_volcano/domesticlist.jsp";
		//String urls="http://www.kma.go.kr/weather/earthquake_volcano/internationallist.jsp";
		 String [] params=new String [] { "2010-01-01",todate2(new Date()),"3" ,"999"};
		String startTm=params[0];
		String endTm=params[1];
		String startSize=params[2];
		int endSize=999;
		String a= String.format("%s?%s&%s&%s",
				urls,
				para("startTm", startTm),
				para("endTm", endTm),
				para("startSize", startSize + "")
		);
		System.out.println(a);
		RequestFromKMAKo rfw=new RequestFromKMAKo();
		rfw.getAllHtml(a);   //웹에서 얻은 모든 문자열을 저장
		boolean isConnection=rfw.isConnection();  //문자열을 정상적으로 읽었나
		String str="<table class=\"table_develop";
		rfw.getEarthQuakes(str);
		ArrayList<KREarthQuake> krs =rfw.getKREarthQuakes();
		
		for (int i = 0; i < krs.size(); i++) {
			KREarthQuake krq=krs.get(i);
			System.out.println(krq);
		}
		
	}
	public static String para(String key, String value){
		return String.format("%s=%s", key, value);
	}
	public static  String todate2(Date dd){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dd);
    }
}
