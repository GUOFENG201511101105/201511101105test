
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	public LoginAction() {
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

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select  password from userinfo where account="+account1);

		session.put("accoun", account);

/*		while (rs.next()) {

			System.out.println(rs.getObject(1));
			// System.out.println(rs.getString("password"));
		}
*/
		if (rs.next() && rs.getObject(1).equals(pass)) {
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
