package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Util.Util;
import info.Info;

public class InfoDao implements DaoInterface {

	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public int add(Info info) {
		System.out.println("add2");
		Transaction tr = null;
		try {
			Session s = Util.getSession();	
			tr = s.beginTransaction();
			s.save(info);
			tr.commit();
			Util.destory();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return 0;
		}

	}

	public void delete(Info info) {
		Transaction tr = null;
		try {
			Session s = Util.getSession();
			tr = s.beginTransaction();
			s.delete(info);
			tr.commit();
			Util.destory();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
	}

	public void update(Info info) {
		Transaction tr = null;
		try {
			Session s = Util.getSession();
			tr = s.beginTransaction();
			s.update(info);
			tr.commit();
			Util.destory();
		} catch (Exception e) {

			e.printStackTrace();
			tr.rollback();
		}
	}

	public Info showInfo(Integer id) throws Exception {
		System.out.println("show2");
		Transaction tr = null;
		String hql = "select * from info where id= (select max(id) from info)";
		try {
			Session s = Util.getSession();
			tr = s.beginTransaction();
			Query query = s.createQuery(hql);
			tr.commit();
			Util.destory();
		
			List<Info> list = query.list();

			Info info = new Info();
			for (Info rs : list) {
				info.setId(rs.getId());
				info.setTime(rs.getTime());
				info.setContents(rs.getContents());
				info.setTitle(rs.getTitle());
				info.setEditor(rs.getEditor());
			}
			return info;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}

	}

}
