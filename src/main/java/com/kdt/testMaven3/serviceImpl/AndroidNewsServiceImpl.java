package com.kdt.testMaven3.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kdt.testMaven3.Dao.AndroidNewsDAO;
import com.kdt.testMaven3.bean.AndroidNews;
import com.kdt.testMaven3.bean.News;
import com.kdt.testMaven3.capture.GetJsonUtil;
import com.kdt.testMaven3.capture.JSONArrayToObjectList;
import com.kdt.testMaven3.service.NewsService;

public class AndroidNewsServiceImpl implements NewsService{
	@Autowired
	AndroidNewsDAO androidNewsDAO;
	@Override
	public String updateNews(String url) {
		// TODO Auto-generated method stub
		JSONArray jsonArray=GetJsonUtil.getJsonArray(url);
		System.out.println("androidNewsDAO: "+androidNewsDAO);
		List<News> list=JSONArrayToObjectList.toNewsList(jsonArray, AndroidNews.class);
		for(int i=0;i<list.size();i++)
		androidNewsDAO.addAndroidNews((AndroidNews)list.get(i));
		return "success";
	}
	@Override
	public String getAllofJsonStr() {
		JSONArray jsonArray=new JSONArray();
		List<AndroidNews> list=androidNewsDAO.getAll();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		for(int i=(list.size()-1);i>0;i--) {
			String data=simpleDateFormat.format(list.get(i).getPublishedAt());
			list.get(i).setData(data);
			jsonArray.add(list.get(i));
		}
		System.out.println("jsonString!!!!!:"+jsonArray.toJSONString());
		// TODO Auto-generated method stub
		return jsonArray.toString();
	}
	@Override
	public List<News> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteNewsByID(String id) {
		// TODO Auto-generated method stub
		androidNewsDAO.deleteAndroidNews(id);
	}
	@Override
	public String getPageJsonStr(int num, int page) {
		// TODO Auto-generated method stub
		JSONArray jsonArray=new JSONArray();
		int start=num*(page-1);
		int end=num*page;
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		List<AndroidNews> list=androidNewsDAO.getByRange(start, end);
		for(int i=(list.size()-1);i>0;i--) {
			String data=simpleDateFormat.format(list.get(i).getPublishedAt());
			System.out.println("data:!!!!!"+data);
			list.get(i).setData(data);
			jsonArray.add(list.get(i));
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("error", false);
		jsonObject.put("results", jsonArray);
		return jsonObject.toString();
	}
	
	
	
}
