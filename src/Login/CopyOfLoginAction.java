package Login;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CopyOfLoginAction  extends ActionSupport{ 
	public CopyOfLoginAction() {
		System.out.println("CopyOfLoginAction构造函数");
	}

	private String account;

	public String getAccount() {
		System.out.println("CopyOfLoginAction getAccount");
		return account;
	}

	public void setAccount(String account) {
		System.out.println("CopyOfLoginAction setAccount");
		this.account = account;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("CopyOfLoginAction set password");
		this.password = password;
	}

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletContext application = ServletActionContext.getServletContext();
		Map session = ActionContext.getContext().getSession();
		session.put("accoun", "22444442");

		int sss[] = { 1, 3, 4 };
		sss[0] = 1;

		System.out.println("LoginAction execute");
		if (account.equals(password)) {
			return "success";
		}
		return "fail";
	}

	public String test() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletContext application = ServletActionContext.getServletContext();
		Map session = ActionContext.getContext().getSession();
		session.put("accoun", "222");

		int sss[] = { 1, 3, 4 };
		sss[0] = 1;

		System.out.println("LoginAction execute");
		if (account.equals(password)) {
			return "success";
		}
		return "fail";
	}

	public String testMyjsp()  {
		System.out.println("方法为："+"testMyjsp()"); 
		return "myjsp";
	}
}
