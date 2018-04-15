package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtils {
	//׼�����ݿ����Ӳ���
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static String initSize;
	private static String max;
	private static BasicDataSource ds;
	static{
		//׼��Properties����
		Properties prop = new Properties();
		//��ȡ�ļ���������
		InputStream ips = DBUtils.class.getClassLoader()
				.getResourceAsStream("jbbc.properties");
		
		try {
			//���ļ�ͨ�������ؽ���
			prop.load(ips);
			//��prop�л�ȡ���ݿ����Ӳ���
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			initSize = prop.getProperty("initSize");
			max = prop.getProperty("max");
			
			//��������Դ
			ds = new BasicDataSource();
			//�������ݿ����Ӳ���
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(password);
			//���ó�ʼ����������
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
				//��ʱ��Ϊʹ�������ݿ����ӳأ�
//				close�����ǹرն��ǹ黹�����ӳ�
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
