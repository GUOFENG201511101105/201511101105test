package info;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import info.Info;

public class InfoDao_hibernate {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	public void init() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建会话工厂对象
		sessionFactory = config.buildSessionFactory();
		// 创建会话对象
		session = sessionFactory.openSession();
		// 开启事务
		transaction = session.beginTransaction();
	}


	public void destory() {
		// 提交事务
		transaction.commit();
		// 关闭会话
		session.close();
		// 关闭会话工厂
		sessionFactory.close();
	}


	public int saveNewInfo(Info info) throws Exception {
		// Info info = new Info();
		// Timestamp ts = new Timestamp(System.currentTimeMillis());
		// info.setTime(ts);
		// info.setTitle("titlie");
		// info.setContents("contents");
		// info.setEditor("editor");
		if ((boolean) session.save(info)) {
			return 1;
		} else
			return 0;
	}

	public Info showInfo(Integer id) throws Exception {
		String hql = "select * from info where id= (select max(id) from info)";

		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Info> list = query.list();

		// foreach方法遍历查询出的数据
		Info info = new Info();
		for (Info rs : list) {
			info.setId(rs.getId());
			info.setTime(rs.getTime());
			info.setContents(rs.getContents());
			info.setTitle(rs.getTitle());
			info.setEditor(rs.getEditor());

			System.out.println(rs.getTitle());
		}
		return info;
	}

	public void updateInfo(Info inf) throws Exception {
		Info info = showInfo(12);

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		info.setTime(ts);
		info.setTitle("titlie");
		info.setContents("contents");
		info.setEditor("editor");
		Transaction trans = session.beginTransaction();
		session.update(info);
	}

	public void deteInfo(Integer id) throws Exception {
		String hql = "select * from info where id= id";
		Query query = session.createQuery(hql);
		List<Info> list = query.list();
		Info pro = list.get(0);
		session.delete(pro);
	}
}
