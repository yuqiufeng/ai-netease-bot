package com.yuqiufeng.aineteasebot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSON;

public class Utils {
	
	public static void main(String[] args) throws Exception{
//		apply();
		
		Map<String, String> map = new HashMap<>();
		map.put("query", "原老师帅吗?");
		map.put("topN", "5");
		search(map);
	}
	
	static final String appkey = "bayerkf";
	static final String appsecret = "93011e6c245aa46fc180b412a3849b03";
	
	static String baseUrl = "http://ai.netease.com/bot/";
	
	static String token = "186d681142fc725a22bc1ceff5d3c0f7";
	
	//查询问题答案
	public static String search(Map<String, String> map) throws Exception{
		String curTime = getCurTime();
		String nonce = getNonce();
		String checksum = getCheckNum(nonce, curTime);
		
		String urlPath = baseUrl + "search?&mode=search&appkey="+appkey
				+"&nonce="+nonce
				+"&curtime="+curTime
				+"&checksum="+checksum
				+"&token="+token;
		
		
		URL url = new URL(urlPath);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("content-type", "application/json");
		
		String query = JSON.toJSONString(map);
		String content = URLEncoder.encode(query, "utf-8");
		PrintWriter pw = new PrintWriter(conn.getOutputStream());
		pw.write(content);
		pw.close();
		
		if (conn.getResponseCode() == 200) {
			StringBuffer sb=new StringBuffer();
		      String readLine=new String();
		      BufferedReader responseReader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		      while((readLine=responseReader.readLine())!=null){
		        sb.append(readLine).append("\n");
		      }
		      responseReader.close();
		      System.out.println(sb.toString());
		}
		
		return null;
	}
	
	//申请token
	public static String apply() throws Exception{
		String curTime = getCurTime();
		String nonce = getNonce();
		String checksum = getCheckNum(nonce, curTime);
		
		String urlPath = baseUrl + "apply?&mode=apply&appkey="+appkey+"&nonce="+nonce
				+"&curtime="+curTime
				+"&checksum="+checksum;
		
		URL url = new URL(urlPath);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("POST");
		
		if (conn.getResponseCode() == 200) {
			StringBuffer sb=new StringBuffer();
		      String readLine=new String();
		      BufferedReader responseReader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		      while((readLine=responseReader.readLine())!=null){
		        sb.append(readLine).append("\n");
		      }
		      responseReader.close();
		      System.out.println(sb.toString());
		}
		
		return null;
	}
	
	//随机数
	public static String getNonce(){
		Random random = new Random();  
        return String.valueOf(random.nextInt(10000));  
	}
	
	//当前UTC时间戳
	public static String getCurTime(){
		return System.currentTimeMillis()/1000+"";
	}
	
	//SHA1
	public static String getCheckNum(String nonce,String curTime){
		String str = appsecret+nonce+curTime;
		if (str == null || str.length() == 0) {  
            return null;  
        }  
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  
                'a', 'b', 'c', 'd', 'e', 'f' };  
  
        try {  
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");  
            mdTemp.update(str.getBytes("UTF-8"));  
  
            byte[] md = mdTemp.digest();  
            int j = md.length;  
            char buf[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                buf[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(buf);  
        } catch (Exception e) {  
            return null;  
        }  
	}
}
