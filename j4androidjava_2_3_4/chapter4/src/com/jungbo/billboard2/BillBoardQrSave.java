package com.jungbo.billboard2;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;

public class BillBoardQrSave {

	public static void main(String[] args) {
		
		String url="https://www.last.fm/music/The+Chainsmokers/_/Closer";
		String dir="d:\\billboardimage\\qr";    // d:\billboardimage에 qr 디렉토리를 만들고 시작 
		String fname="1.png";
		saveQr(url,dir,fname);

	}
	
	public static  void saveQr (String url, String dir, String fname){
		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix qrCode;
		try {
			qrCode = writer.encode(url, BarcodeFormat.QR_CODE,
					300, 300);
			BufferedImage qrImage = MatrixToImageWriter
					.toBufferedImage(qrCode);
			ImageIO.write(qrImage, "PNG", new File(dir, fname));
		} catch (WriterException e) {
			System.out.println(e);
		}catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("end~~~~~");
	}
	
}
