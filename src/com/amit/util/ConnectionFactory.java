package com.amit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static HikariDataSource ds = null;

	public static Connection getConnection() throws SQLException, IOException {
		if (ds == null) {
			FileInputStream fis = new FileInputStream(new File("C:\\Java\\Project\\14-Student-Login\\db.properties"));
			Properties p = new Properties();
			p.load(fis);

			HikariConfig config = new HikariConfig();
			config.setUsername(p.getProperty("db.uname"));
			config.setJdbcUrl(p.getProperty("db.url"));
			config.setPassword(p.getProperty("db.pwd"));
			config.setDriverClassName(p.getProperty("db.driver"));
			ds = new HikariDataSource(config);
		}
		return ds.getConnection();
	}
}
