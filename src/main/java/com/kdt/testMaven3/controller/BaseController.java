package com.kdt.testMaven3.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kdt.testMaven3.capture.UrlGenerator;
import com.kdt.testMaven3.service.NewsService;

@Controller
public class BaseController {
	/*@Autowired
	AndroidNewsDAO androidNewsDAO;*/
	@Autowired
	NewsService androidNewsService;
	@Autowired
	NewsService iosNewsService;
	/*@Resource(name="androidNewsDAOImpl")*/
	/*public void setAndroidNewsDAO(AndroidNewsDAO androidNewsDAO) {
		System.out.println("setAndroidNewsDAO!!!!!!");
		this.androidNewsDAO = androidNewsDAO;
		System.out.println("androidNewsDAO: "+androidNewsDAO);
		System.out.println("this.androidNewsDAO: "+this.androidNewsDAO);
	}*/
	/**
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test3(HttpServletRequest request,Model model) {
		/*List<AndroidNews> androidNewsList=new ArrayList<AndroidNews>();*/
		//request.setAttribute("androidNewsList",list);
		/*androidNewsDAO.getAll();
		model.addAttribute("androidNewsList", androidNewsList);*/
		
		return "admin/news_list";
	}

	/**
	 * 更新数据库内容
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/news-update", method = RequestMethod.GET)
	public String androidnews_update() {
		String androidUrl=UrlGenerator.GET_DEFAULT_Url();
		/*AndroidNews androidNews;
		List<Object> list=GetJsonxnUtil.getJson(url,androidNews);
		System.out.println("androidNewsDAO: "+androidNewsDAO);
		for(int i=0;i<list.size();i++)
		androidNewsDAO.addAndroidNews((AndroidNews)list.get(i));*/
		try {
			iosNewsService.updateNews("http://gank.io/api/data/iOS/10/1");
			return androidNewsService.updateNews(androidUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}
	/**
	 * Ajax异步刷新
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/news-list",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String androidList(HttpServletRequest request,@RequestParam("type") String type,HttpServletResponse response){
		System.out.println("type!!!"+type);
		switch (type) {
		case "Android":
			System.out.println("NewsJStr"+androidNewsService.getAllofJsonStr());
			return androidNewsService.getAllofJsonStr();
		case "iOS":
			return iosNewsService.getAllofJsonStr();
		}
		return androidNewsService.getAllofJsonStr();
		
	}
	@RequestMapping(value="/androidNews-delete",method=RequestMethod.GET)
	public String androidNewsdelete(@RequestParam("newsid") String newsid) {
		androidNewsService.deleteNewsByID(newsid);
		return "admin/news_list";
	}
	@RequestMapping(value="/news-delete",method=RequestMethod.GET)
	public String iosNewsdelete(@RequestParam("newsid") String newsid,@RequestParam("newstype") String type) {
		switch (type) {
		case "Android":
			androidNewsService.deleteNewsByID(newsid);
		case "iOS":
			iosNewsService.deleteNewsByID(newsid);
		
		}
		return "admin/news_list";
	}
	@ResponseBody
	@RequestMapping(value="/news-android",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String news_android(@RequestParam("type") String type,@RequestParam("num") int num,@RequestParam("page") int page) {
		switch (type) {
		case "Android":
			return androidNewsService.getPageJsonStr(num,page);
		case "iOS":
			return iosNewsService.getPageJsonStr(num,page);
				}
		return null;	
	}
}
