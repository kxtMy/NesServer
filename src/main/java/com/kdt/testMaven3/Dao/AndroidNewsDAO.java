package com.kdt.testMaven3.Dao;

import java.util.List;

import com.kdt.testMaven3.bean.AndroidNews;

public interface AndroidNewsDAO {
	public void addAndroidNews(AndroidNews androidNews);
	public List<AndroidNews> getAll();
	public void addAndroidNewsList(List<AndroidNews> androidNewsList);
	public void deleteAndroidNews(String id);
	public List<AndroidNews> getByRange(int start, int end); 
}
