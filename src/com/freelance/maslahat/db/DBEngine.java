package com.freelance.maslahat.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.freelance.maslahat.util.JFileStream;

public class DBEngine {

	private static final Logger LOG = Logger.getLogger(DBEngine.class.getName());
	private Properties properties;
	
	public DBEngine() {
		JFileStream fileStream = new JFileStream("databases.properties");
		properties = fileStream.getProperties();
		
//		LOG.info(properties);
	}

	public Connection getConnection() {
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String pass = properties.getProperty("password");
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, properties);
			return connection;
		} catch (ClassNotFoundException e) {
			LOG.error(e);
		} catch (SQLException e) {
			LOG.error(e);
		}
		return null;
	}

}
