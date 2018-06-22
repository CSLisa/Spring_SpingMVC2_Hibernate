package common.util.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;

 
 
public class BaseDaoImpl {
  //PropertySegArea
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	protected static QueryRunner qr=new QueryRunner();
	protected static Connection con; 
	protected static String  sql;
	protected static Object[] params;
	protected static Object[][] twoDimParams; //批量处理参数
	protected static List<Object> listParams=new ArrayList<Object>();
	protected static int rows; 
  //static/non-staticArea
	static{
		InputStream is=BaseDaoImpl.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties=new Properties();
		try {
			properties.load(is);
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
			//加载驱动，获得数据库连接并返回
			Class.forName(driver);
		    con=DriverManager.getConnection(url,user,password);
		    
		} catch (Exception e) { 
			e.printStackTrace();
		} 
	}
    
	//批处理(只能同时新增修改删除) //1成功，0失败或批量没有完全成功
	  /*sql和Object[][] twoDimParams*/
	  public static int batchMaintain() throws Exception{
		 //VariableDeclaring
		  int result=1;
		 //批量处理
		  int[] opCount=qr.batch(con,sql, twoDimParams);
		 //结果判断
		   for (int i = 0; i < opCount.length; i++) {
			  if(opCount[i]>0){ //大于0为异常
				  result=0;
				  break;
			  }
		   }
		 //返回
		  return result; 
	  }
	   

}
