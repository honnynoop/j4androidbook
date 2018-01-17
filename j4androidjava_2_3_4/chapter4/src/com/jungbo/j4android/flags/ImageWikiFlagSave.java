package com.jungbo.j4android.flags;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageWikiFlagSave
{
	public static String size(String name, int size){
		if(name.contains("px-Flag")){
			String prefix=name.substring(0,name.lastIndexOf("/")+1);
			String postfix=name.substring(name.lastIndexOf("/")+1);
			postfix=postfix.substring(postfix.indexOf("px-Flag"));
			//System.out.println(prefix+size+postfix);
			return prefix+size+postfix;
		}else return name;
	}
	public static String __toEmpty(String msg){
		return msg.replaceAll("_", " ");
	}
	public static String emptyto_(String msg){
		return msg.replaceAll(" ", "_");
	}
	public static String toJpg(String msg){
		String ss=msg;
		ss=ss.replaceAll("%27", "_a_");
		ss=ss.replaceAll("%28", "_l_");
		ss=ss.replaceAll("%29", "_r_");
		ss=ss.replaceAll("-", "_m_");
		return ss.trim().toLowerCase();
	}

	public static String toname(String msg){
		String ss=msg;
		ss=ss.replaceAll("%27", "\'");
		ss=ss.replaceAll("%28", "(");
		ss=ss.replaceAll("%29", ")");
		ss=ss.replaceAll("%C3%B4", "o");
		ss=ss.replaceAll("%C3%85", "A");
		return ss.trim();
	}
	public static String toEntity(String msg){
		String ss=msg;
		ss=ss.replaceAll("&", "&amp;");
		ss=ss.replaceAll(">", "&gt;");
		ss=ss.replaceAll("<", "&lt;");
		ss=ss.replaceAll("\'", "&apos;");
		ss=ss.replaceAll("\"", "&quot;");
		return ss.trim();
	}
    public static void main( String[] args )
    {
		RequestFromWikiFlag rfw=new RequestFromWikiFlag();

		String a="https://ko.wikipedia.org/wiki/ISO_3166-1";
		String msg="srcset=\"//upload.wikimedia.org/wikipedia";
		rfw.getAllHtml(a);   
		//rfw.printHtml();
		rfw.getSevereign(msg);
		//rfw.printFlags();
		
		ArrayList<SovereignFlag> aa=rfw.getFlags();
		//List<SovereignFlag> aa=flags.subList(0, 30);//0~29 30개 
		//ArrayList<SovereignFlag> aa=new ArrayList<SovereignFlag>(flags.subList(0, 30));
		//String ss=saveXML(aa);
		//printXML("flagsxml.xml",ss);
		//System.out.println(ss);
		
		//String st=saveJSON(aa);
		//printXML("flagsjson.json",st);
		//System.out.println(st);
		
		//String saveJava=saveJava(aa);
		//printPlain("flagstxt.txt",saveJava);
		int sizes=32;
		for (SovereignFlag flag:aa) {
				Thread t=new Thread(new Runnable() {
				@Override
				public synchronized void run() {
					//save(emptyto_(100+flag.getName()),size(flag.getFlag(),100));
//					save(
//					toJpg(emptyto_(flag.getName().toLowerCase())),size(flag.getFlag(),32*6));
					save(//0927
					flag.getShortname().toLowerCase(),size(flag.getFlag(),sizes));
				}
				
			});
			t.start();
		}
//		
		System.out.println("-----------------------------------");
		
	
    }
    public static String saveJava(List<SovereignFlag> flags){
    	StringBuffer sb=new StringBuffer();
    	for (SovereignFlag flag:flags) {
    	   String ss=String.format(
    	"flags.add(new SovereignFlag(%s,%s,%s,%s,R.drawable.%s));\n", 
    			quot(toname(flag.getName())),
    			quot(flag.getShortname()),
    			quot(flag.getCode()),
    			quot(flag.getKorname()),//
    			flag.getShortname().toLowerCase());//0927
    	   //toJpg(emptyto_(flag.getName())).toLowerCase());
    	   sb.append(ss);
    	}
    	return sb.toString();
    }
    
    public static String saveXML(List<SovereignFlag> flags){
    	StringBuffer sb=new StringBuffer();
    	sb.append("<?xml version='1.0' encoding='utf-8' ?>\n"); 
    	sb.append(start("nationalflags"));
    	for (SovereignFlag flag:flags) {
			sb.append(saveXML(flag));
    	}
    	sb.append(end("nationalflags"));
    	return sb.toString();
    }
    public static String start(String msg){
    	return "<"+msg+">\n";
    }
    public static String end(String msg){
    	return "\n</"+msg+">\n";
    }
    public static String quot(String msg){
    	return "\""+msg+"\"";
    }
    public static String json(String key, String value){
    	return String.format("%s:%s", quot(key),quot(value));
    }
    public static String json(String key, int value){
    	return String.format("%s:%d", quot(key),value);
    }
    public static String  saveJSON(SovereignFlag flag){
    	StringBuffer sb=new StringBuffer();
    	sb.append("{");
    	sb.append(json("name",toname(flag.getName())));
    	sb.append(",");
    	sb.append(json("shortname",flag.getShortname()));
    	sb.append(",");
    	sb.append(json("code",flag.getCode()));
    	sb.append(",");
    	//sb.append(json("flag",flag.getFlag()));//flag.getShortname().toLowerCase()
    	sb.append(json("flag", flag.getShortname().toLowerCase()+".png"));//0927
    	//sb.append(json("flag", toJpg(emptyto_(flag.getName())).toLowerCase()+".png"));
    	sb.append(",");
    	sb.append(json("korname",(flag.getKorname())));
    	sb.append("}\n");
    	return sb.toString();
    }
    
//    public static String han(String word){
//    	String st=word;
//    	try {
//    		st=new String(word.getBytes("MS949"), "euc-kr");	
//		} catch (Exception e) {
//			
//		}
//    	return st;
//    }
    public static String saveJSON(List<SovereignFlag> flags){
    	StringBuffer sb=new StringBuffer();

    	sb.append("{");
    	sb.append(quot("nationalflags"));
    	sb.append(":");
    	sb.append("[\n");
    	for (int i=0; i<flags.size()-1 ;i++) {
    		SovereignFlag flag=flags.get(i);
			sb.append(saveJSON(flag));
			sb.append(",");
    	}
    	sb.append(saveJSON(flags.get(flags.size()-1)));
    	sb.append("]\n");
    	sb.append("}");
    	return sb.toString();
    }
    public static String  saveXML(SovereignFlag flag){
    	StringBuffer sb=new StringBuffer();
    	sb.append(start("nationalflag"));
    		sb.append(start("name"));
    			sb.append(toEntity(toname(flag.getName())));
    		sb.append(end("name"));
    		sb.append(start("shortname"));
    			sb.append(flag.getShortname());
    		sb.append(end("shortname"));
    		sb.append(start("code"));
    			sb.append(flag.getCode());
    		sb.append(end("code"));
    		sb.append(start("flag"));
    			//sb.append(flag.getFlag());
    		sb.append(flag.getShortname().toLowerCase()+".png");//0927
    		//sb.append(toJpg(emptyto_(flag.getName())).toLowerCase()+".png");
    		sb.append(end("flag"));
    		sb.append(start("korname"));
    			sb.append((flag.getKorname()));
    		sb.append(end("korname"));
    	sb.append(end("nationalflag"));
    	return sb.toString();
    }
    
    
    public static void save(String fname,String flagname){
    	BufferedImage image = null;
        try {
            URL url = new URL(flagname);
            image = ImageIO.read(url);

            ImageIO.write(image, "png",new File("d:\\flags\\"+fname+".png"));

        } catch (IOException e) {
        	e.printStackTrace();
        }
        System.out.println("saved!!"+new Date());
    }
    
    public static void printXML(String fname,String msg){
    	PrintWriter pw=null;
    	try {
			pw=new PrintWriter(fname,"utf-8");
			pw.println(msg);
			pw.close();
		} catch (IOException e) {
			System.out.println();
		}
    }
    public static void printPlain(String fname,String msg){
    	PrintWriter pw=null;
    	try {
			pw=new PrintWriter(fname,"euc-kr");
			pw.println(msg);
			pw.close();
		} catch (IOException e) {
			System.out.println();
		}
    }
    
}