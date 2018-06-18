package Util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Util {
	private static SessionFactory sessionFactory;
	private static Session session;
	private static Transaction transaction;

	public static Session getSession() {
		// 创建配置对象
		Configuration config = new Configuration().configure();
		// 创建会话工厂对象
		sessionFactory = config.buildSessionFactory();
		// 创建会话对象
		session = sessionFactory.openSession();
		// 开启事务

		return session;
	}

	public static void destory() {
		// 提交事务
		// 关闭会话
		session.close();
		// 关闭会话工厂
		sessionFactory.close();
	}
}