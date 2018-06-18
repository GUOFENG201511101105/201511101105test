package Action;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import info.Info;
import info.InfoDB;

import com.opensymphony.xwork2.ActionSupport;
import Dao.InfoDao;
import Dao.DaoInterface;;

public class SshInfoActoin extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int id;
	private Timestamp time;
	private String title, contents, editor;

	private InfoDao infoDao;

	private Info info;

	// String title = info.getTitle();
	// String contents = info.getContents();
	// String editor = info.getEditor();

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public InfoDao getInfoDao() {
		return infoDao;
	}

	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		System.out.println("add1");
		Info info = new Info();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		info.setTime(ts);
		info.setTitle(title);
		info.setContents(contents);
		info.setEditor(editor);

		InfoDao infoDao = new InfoDao();
		int flag = infoDao.add(info);
		
		System.out.println("flag:"+flag);
		
		if (flag == 1)
			return "success";
		else
			return "fail";
	}

	public String infoShow() throws Exception {
		System.out.println("show1");
		InfoDao infoDao = new InfoDao();
		Info info = infoDao.showInfo(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("info", info);
		return "infoShow";
	}

	public String delInfo() throws Exception {
		Info info = new Info();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		info.setTime(ts);
		info.setTitle(title);
		info.setContents(contents);
		info.setEditor(editor);
		InfoDao infoDao = new InfoDao();
		infoDao.delete(info);
		return null;
	}

	public String updateInfo() throws Exception {
		Info info = new Info();
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		info.setTime(ts);
		info.setTitle(title);
		info.setContents(contents);
		info.setEditor(editor);
		InfoDao infoDao = new InfoDao();
		infoDao.update(info);
		return null;
	}

}