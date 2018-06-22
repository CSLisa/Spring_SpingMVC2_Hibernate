package common.util.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TransferUtil {
	public static final String datetime24="yyyy-MM-dd HH:mm:ss";
	public static final String datetime12="yyyy-MM-dd hh:mm:ss";
	public static final String date="yyyy-MM-dd";
	//1>日期转String
	    /*
	      Date date;  String strDate
	      strDate=new SimpleDateFormat("yyyy-MM-dd").format(date);
	       */
	    public static String toString(Date date,String formatter){
	    	String strDate=null;
	    	strDate=new SimpleDateFormat(formatter).format(date);
	    	return strDate;
	    }
	//2>String转日期
	    public static Date toDate(String strDate,String formatter) throws Exception{
	    	Date date=null;
	    	date=new SimpleDateFormat(formatter).parse(strDate);
	    	return date;
	    }
	//3>Encoding编码转化
	    public static String encodeTransfer(String str) throws Exception{
	    	return new String(str.getBytes("ISO-8859-1"),"UTF-8");
	    }
}

