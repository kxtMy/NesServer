package com.kdt.testMaven3.DaoImpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Transactional;

import com.kdt.testMaven3.Dao.AndroidNewsDAO;
import com.kdt.testMaven3.bean.AndroidNews;



/*@Repository("androidNewsDAOImpl")*/

public class AndroidNewsDAOImpl implements AndroidNewsDAO {
	private static final Logger log = LoggerFactory.getLogger(AndroidNewsDAOImpl.class);
	private SessionFactory sessionFactory;

	public AndroidNewsDAOImpl() {
		// TODO Auto-generated constructor stub
		log.info("AndroidNewsDAOImpl初始化");
	}

	/* @Resource(name="sessionFactory") */
	public void setSessionFactory(SessionFactory sessionFactory) {
		log.info("setter!!!!!setSessionFactory");
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	@Override
	public void addAndroidNews(AndroidNews androidNews) {
		// TODO Auto-generated method stub
		log.info("  addAndroidNews                                 添加AndroidNews");
		System.out.println(sessionFactory);
		// System.out.println("session:"+sessionFactory.getCurrentSession());
		System.out.println("Desc:!!!!!!!!!!!" + androidNews.getDesc());
		System.out.println("sessionFactory:!!!" + sessionFactory.getCurrentSession().toString());
		// sessionFactory.getCurrentSession().createQuery("from android_news_test");
		//Transaction t = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().saveOrUpdate(androidNews);
		System.out.println("sessionFactory:!!!" + sessionFactory.getCurrentSession().toString());
		// sessionFactory.getCurrentSession().beginTransaction();

		//t.commit();
		log.info("save  addAndroidNews                                 ");
	}
	
	//添加service层后改为insert
	@Transactional
	@Override
	public void addAndroidNewsList(List<AndroidNews> androidNewsList) {
		// TODO Auto-generated method stub
		log.info("  addAndroidNews                                 添加AndroidNews");
		System.out.println(sessionFactory);
		// System.out.println("session:"+sessionFactory.getCurrentSession());
		//System.out.println("Desc:!!!!!!!!!!!" + androidNews.getDesc());
		//System.out.println("sessionFactory:!!!" + sessionFactory.getCurrentSession().toString());
		// sessionFactory.getCurrentSession().createQuery("from android_news_test");
		//Transaction t = sessionFactory.getCurrentSession().beginTransaction();
		for (AndroidNews androidNews : androidNewsList) {
			sessionFactory.getCurrentSession().saveOrUpdate(androidNews);
		}
		
		System.out.println("sessionFactory:!!!" + sessionFactory.getCurrentSession().toString());
		// sessionFactory.getCurrentSession().beginTransaction();

		//t.commit();
		log.info("save  addAndroidNews                                 ");
	}

	/*
	 * public void addAndroidNews(AndroidNews androidNews) {
	 * 
	 * 
	 * }
	 */

	//添加service层后改为insert
	@Transactional
	@Override
	public List<AndroidNews> getAll() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<AndroidNews> list=sessionFactory.getCurrentSession().createQuery("from AndroidNews android_news_test").list();
		for(int i=0;i<list.size();i++) {
			AndroidNews androidNews=(AndroidNews)list.get(i);
			list.set(i, androidNews);
			System.out.println(androidNews.getDesc().toString());
		}
		return list;
	}
	@Transactional
	@Override
	public void deleteAndroidNews(String id) {
		// TODO Auto-generated method stub
		AndroidNews androidNews=new AndroidNews();
		androidNews.set_id(id);
		sessionFactory.getCurrentSession().delete(androidNews);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	@Override
	public List<AndroidNews> getByRange(int start, int end) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("from AndroidNews android_news_test");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<AndroidNews> list=query.list();
		for(int i=0;i<list.size();i++) {
			AndroidNews androidNews=(AndroidNews)list.get(i);
			list.set(i, androidNews);
			System.out.println(androidNews.getDesc().toString());
		}
		return list;
	}
}
