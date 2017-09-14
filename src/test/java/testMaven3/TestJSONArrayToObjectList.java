package testMaven3;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.kdt.testMaven3.bean.AndroidNews;
import com.kdt.testMaven3.bean.News;
import com.kdt.testMaven3.capture.GetJsonUtil;
import com.kdt.testMaven3.capture.JSONArrayToObjectList;

public class TestJSONArrayToObjectList {
	public void init() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONArray jsonArray=GetJsonUtil.getJsonArray("http://gank.io/api/data/Android/10/1");
		List<News> list=JSONArrayToObjectList.toNewsList(jsonArray, AndroidNews.class);
		for(News news:list) {
			System.out.println(news.toString());
		}
	}

}
