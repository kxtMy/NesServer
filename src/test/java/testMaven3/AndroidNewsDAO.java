package testMaven3;

import java.util.List;

import testMaven3.AndroidNews;

public interface AndroidNewsDAO {
	public void addAndroidNews(AndroidNews androidNews);

	public void addAndroidNewsList(List<AndroidNews> androidNewsList);

	public List<AndroidNews> getAll();
}
