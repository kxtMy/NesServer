package com.kdt.testMaven3.Dao;

import java.util.List;

import com.kdt.testMaven3.bean.AndroidNews;
import com.kdt.testMaven3.bean.iOSNews;

public interface iOSNewsDAO {
	public void addiOSNews(iOSNews iosNews);
	public List<iOSNews> getAll();
	public void addiOSNewsList(List<iOSNews> iosNewsList);
	public void deleteiOSNews(String id);
	public List<iOSNews> getByRange(int start, int end);
}
