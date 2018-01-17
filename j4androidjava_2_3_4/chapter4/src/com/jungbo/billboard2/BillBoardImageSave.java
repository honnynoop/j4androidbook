package com.jungbo.billboard2;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
public class BillBoardImageSave {  // this week
	public static void main(String[] args) {
		// d:\\billboardimage와 같이 d 디렉토리에 billboardimage 만들기 
		RequestFromBillboardHot2 rfw=new RequestFromBillboardHot2();
		String a="https://www.billboard.com/charts/hot-100/";
		String str="<article class=\"chart-row";
		rfw.getAllHtml(a);
		rfw.getBillboardData(str);

		ArrayList<Billbaord> boardList=new ArrayList<Billbaord>();
		boardList=rfw.getBillbaords();
		
		for (Billbaord board:boardList) {
			Thread t=new Thread(new Runnable() {
					@Override
					public  void run() {
						save(board.getRank()+".jpg",board.getImagesrc());
					}
			});
			t.start();
		}
	}//main
	
	public static void save(String fname,String flagname){
    	BufferedImage image = null;
        try {
        	if(flagname.contains("q____")){
        		System.out.println(fname+" is not existed.");
        		return ;
        	}
            URL url = new URL(flagname);
            image = ImageIO.read(url);
            ImageIO.write(image, "png",new File("d:\\billboardimage\\"+fname)); 
            // 자신의 환겨에 맞추기 c만 있다면--> c:\\billboardimage
            System.out.println(fname+" saved! "+new Date());
            
        } catch (IOException e) {
        	System.out.println(flagname+"는 이름만 존재 ---"+fname);
        }catch(Exception e){
        	System.out.println(e);
        }
    }
}
