package com.kdt.testMaven3.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.kdt.testMaven3.Dao.iOSNewsDAO;
import com.kdt.testMaven3.bean.AndroidNews;
import com.kdt.testMaven3.bean.iOSNews;

public class iOSNewsDAOImpl implements iOSNewsDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	@Override
	public void addiOSNews(iOSNews iosNews) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(iosNews);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<iOSNews> getAll() {
		// TODO Auto-generated method stub
		List<iOSNews> list=sessionFactory.getCurrentSession().createQuery("from iOSNews ios_news").list();
		for(int i=0;i<list.size();i++) {
			iOSNews iOSNews=(iOSNews)list.get(i);
			list.set(i, iOSNews);
			System.out.println(iOSNews.getDesc().toString());
		}
		return list;
	}
	@Transactional
	@Override
	public void addiOSNewsList(List<iOSNews> iosNewsList) {
		// TODO Auto-generated method stub
		for (iOSNews iosNews : iosNewsList) {
			sessionFactory.getCurrentSession().saveOrUpdate(iosNews);
		}
	}
	@Transactional
	@Override
	public void deleteiOSNews(String id) {
		// TODO Auto-generated method stub
		iOSNews iosNews=new iOSNews();
		iosNews.set_id(id);
		sessionFactory.getCurrentSession().delete(iosNews);
	}
	@Transactional
	@Override
	public List<iOSNews> getByRange(int start, int end) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery("from iOSNews ios_news");
		query.setFirstResult(start);
		query.setMaxResults(end);
		List<iOSNews> list=query.list();
		for(int i=0;i<list.size();i++) {
			iOSNews iosNews=(iOSNews)list.get(i);
			list.set(i, iosNews);
			System.out.println(iosNews.getDesc().toString());
		}
		return list;
	}

}
