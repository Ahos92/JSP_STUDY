package myutil;

import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBManager {

	// DBpool
	public static Connection getConnection() {
		Properties props = new Properties();
		props.setProperty("dataSourceClassName", "oracle.jdbc.pool.OracleDataSource");
		props.setProperty("dataSource.url", "jdbc:oracle:thin:@localhost:1521/xepdb1");
		props.setProperty("dataSource.user", "hr");
		props.setProperty("dataSource.password", "hr");
		props.setProperty("dataSource.databaseName", "xepdb1");
		
		props.put("dataSource.logWriter", new PrintWriter(System.out));
		HikariConfig config = new HikariConfig(props);
		
		HikariDataSource ds = new HikariDataSource(config);

		Connection conn = null;

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}

	// db ��������
	public static void p_c_Close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null)
			ps.close();
		if(conn != null)
			conn.close();
	}

	// db ��������
	public static void r_p_c_Close(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();
		if (conn != null)
			conn.close();

	} 

	public static void p2_r_p_c_Close(PreparedStatement ps2, ResultSet rs, PreparedStatement ps,  Connection conn) throws SQLException {
		if (ps2 != null)
			ps2.close();
		if (rs != null)
			rs.close();
		if (ps != null)
			ps.close();	
		if (conn != null)
			conn.close();

	} 

	public static void p2_p_c_Close(PreparedStatement ps2, PreparedStatement ps,  Connection conn) throws SQLException {
		if (ps2 != null)
			ps2.close();
		if (ps != null)
			ps.close();	
		if (conn != null)
			conn.close();

	} 

}

