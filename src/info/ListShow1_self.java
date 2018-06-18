package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.*;
import info.Info;
import javax.servlet.jsp.tagext.*;

public class ListShow1_self extends TagSupport {
	
	private String bgColor = "#FFFFFF"; // 默认值：白色
	private String color = "#000000"; // 字体默认黑色
	private String align = "CENTER"; // 默认居中
	private String fontSize = "3"; // 字体大小默认为3
	private String border = "0"; // 表格边框默认为0
	private String width = null; // 表格宽度为 null
	private String bordercolor = "#000000"; // 表格边框颜色，默认黑色

	private String tableName = "info";

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setBgColor(String newBgColor) {
		bgColor = newBgColor;
	}

	public void setColor(String newColor) {
		color = newColor;
	}

	public void setAlign(String newAlign) {
		align = newAlign;
	}

	public void setFontSize(String newFontSize) {
		fontSize = newFontSize;
	}

	public void setBorder(String newBorder) {
		border = newBorder;
	}

	public void setWidth(String newWidth) {
		width = newWidth;
	}

	public void setBordercolor(String newBordercolor) {
		bordercolor = newBordercolor;
	}

//	private List<Info> getInfoList() {
//		System.out.println("start");
//		ArrayList<Info> infoList = new ArrayList();
//		for (int i = 0; i <= 7; i++) {
//			Info info = new Info();
//			info.setTime("time" + i);
//			info.setTitle("title" + i);
//			infoList.add(info);
//		}
//		return infoList;
//	}

	public int doStartTag() {
		System.out.println("fist");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "root", "gf1502");
			System.out.println("数据库=" + conn.getCatalog());

			Statement stmt = conn.prepareStatement("select * from info");
			ResultSet rs = stmt.executeQuery("SELECT * FROM info");
			ArrayList<Info> infoList = new ArrayList();
			while (rs.next()) {
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				System.out.println(rs.getString(2) + rs.getString(3));
				Info info = new Info();
				info.setTime( ts);
				info.setTitle("title" + rs.getString(3));
				infoList.add(info);
			}
			rs.close();
			stmt.close();

			JspWriter out = pageContext.getOut();
			out.print("<table border=" + border + " bordercolor=" + bordercolor);
			if (width != null) {
				out.print(" WIDTH=\"" + width + "\" >");
			}
			for (Info info : infoList) {
				out.print("<tr><TD bgcolor=" + bgColor + ">");
				out.print("<div align=" + align + "><font size=" + fontSize + " color=" + color + "> ");
				out.print(info.getTitle() + "----" + info.getTime());
				out.print("</td></tr>");
			}
		} catch (Exception e) {
			System.out.println("Error in doStartTag of Myfont Handler Class: " + e);
		}
		System.out.println("tri");
		return (EVAL_BODY_INCLUDE);
		
	}

	public int doEndTag() {
		try {
			System.out.println("seconde");
			JspWriter out = pageContext.getOut();
			out.print("</table>");
		} catch (Exception e) {
			System.out.println("Error in doEndTag of Myfont Handler Class: " + e);
		}
		return (EVAL_PAGE);
	}

}
