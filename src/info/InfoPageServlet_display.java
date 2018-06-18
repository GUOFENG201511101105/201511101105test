package info;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.Info;

import java.util.*;

public class InfoPageServlet_display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pagesize;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String method = req.getMethod();
		if (method.equals("GET")) {
			doGet(req, res);
		} else {
			doPost(req, res);
		}
	}

	private Map<String, String> initParams = new LinkedHashMap();
	private String ServletName = null;

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNumber = request.getParameter("page");
		System.out.println(request.getParameter("page"));
		if (pageNumber == null) {
			pageNumber = "1";
		}

		PageList_dispaly pageList = new PageList_dispaly();

		pageList.setPageNumber(Integer.parseInt(pageNumber));
		pageList.setObjectsPerPage(pagesize);
		pageList.setFullListSize(4);

		System.out.println("----------->currentPage:" + pageNumber);
		String url = "jdbc:mysql://localhost/test";
		String userName = "root";
		String password = "gf1502"; // mysql密码
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动器类时出现异常");
		}

		try {
			conn = DriverManager.getConnection(url, userName, password);
			// 创建返回可更新结果集的语句对象
			PreparedStatement pst = null;
			// 执行SQL查询语句得到可更新结果集
			ResultSet rs = null;
			String sql = "select count(*) from info";

			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				pageList.setFullListSize(rs.getInt(1));
			}

			List<Info> list = new ArrayList<Info>();
			sql = "SELECT * FROM info limit ?,?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, pageList.getOffset());
			pst.setInt(2, pagesize);
			rs = pst.executeQuery();
			while (rs.next()) {
				Info info = new Info();
				info.setTitle((rs.getString("title")));
				info.setContents(rs.getString("contents"));
				info.setEditor(rs.getString("editor"));
				info.setTime(rs.getTimestamp("time"));
				list.add(info);
			}
			pageList.setList(list);
			System.out.println("----------->total:" + list.size());

			request.setAttribute("test", pageList);

			RequestDispatcher rd = request.getRequestDispatcher("/infoEdit/ListShow_display.jsp");
			try {
				rd.forward(request, response);
				return;
			} catch (Exception e) {
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 读配置文件web.xml，初始化servlet
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		System.out.println("intit");
		Enumeration paramNames = getInitParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = (String) paramNames.nextElement();
			String value = getInitParameter(name);
			System.out.println(name);
			System.out.println(value);
			System.out.println("================");
			initParams.put(name, value);
			if ("pagesize".equals(name)) {
				pagesize = Integer.parseInt(value);
			}
		}
		ServletName = getServletName();
		System.out.println("-------------------");
		System.out.println(ServletName);
	}

}
