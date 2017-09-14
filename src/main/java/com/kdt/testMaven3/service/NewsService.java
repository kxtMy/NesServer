package com.kdt.testMaven3.service;

import java.sql.SQLException;
import java.util.List;

import com.kdt.testMaven3.bean.News;

public interface NewsService {

	public String updateNews(String url) throws SQLException;
	public List<News> getAll();
	public String getAllofJsonStr();
	public void deleteNewsByID(String id);
	public String getPageJsonStr(int num, int page);
}
