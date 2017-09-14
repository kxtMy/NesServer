package com.kdt.testMaven3.serviceImpl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kdt.testMaven3.Dao.iOSNewsDAO;
import com.kdt.testMaven3.bean.AndroidNews;
import com.kdt.testMaven3.bean.News;
import com.kdt.testMaven3.bean.iOSNews;
import com.kdt.testMaven3.capture.GetJsonUtil;
import com.kdt.testMaven3.capture.JSONArrayToObjectList;
import com.kdt.testMaven3.service.NewsService;

public class iOSNewsServiceImpl implements NewsService {
	@Autowired
	iOSNewsDAO iosNewsDAO;
	@Override
	public String updateNews(String url) throws SQLException {
		// TODO Auto-generated method stub
		JSONArray jsonArray=GetJsonUtil.getJsonArray(url);
		System.out.println("iosNewsDAO: "+iosNewsDAO);
		List<News> list=JSONArrayToObjectList.toNewsList(jsonArray, iOSNews.class);
		for(int i=0;i<list.size();i++)
			iosNewsDAO.addiOSNews((iOSNews)list.get(i));
		return "success";
	}

	@Override
	public List<News> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllofJsonStr() {
		// TODO Auto-generated method stub
		JSONArray jsonArray=new JSONArray();
		List<iOSNews> list=iosNewsDAO.getAll();
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
	public void deleteNewsByID(String id) {
		// TODO Auto-generated method stub
		iosNewsDAO.deleteiOSNews(id);
	}

	@Override
	public String getPageJsonStr(int num, int page) {
		// TODO Auto-generated method stub
		JSONArray jsonArray=new JSONArray();
		int start=num*(page-1);
		int end=num*page;
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		List<iOSNews> list=iosNewsDAO.getByRange(start, end);
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
