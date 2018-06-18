package info;

import java.sql.Timestamp;

/**
 * AbstractInfo entity provides the base persistence definition of the Info
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp time;
	private String title;
	private String contents;
	private String editor;

	// Constructors

	/** default constructor */
	public AbstractInfo() {
	}

	/** full constructor */
	public AbstractInfo(Timestamp time, String title, String contents, String editor) {
		this.time = time;
		this.title = title;
		this.contents = contents;
		this.editor = editor;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getEditor() {
		return this.editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

}