
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class AddUser {
	public AddUser() {
		System.out.println("LoginAction构造函数");
	}

	private String account;

	public String getAccount() {
		System.out.println("LoginAction getAccount");
		return account;
	}

	public void setAccount(String account) {
		System.out.println("LoginAction setAccount");
		this.account = account;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("LoginAction setpassword");
		this.password = password;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletContext application = ServletActionContext.getServletContext();
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("accoun", "111");

		String account1 = request.getParameter("account");
		String pass = request.getParameter("password");

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8", "root", "gf1502");

		System.out.println("数据库=" + conn.getCatalog());
		System.out.println("account1:" + account1 + " " + "pass:" + pass);
		System.out.println("account:" + account + " " + "password:" + password);

		String sql = "insert into userinfo(account,password) values (?,?)";
		PreparedStatement preStmt = conn.prepareStatement(sql);
		preStmt.setString(1, account1);
		preStmt.setString(2, pass);
		
		int rs = preStmt.executeUpdate();
		System.out.println(rs);
		session.put("accoun", account);

		if (rs!=0) {
			return "success";
		} else {
			return "fail";
		}

		/*
		 * if (account.equals(password)) { return "success"; } else return
		 * "success";
		 */
	}

}
