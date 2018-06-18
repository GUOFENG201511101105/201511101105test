package Action;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import info.Info;
import info.InfoDB;
import info.InfoDao_hibernate;

public class InfoAciton extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id, title, contents, editor;
	private Timestamp time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String addInfo() throws Exception {
		System.out.println(title);
		System.out.println(contents);
		System.out.println(editor);
		
		Info info = new Info();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		info.setTime(ts);
		info.setTitle(title);
		info.setContents(contents);
		info.setEditor(editor);

		InfoDB infoDao = new InfoDB();
		int flag = infoDao.addInfo(info);
		if (flag == 1)
			return "success";
		else
			return "fail";
	}

	public String addInfo_hibernate() throws Exception {
		System.out.println(title);
		System.out.println(contents);
		System.out.println(editor);
		
		Info info = new Info();		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		info.setTime(ts);
		info.setTitle(title);
		info.setContents(contents);
		info.setEditor(editor);
		
		InfoDao_hibernate infoDao = new InfoDao_hibernate();
		int flag = infoDao.saveNewInfo(info);
		if (flag == 1)
			return "success";
		else
			return "fail";
	}

	public String infoShow() throws Exception {
		InfoDB infoDao = new InfoDB();
		Info info = infoDao.showInfo(1);
		System.out.println(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("info", info);
		return "infoShow";
}

	public String infoShow_hibernate() throws Exception {
		InfoDao_hibernate infoDao = new InfoDao_hibernate();
		Info info = infoDao.showInfo(Integer.parseInt(id));
//		System.out.println(id);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("info", info);
		return "infoShow";
	}

	public String updateInfo() throws Exception {
		InfoDB infoUpdate = new InfoDB();
		Info info = infoUpdate.showInfo(12);
		infoUpdate.updateInfo(info);
		return null;
	}

	public String updateInfo_hibernate() throws Exception {
		return null;
	}

	public String delInfo() throws Exception {
		return null;
	}

	public String delInfo_hibernate() throws Exception {
		return null;
	}
}
