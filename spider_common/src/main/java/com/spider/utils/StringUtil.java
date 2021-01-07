package com.spider.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lawstar.basic.util.Tools;

/**
 * @author 鸭梨 E-MAIL:togetyou@gmail.com time:May 24, 2009 9:37:00 PM
 *  comp:law-star
 */
public class StringUtil {
	public static String trimeTitle(String str1){
	    //去掉关于前面的词
	    StringBuffer strb = new StringBuffer(str1);
	    String res = null ;
	    if(strb.indexOf("关于")>-1){
	      strb = new StringBuffer(strb.substring(strb.indexOf("关于")));
	    }
	    //去掉第一个中华人民共和国
	    int indexInt = strb.indexOf("中华人民共和国");
	    if(indexInt==0){
	      strb =  new StringBuffer(strb.substring("中华人民共和国".length()));
	    }
	    res=strb.toString() ;
	    if(res!=null ){
	    	res = res.replace("（废止）", "") ;
	    	res = res.trim() ;
	    }
	    return res ;
	}
	
	// 转int 把异常吃掉
	/**
	 * 好方法，如果没法转换返回的是-1，呵呵
	 */
	public int toInt(String str){
		int res = -1 ;
		try{
			res = Integer.parseInt(str) ;
		}catch(Exception e){
		}finally{
		}
		return res ;
	}

	/**
	 * 判断指定的 字符串是否为空 注意中文字符未判断
	 * 
	 * 这包含了空格，换行符，Tab等
	 * 
	 * @param source
	 *            要判断是否为空的字符串 Checks if a String is empty ("") or null.
	 *            StringUtils.isNotNull(null) = false StringUtils.isNotNull("") =
	 *            false StringUtils.isNotNull(" ") = false
	 *            StringUtils.isNotNull("bob") = true StringUtils.isNotNull("
	 *            bob ") = true
	 */
	public static boolean isNotNull(String source) {

		boolean b = true;

		if ("".equals(source) || "".equals(source) || source == null
				|| source.matches("[\\s]{1,}") || source.matches("[　]{1,}")) {
			b = false;
		}

		return b;
	}

	/**
	 * 判断指定的 字符串是否为空 注意中文字符未判断
	 * 
	 * @param source
	 *            要判断是否为空的字符串 Checks if a String is empty ("") or null.
	 *            StringUtils.isNull(null) = true StringUtils.isNull("") = true
	 *            StringUtils.isNull(" ") = true StringUtils.isNull("bob") =
	 *            false StringUtils.isNull(" bob ") = false
	 */
	public static boolean isNull(String source) {

		boolean b = false;

		if ("".equals(source) || "".equals(source) || source == null
				|| source.matches("[\\s]{1,}") || source.matches("[　]{1,}")) {
			b = true;
		}
		return b;
	}

	/**
	 * 将字符串按照给定的分隔符进行拆分，返回一个拆分结果list
	 * 
	 * 指定字符串 source 和 分割 标识 sepStr 如：
	 * sepStr("/indexxw&&/lwindex&&/nwindex&&/dsindex&&/mtindex", "&&")
	 * 
	 * @param source
	 * @param sepStr
	 * @return 返回分割后的字符串列表
	 */
	public static List<String> sepStr(String source, String sepStr) {
		List<String> lis = new ArrayList<String>();

		if (!isNull(source) && sepStr != null) {
			String s1 = "";
			String s = source;

			int n = source.indexOf(sepStr);
			if (n != -1) {
				s1 = s.substring(0, n);
			} else {
				s1 = s;
			}
			if (!isNull(s1))
				lis.add(s1);
			int n1;
			while (n != -1) {
				n1 = n;
				n = s.indexOf(sepStr, n + sepStr.length());
				if (n != -1) {
					s1 = s.substring(n1 + sepStr.length(), n);
				} else {
					s1 = s.substring(n1 + sepStr.length(), s.length());
				}
				if (!isNull(s1))
					lis.add(s1);
			}

		}
		return lis;
	}

