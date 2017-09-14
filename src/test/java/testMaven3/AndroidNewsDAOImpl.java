package testMaven3;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testMaven3.AndroidNewsDAO;
import testMaven3.AndroidNews;
@Transactional
@Repository("androidNewsDAOImpl")
public class AndroidNewsDAOImpl implements AndroidNewsDAO{
	private static final Logger log = LoggerFactory.getLogger(AndroidNewsDAOImpl.class);
	private SessionFactory sessionFactory;
	public AndroidNewsDAOImpl() {
		// TODO Auto-generated constructor stub
		log.info("AndroidNewsDAOImpl初始化");
	} 
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {  
		log.info("setter");
        this.sessionFactory = sessionFactory;  
    }
	@Override
	public void addAndroidNews(AndroidNews androidNews) {
		// TODO Auto-generated method stub
		log.info("  addAndroidNews                                 添加AndroidNews");
		System.out.println(sessionFactory);
		//System.out.println("session:"+sessionFactory.getCurrentSession());
		System.out.println("Desc:!!!!!!!!!!!"+androidNews.getDesc());
		System.out.println("sessionFactory:!!!"+sessionFactory.getCurrentSession().toString());
		//sessionFactory.getCurrentSession().createQuery("from android_news_test");
		Transaction t=sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(androidNews);
		System.out.println("sessionFactory:!!!"+sessionFactory.getCurrentSession().toString());
		//sessionFactory.getCurrentSession().beginTransaction();
		
		t.commit();
		log.info("save  addAndroidNews                                 ");
	}  
	
	/*public void addAndroidNews(AndroidNews androidNews) {
		
		
	}*/
	
	public void test() {
		System.out.println("挂了。。。。。。。。。。。。。。");
	}
	
	public void init() {
		System.out.println("init...............");
	}
	@Override
	public void addAndroidNewsList(List<AndroidNews> androidNewsList) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<AndroidNews> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
