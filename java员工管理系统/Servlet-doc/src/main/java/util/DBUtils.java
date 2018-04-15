package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtils {
	//准备数据库连接参数
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static String initSize;
	private static String max;
	private static BasicDataSource ds;
	static{
		//准备Properties对象
		Properties prop = new Properties();
		//获取文件的输入流
		InputStream ips = DBUtils.class.getClassLoader()
				.getResourceAsStream("jbbc.properties");
		
		try {
			//把文件通过流加载进来
			prop.load(ips);
			//从prop中获取数据库连接参数
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			initSize = prop.getProperty("initSize");
			max = prop.getProperty("max");
			
			//创建数据源
			ds = new BasicDataSource();
			//设置数据库连接参数
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			//设置初始化连接数量
			ds.setInitialSize(Integer.parseInt(initSize));
			ds.setMaxActive(Integer.parseInt(max));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConn() throws SQLException{
			Connection conn = ds.getConnection();
		return conn;
		
	}
	
	public static void closeConn(Connection conn){
		
		if (conn!=null) {
			try {
				//此时因为使用了数据库连接池，
//				close不再是关闭而是归还到连接池
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