	/**
	 * 同上，这次返回的是map
	 * 
	 * 指定字符串 source 和 分割 标识 sepStr 如：
	 * sepStr("/indexxw&&/lwindex&&/nwindex&&/dsindex&&/mtindex", "&&")
	 * 
	 * @param source
	 * @param sepStr
	 * @return 返回分割后的字符串列表
	 */
	public static Map<String, String> sepStr2Map(String source, String sepStr) {
		Map<String, String> lis = new HashMap<String, String>();

		if (!isNull(source) && !isNull(sepStr)) {
			String s1 = "";
			String s = source;

			int n = source.indexOf(sepStr);
			if (n != -1) {
				s1 = s.substring(0, n);
			} else {
				s1 = s;
			}
			if (!isNull(s1))
				lis.put(s1, "");
			int n1;
			while (n != -1) {
				n1 = n;
				n = s.indexOf(sepStr, n + sepStr.length());
				if (n != -1) {
					s1 = s.substring(n1 + sepStr.length(), n);
				} else {
					s1 = s.substring(n1 + sepStr.length(), s.length());
				}
				if (!isNull(s1))
					lis.put(s1, "");
			}

		}
		return lis;
	}

	/**
	 * 去除不能被lucene 的QueryParser parse 的字符
	 * 
	 * @param source
	 *            需要移除不能被Lucene Parser parse的特殊字符
	 * @return 被移除特殊字符的字符串
	 */

	public static String removeUNAnalysis(String source) {
		String s = "";
		if (!StringUtil.isNull(source)) {
			String regx = "(\\[|\\]|:|~|-|：|;|；)+";
			s = source.replaceAll(regx, " ");
		}
		return s;
	}

	public static String removeUNAnalysis(String source, String newStr) {
		String s = "";
		if (!StringUtil.isNull(source)) {
			String regx = "(\\[|\\]|:|~|-|：|;|；)+";
			s = source.replaceAll(regx, newStr);
		}
		return s;
	}

	/**
	 * 在 content 中查找regex出现的次数
	 * 
	 * @param regex
	 * @param content
	 * @return
	 */
	public static int getTimeCount(String regex, String content) {
		int time = 0;
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(content);
		while (m.find()) {
			time++;
		}
		return time;
	}

