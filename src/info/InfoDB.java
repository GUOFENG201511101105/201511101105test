package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InfoDB {
	public int addInfo(Info info) throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "root", "gf1502");
		System.out.println("数据库=" + conn.getCatalog());

		Statement stmt = conn.createStatement();

		String sql = "insert info values(null ,'" + info.getTime() + "','" + info.getTitle() + "','"
				+ info.getContents() + "','" + info.getEditor() + "')";
		System.out.println(sql);

		int line = stmt.executeUpdate(sql);
		conn.close();
		return line;
	}

	public Info showInfo(int infoId) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "root", "gf1502");
		System.out.println("数据库=" + conn.getCatalog());

		Statement stmt = conn.createStatement();

		String sql = "select * from info where id= (select max(id) from info)";
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);

		Info info = new Info();
		while (rs.next()) {
			info.setId(rs.getInt("id"));
			info.setTime(rs.getTimestamp("time"));
			info.setContents(rs.getString("contents"));
			info.setTitle(rs.getString("title"));
			info.setEditor(rs.getString("editor"));
		}
		conn.close();
		System.out.println(info);
		return info;
	}

	public int deleteInfo(Info info) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "root", "gf1502");
		System.out.println("数据库=" + conn.getCatalog());

		Statement stmt = conn.createStatement();
		String sql = "delete * from info where id= (select max(id) from info)";
		System.out.println(sql);
		stmt.execute(sql);
		return 0;

	}
	
	public int updateInfo(Info info) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "root", "gf1502");
		System.out.println("当前连接到的数据库=" + conn.getCatalog());

		Statement stmt = conn.createStatement();

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String sql = "update info set title= '" + info.getTitle() + "',contents='" + info.getContents() + "',time='"
				+ ts + "' where id=" + info.getId();
		System.out.println(sql);
		int line = stmt.executeUpdate(sql);

		conn.close();
		return line;
	}
}



