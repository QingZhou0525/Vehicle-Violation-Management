package è½¦è¾†è¿ç« ç®¡ç†ç³»ç»Ÿ;

import java.sql.*;

public class ConnectDB {
		
	String url="jdbc:sqlserver://ÄãµÄ·şÎñÆ÷µØÖ·;useunicode=true;characterEncoding=UTF-8;DatabaseName=è½¦è¾†è¿ç« ç®¡ç†";
	String user="ÄãµÄÓÃ»§Ãû";
	String password="ÄãµÄÃÜÂë";
	
	//åŠ è½½é©±åŠ¨
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//å»ºç«‹è¿æ¥
	public Connection getConnection() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("è¿æ¥æˆåŠŸ");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	//å…³é—­è¿æ¥
	public void closeConection(PreparedStatement ps,ResultSet rs,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
			System.out.println("è¿æ¥æ–­å¼€");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}