	/**
	 * 去除所有的html标签，将html文本转换成纯文本
	 * 
	 * 过滤html标签
	 * 
	 * @param inputString
	 * @return
	 */
	public static String html2Text(String inputString) {
		String htmlStr = inputString; // 含html标签的字符串
		String textStr = "";
		Pattern p_script;
		Matcher m_script;
		Pattern p_style;
		Matcher m_style;
		Pattern p_html;
		Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
			;
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;
			textStr = textStr.replaceAll("\\s|&nbsp;", "");
		} catch (Exception e) {
			System.err.println("Html2Text error: " + e.getMessage());
		}
		return textStr;// 返回文本字符串
	}

	/**
	 * 从网页内容中拿title 根据标签<title></title>来拿
	 * 
	 * @param htmcontent
	 * @return
	 */
	public static String getHtmTitle(String htmcontent) {
		String title = "";
		Pattern pat = Pattern.compile("<title>.+</title>");
		Matcher mat = pat.matcher(htmcontent);
		if (mat.find()) {
			title = mat.group();
		}
		title = html2Text(title);
		return title;
	}

	/**
	 * 替换
	 */
	public static String replaceAll(String regex, String str, String source) {
		if (StringUtil.isNotNull(source)) {
			source = source.trim() ;
			source = source.replaceAll(regex, str);
		}
		return source;
	}

	/**
	 * 格式化文本
	 */
	public static StringBuffer txtFormat(StringBuffer strb) {
		String LineStr = "";
		int s0 = 0;
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		StringBuffer tmpBuffer = new StringBuffer();
		String lineSpr = System.getProperty("line.separator");
		while (strb.indexOf(lineSpr) > -1) {
			LineStr = strb.substring(0, strb.indexOf(lineSpr)); // 取一行
			strb.delete(0, strb.indexOf(lineSpr) + lineSpr.length()); // 删除这一行
			s0 = LineStr.indexOf("    "); // 四个空格
			s1 = LineStr.indexOf("      "); // 六个
			s2 = LineStr.indexOf("                                    "); // 36个
			s3 = LineStr.indexOf("<pre>");

			if (s3 == 0) {
				tmpBuffer.append(LineStr);
				while (strb.indexOf(lineSpr) > -1) {
					LineStr = strb.substring(0, strb.indexOf(lineSpr)); // 取一行
					strb.delete(0, strb.indexOf(lineSpr) + lineSpr.length()); // 删除这一行
					s3 = LineStr.indexOf("</pre>");
					tmpBuffer.append(LineStr + lineSpr);
					if (s3 == 0) {
						break;
					}
				}
			}

			if (s0 == 0) {
				if (s1 == 0) {
					if (s2 == 0) {
						tmpBuffer.append("<div align=right>" + LineStr.trim()
								+ "</div>");
					} else {
						tmpBuffer.append("<br/><div align=center ><strong>"
								+ LineStr.trim() + "</strong></div>");
					}
				} else {
					tmpBuffer.append("　　" + LineStr.trim() + lineSpr + "<br>");
				}
			} else {
				tmpBuffer.append(LineStr + lineSpr + "<br>");
			}
			// tmpBuffer.append(LineStr);
		}
		return tmpBuffer;
	}

	
	/**
	 * 格式化文本
	 */
	public static StringBuffer txtFormatTopic(StringBuffer strb) {
		String LineStr = "";
		int s0 = 0;
		int s1 = 0;
		int s2 = 0;
		int s3 = 0;
		StringBuffer tmpBuffer = new StringBuffer();
		String lineSpr = System.getProperty("line.separator");
		int ff = 0;
		while (strb.indexOf(lineSpr) > -1) {
			LineStr = strb.substring(0, strb.indexOf(lineSpr)); // 取一行
			strb.delete(0, strb.indexOf(lineSpr) + lineSpr.length()); // 删除这一行
			s0 = LineStr.indexOf("    "); // 四个空格
			s1 = LineStr.indexOf("      "); // 六个
			s2 = LineStr.indexOf("                                    "); // 36个
			s3 = LineStr.indexOf("<pre>");

			if (s3 == 0) {
				tmpBuffer.append(LineStr);
				while (strb.indexOf(lineSpr) > -1) {
					LineStr = strb.substring(0, strb.indexOf(lineSpr)); // 取一行
					strb.delete(0, strb.indexOf(lineSpr) + lineSpr.length()); // 删除这一行
					s3 = LineStr.indexOf("</pre>");
					tmpBuffer.append(LineStr + lineSpr);
					if (s3 == 0) {
						break;
					}
				}
			}

			LineStr = LineStr.trim();
			if(s2==-1 && ff>0 && LineStr.length()>6){
				LineStr = LineStr.substring(0, LineStr.length()/2) ;
				if(LineStr.length()>30){
					LineStr = LineStr.substring(0, 30);
				}
				LineStr+="......";
				//if(line)
			}
			if (s0 == 0) {
				if (s1 == 0) {
					if (s2 == 0) {
						tmpBuffer.append("<div align=right>" + LineStr.trim()
								+ "</div>");
					} else {
						ff++;
						tmpBuffer.append("<br/><div align=center ><strong>"
								+ LineStr.trim() + "</strong></div>");
					}
				} else {
					tmpBuffer.append("　　" + LineStr.trim() + lineSpr + "<br>");
				}
			} else {
				tmpBuffer.append(LineStr + lineSpr + "<br>");
			}
			// tmpBuffer.append(LineStr);
		}
		return tmpBuffer;
	}
	/**
	 * 处理法规标题 处理后可以用来判断是不是大法
	 * 
	 * @param str1
	 * @return
	 */
	public static String dealTitle(String str1) {
		// 去掉关于前面的词
		StringBuffer strb = new StringBuffer(str1);
		String res = null;
		if (strb.indexOf("关于") > -1) {
			strb = new StringBuffer(strb.substring(strb.indexOf("关于")));
		}
		// 去掉第一个中华人民共和国
		int indexInt = strb.indexOf("中华人民共和国");
		if (indexInt == 0) {
			strb = new StringBuffer(strb.substring("中华人民共和国".length()));
		}
		res = strb.toString();
		if (res != null) {
			// 律师法（2004修订） 去掉括号里面的
			res = res.replaceAll("(（.*）|\\(.*\\))$", "");
			res = res.trim();
		}
		return res;
	}

	/**
	 * 高亮 方法
	 */
	public static String highString(String regx, String source) {
		StringBuilder res = new StringBuilder(source);
		Pattern pat = Pattern.compile(regx);
		Matcher mat = pat.matcher(source);
		String str = "<span class=\"hig\"></span>";
		int len = str.length();
		int lev = 0;
		while (mat.find()) {
			res.replace(mat.start() + (len * lev), mat.end() + (len * lev),
					"<span class=\"hig\">" + mat.group() + "</span>");
			lev++;
		}

		return res.toString();
	}
	
	public static String strongStr(String regx, StringBuffer source) {
		if (StringUtil.isNull(regx)) {
			return source.toString();
		}
		StringBuffer res = source;
		Pattern pat = Pattern.compile(regx);
		Matcher mat = pat.matcher(res);
		String str = "<b></b>";
		int len = str.length();
		int end = 0;
		while (end < res.length() && mat.find(end)) {
			res.replace(mat.start(), mat.end(), "<b>"
					+ mat.group() + "</b>");
			end = mat.end() + len;
		}
		return res.toString();
	}

	/**
	 * @param regx
	 * @param source
	 * @return
	 */
	public static String highStr(String regx, String source) {
		if (StringUtil.isNull(regx)) {
			return source;
		}
		
		if(regx.indexOf("*") > 0) {
			regx = regx.replaceAll("\\*", ".{0,5}");
		}
		
		if(regx.indexOf("?") > 0) {
			regx = regx.replaceAll("?", ".{0,5}");
		}
		
		if(regx.indexOf("？") > 0) {
			regx = regx.replaceAll("？", ".{0,5}");
		}
		
		Pattern pat = Pattern.compile(regx);
		Matcher mat = pat.matcher(source);
		while (mat.find()) {
			source = source.replace(mat.group(), "<span class=\"hig\">" + mat.group() + "</span>");
		}
		return source;
	}
	
	public static void main(String[] args) {
		/*	StringBuilder sbb = new StringBuilder();
			for (char i = 'A'; i <= 'z'; i++) {
				sbb.append(i);
			}
			System.out.println(sbb);
			System.out.println(encryptStr(sbb.toString()));
			System.out.println(deEnc(sbb.toString()));*/
//			System.out.println(str2Int(null)) ;
		
	/*	System.out.println(highStr("胡*涛", "胡重庆市教育委员会关于转发《中共教育部党组关于学习贯彻胡锦涛总书记等中央领导同志教师节重涛"));
		System.out.println("胡*涛".indexOf("*"));
		
		System.out.println("胡？涛".replace("？", ".{0,5}"));
		
		System.out.println("胡?涛".replace("?", ".{0,5}"));*/
		System.out.println(dealTitle("中华人民共和国刑法（1997修订）"));
		System.out.println(Tools.ChineseStringToAscii("7"));
		System.out.println(hexStrs2GBK("37D4C236C8D5"));
		System.out.println(hexToGBK("37D4C236C8D5"));
		System.out.println(Tools.hexToGBK("37D4C236C8D5"));
		
	}

	/**
	 * 重载版本
	 * 
	 * @param regx
	 * @param source
	 * @return
	 */
	public static String highStr(String regx, StringBuffer source) {
		
		if (StringUtil.isNull(regx)) {
			return source.toString();
		}
		
		if(regx.indexOf("*") > 0) {
			regx = regx.replaceAll("\\*", ".{0,5}");
		}
		
		if(regx.indexOf("?") > 0) {
			regx = regx.replaceAll("?", ".{0,5}");
		}
		
		if(regx.indexOf("？") > 0) {
			regx = regx.replaceAll("？", ".{0,5}");
		}
		
		StringBuffer res = source;
		try{
		Pattern pat = Pattern.compile(regx);
		Matcher mat = pat.matcher(res);
		String str = "<span class=\"hig\"></span>";
		int len = str.length();
		int end = 0;
		int reslength = 0;
		while (end < res.length() && mat.find(end)) {
			res.replace(mat.start(), mat.end(), "<span class=\"hig\">"
					+ mat.group() + "</span>");
			reslength = res.length();
			end = mat.end() + len;
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			return res.toString();
			
		}
	}
	
	/**
	 * 简单加密 网络传输的字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String encryptStr(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i) ^ 'a');
			sb.append(str.charAt(i) ^ 'a');
		}
		return sb.toString();
	}

	/**
	 * 简单加密 网络传输的字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String deEnc(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i) ^ 'a');
		}
		return sb.toString();
	}

	/**
	 * 将两个字符串 转化成 a|C|V|V这个的形式 标高亮的时候很有用
	 * 
	 * @param titles
	 * @param contents
	 * @return
	 */
	public static String toHiRegx(String titles, String contents) {
		String res = "";
		if (isNull(titles)) {
			titles = "";
		}
		if (isNull(contents)) {
			contents = "";
		}

		res = titles + " " + contents;
		res = removeUNAnalysis(res);
		res = res.trim().replaceAll("( )+", "|");
		return res;
	}
	
	/**
	 * 将一个字符串转换成a|C|V\V这个形式标高亮的时候很有用
	 * @param args
	 */
	public static String toHiRegs(String str) {
		String res = "";
		if (isNull(str)) {
			res = "";
		}

		res = removeUNAnalysis(str);
		res = res.trim().replaceAll("( )+", "|");
		return res;
	}

	public static String hexStrs2GBK(String hexs){
		String res = "" ;
		if(hexs!=null){
			int lev = (hexs.length()+4-1)/4 ;
			StringBuilder sb = new StringBuilder(hexs);
			int start = 0 ;
			for(int i=0;i<lev;i++){
				start = i*4;
				if(i==lev-1){
					res += hexToGBK(sb.substring(start)) ;
				}else{
					res += hexToGBK(sb.substring(start,start+4)) ;
				}
			}
		}
		return res ;
	}

	public static String hexToGBK(String hexStr) {
		String c = "";
		byte[] bytes = null ;// 放汉字的字节数组
		try {
			if (hexStr.length() == 4) {
				bytes = new byte[2] ;
				bytes[0] = (byte) Integer.parseInt(hexStr.substring(0, 2), 16); // 取前两位十六进制编码转换成整形，再放到低位字节数组里
				bytes[1] = (byte) Integer.parseInt(hexStr.substring(2), 16); // 取后两位十六进制编码转换成整形，再放到高位字节数组里
			}
			if (hexStr.length() == 2) {
				bytes = new byte[1] ;
				bytes[0] = (byte) Integer.parseInt(hexStr.substring(0, 2), 16); // 取前两位十六进制编码转换成整形，再放到低位字节数组里
			}
			c = new String(bytes, "gb2312"); // 数组转换成汉字

		} catch (Exception e) {
			System.out.println("hexToGBK Exception:" + e);
		}

		return c;
	}

	public static String getNewName(String oldname){
		String newname = "" ;
		return newname ;
	}
	
	public static int str2Int(String str){
		int res = -1 ;

		try{
			res = Integer.parseInt(str) ;
		}catch (Exception e) {
		}
		
		return res ;
	}
	
	public static String rmNullAll(String source){
		return source.replaceAll("[\\s]{1,}|[　]{1,}", "") ;
	}
	

}
