package testMaven3;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Object aObject="dsdsds";
		System.out.println(aObject.hashCode());
		int aString=(int) aObject;
		//System.out.println(aString.hashCode());
		/*String aString="fef";
		int i=1;
		aString=aString+i;
		System.out.println(aString);*/
		// TODO Auto-generated method stub
	/*	// ApplicationContext ctx = new
		// ClassPathXmlApplicationContext("/WEB-INF/spring/spring.xml");
		
		 * AndroidNews androidNews=new AndroidNews(); androidNews.setCreatedAt(new
		 * Date()); androidNews.set_id("dsdsd"); androidNews.setDesc("sdsdad");
		 * androidNews.setPublishedAt(new Date()); androidNews.setSource("sdwdsdad");
		 * androidNews.setType("sds"); androidNews.setUrl("sdsda");
		 * androidNews.setWho("dsdsd");
		 
		
		 * Configuration cfg=new Configuration(); SessionFactory
		 * sessionFactory=cfg.configure().buildSessionFactory(); Session
		 * session=sessionFactory.getCurrentSession(); session.beginTransaction();
		 * session.save(androidNews);
		 * 
		 * TestBean beans1=new TestBean(); beans1.setWww(2); beans1.setWe("sdsdd");
		 * beans1.setWee("dsds");
		 
		ApplicationContext ctx=new 
		GetJsonUtil getJson = new GetJsonUtil();
		AndroidNews androidNews = getJson.getJson();
		Configuration cfg = new Configuration();
		cfg.configure();
		// StandardServiceRegistryBuilder serviceRegistryBuilder = new
		// StandardServiceRegistryBuilder();
		// ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		// Service注册
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		// 需要先开启事务才能执行查询
		Transaction transaction = session.beginTransaction();
		// Query query=session.getNamedQuery("Test");

		// query.executeUpdate();
		session.save(androidNews);
		
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 
		transaction.commit();
		session.close();
		sessionFactory.close();
*/
	}
}
