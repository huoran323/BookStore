package com.hr.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
/**
 * 获取连接和释放连接的工具类
 * @author Chunsheng Zhang
 *
 */
public class JDBCUtils {
	private static DataSource dataSource;
	//使用ThreadLocal管理Connection
	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
	
	static {
		try {
			//1、读取druip.properties文件
			Properties pro = new Properties();
			pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
			
			//2、连接连接池
			dataSource = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//获取连接
	public static Connection getConnection() {
//		Connection connection = null;
		Connection connection = threadLocal.get(); //在当前线程获取，确保是同一个Connection
		try {
			if (connection == null) {
				//第一次为空
				connection = dataSource.getConnection();
				threadLocal.set(connection);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	//释放连接
	public static void releaseConnection() {
		Connection connection = threadLocal.get();
		if(connection != null) {
			try {
				connection.close();
				threadLocal.remove();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//	public static void releaseConnection(Connection connection) {
//		if(connection != null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
