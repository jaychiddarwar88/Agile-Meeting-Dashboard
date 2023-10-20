package agilemeetingdash.dto;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;

public class hikariconn {
	private static HikariDataSource dataSource;
	static{
		try {
			
			dataSource = new HikariDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/" + "agilemeeting?serverTimezone=UTC");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			
			dataSource.setMinimumIdle(100);
			dataSource.setMaximumPoolSize(2000);//The maximum number of connections, idle or busy, that can be present in the pool.
			dataSource.setAutoCommit(false);
			dataSource.setLoginTimeout(3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static DataSource datasource() {
		return dataSource;
	}

}
