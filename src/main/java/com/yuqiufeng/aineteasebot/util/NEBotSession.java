package com.yuqiufeng.aineteasebot.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.yuqiufeng.aineteasebot.consts.Const;
import com.yuqiufeng.aineteasebot.vo.apply.ApplyBotResult;
import com.yuqiufeng.aineteasebot.vo.base.BotResult;
import com.yuqiufeng.aineteasebot.vo.modify.addBatch.AddBatchBotResult;
import com.yuqiufeng.aineteasebot.vo.modify.deleteBatch.DeleteBatchBotResult;
import com.yuqiufeng.aineteasebot.vo.modify.get.GetBotResult;
import com.yuqiufeng.aineteasebot.vo.modify.getGroup.GetGroupBotResult;
import com.yuqiufeng.aineteasebot.vo.modify.getSyn.GetSynBotResult;
import com.yuqiufeng.aineteasebot.vo.modify.modify.ModifyBotResult;
import com.yuqiufeng.aineteasebot.vo.search.SearchBotResult;

/**
 * 网易机器人接口管理类
 * @author User_yqf
 *
 */
public class NEBotSession {
	

	//apply接口	申请token
	public static ApplyBotResult apply() throws Exception{
		String url = genApplyUrl();
		String retJSON = invoke(url,null);
		
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,ApplyBotResult.class);
	};
	
	//search接口	QA查询
	public static SearchBotResult search(Map<String, Object> map,String token) throws Exception{
		String url = genSearchUrl(token);
		String param = JSON.toJSONString(map);
		String retJSON = invoke(url,param);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,SearchBotResult.class);
	}
	
	//modify-get	读取QA
	public static GetBotResult get(Map<String, Object> map,String token) throws Exception{
		String url = genGetUrl(token);
		String param = JSON.toJSONString(map);
		String retJSON = invoke(url,param);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,GetBotResult.class);
	}
	
	//modify-getGroup
	public static GetGroupBotResult getGroup(Map<String, Object> map,String token) throws Exception {
		String url = genGetGroupUrl(token);
		String param = JSON.toJSONString(map);
		String retJSON = invoke(url,param);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,GetGroupBotResult.class);
	}
	
	//modify-addBatch 批量添加QA
	public static AddBatchBotResult addBatch(List<Map<String, Object>> list,String token) throws Exception {
		String url = genAddBatchUrl(token);
		String param = JSON.toJSONString(list);
		String retJSON = invoke(url,param);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,AddBatchBotResult.class);
	}
	
	//modify-deleteBatch	批量删除
	public static DeleteBatchBotResult deleteBatch(List<Map<String, Object>> list,String token) throws Exception{
		String url = genDeleteBatchUrl(token);
		String param = JSON.toJSONString(list);
		String retJSON = invoke(url,param);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,DeleteBatchBotResult.class);
	}
	
	//modify-modify	更新
	public static ModifyBotResult modify(Map<String, Object> map,String token) throws Exception {
		String url = genModifyUrl(token);
		String param = JSON.toJSONString(map);
		String retJSON = invoke(url,param);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,ModifyBotResult.class);
	}
	
	//modify-uploadSyn	更新
	public static BotResult uploadSyn(List<List<String>> list,String token) throws Exception {
		String url = genUploadSynUrl(token);
		String param = JSON.toJSONString(list);
		String retJSON = invoke(url,param);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,BotResult.class);
	}
	
	//modify-getSyn	更新
	public static GetSynBotResult getSyn(String token) throws Exception {
		String url = genGetSynUrl(token);
		String retJSON = invoke(url,null);
		if (StringUtils.isBlank(retJSON)) {
			return null;
		}
		return JSON.parseObject(retJSON,GetSynBotResult.class);
	}
	
	//创建apply URL
	private static String genApplyUrl() {
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		
		String url = Const.BASE_URL+"/apply?mode=apply&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum;
		return url;
	}
	
	//创建search URL
	private static String genSearchUrl(String token) {
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/search?mode=search&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}
	
	//modify-get
	private static String genGetUrl(String token){
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/modify?mode=get&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}
	
	//modify-getGroup
	private static String genGetGroupUrl(String token){
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/modify?mode=getGroup&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}

	//modify	addBatch	URL
	private static String genAddBatchUrl(String token) {
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/modify?mode=addBatch&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}
	
	//modify	deleteBatch	URL
	private static String genDeleteBatchUrl(String token) {
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/modify?mode=deleteBatch&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}
	
	//modify	modify	URL
	private static String genModifyUrl(String token) {
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/modify?mode=modify&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}
	
	//modify	uploadSyn	URL
	private static String genUploadSynUrl(String token) {
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/modify?mode=uploadSyn&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}
	
	//modify	getSyn	URL
	private static String genGetSynUrl(String token) {
		String nonce = genNonce();
		String curTime = genCurTime();
		String checkSum = genCheckSum(nonce,curTime);
		String url = Const.BASE_URL+"/modify?mode=getSyn&appkey="+Const.APP_KEY
				+"&nonce="+nonce+"&curtime="+curTime+"&checksum="+checkSum+"&token="+token;
		return url;
	}
	
	
	//随机数字符
	public static String genNonce() {
		Random random = new Random();
		return MD5Util.MD5Encode(String.valueOf(random.nextInt(10000)), "UTF-8");
	}
	//当前UTC时间戳
	public static String genCurTime() {
		return String.valueOf(System.currentTimeMillis()/1000);
	}
	//SHA1校验和
	public static String genCheckSum(String nonce,String curTime) {
		String str = Const.APP_SECRET+nonce+curTime;
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

	//接口调用
	private static String invoke(String urlPath, String json) throws Exception{
		URL url = new URL(urlPath);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("content-type", "application/json");
		if (StringUtils.isNotBlank(json)) {
			String content = URLEncoder.encode(json, "utf-8");
			PrintWriter pw = new PrintWriter(conn.getOutputStream());
			try {
				pw.write(content);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != pw) {
					pw.close();
				}
			}
		}
		
		if (conn.getResponseCode() == 200) {
			StringBuffer sb=new StringBuffer();
		      String readLine=new String();
		      BufferedReader responseReader=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		      while((readLine=responseReader.readLine())!=null){
		        sb.append(readLine).append("\n");
		      }
		      responseReader.close();
		      
		      return sb.toString();
		}
		return null;
	}
	
}
