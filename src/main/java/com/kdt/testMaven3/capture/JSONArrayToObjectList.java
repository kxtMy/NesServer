package com.kdt.testMaven3.capture;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.kdt.testMaven3.bean.News;

public class JSONArrayToObjectList {
	public final static String LOCAL_ROOT_PATH = "F:/EclipseOxyWorkSpace/ImgResources/";
	public final static String INTERNET_PATH = "http://localhost:8080/testMaven3/Img/";
	//要转换成特定对象，并存储图片（图片要分目录）
	/**
	 * 传入androidnewsJsonArray并返回对象列表
	 * @param newsJsonArray
	 */
	public static List<News> toNewsList(JSONArray newsJsonArray,Class<? extends News> newsClass) {
		List<News> list = new ArrayList<News>();
		News news;
		for (int i = 0; i < newsJsonArray.size(); i++) {
			news=newsJsonArray.getObject(i,newsClass);
			System.out.println("IMG:"+news.getImages());
			JSONArray imgJSONArray = newsJsonArray.getJSONObject(i).getJSONArray("images");
			if(imgJSONArray!=null) {
				int imgSize=imgJSONArray.size();
				StringBuffer images=new StringBuffer();
				for(int j=0;j<imgSize;j++) {
					String imgUrl=imgJSONArray.get(j).toString();
					String[] localImgPaths = GetJsonUtil.generateImgPath(news.get_id(), imgSize,LOCAL_ROOT_PATH+news.getType()+"/");
					GetJsonUtil.storeImg(imgUrl, localImgPaths[j]);
					String[] internetImgPaths=GetJsonUtil.generateImgPath(news.get_id(), imgSize, INTERNET_PATH+news.getType()+"/");
					images.append(internetImgPaths[j]+",");
				}
				news.setImages(images.toString());
			}
			list.add(news);
		}
		return list;
			/*// 此时数组中的每个AndroidNews对象中的ImgUrl都为空，因为json数据中的ImgUrl是一个Json数组，没办法映射
			System.out.println(list.get(i).toString());

			// System.out.println(arrayImg.toString());
			// List<Object> list = Arrays.asList(arrayImg.toArray()); 
			// String imgUrl=list.get(index)

			// storeImg(list.get(0).toString());
			//怎么转换呢？
			//将object换成news作为父类   	
			News news = (News) list.get(i);
			System.out.println("添加路径之前：" + news.toString() + news.getimages());
			// 从json数组获取获取jsonObject再获取key值对应的数组
			JSONArray arrayImg = newsJsonArray.getJSONObject(i).getJSONArray("images");
			StringBuffer imgUrls = new StringBuffer();
			if (arrayImg != null) {
				String[] paths = GetJsonUtil.generateImgPath(news.get_id(), arrayImg.size());

				// 如果有图片就把它存起来
				for (int n = 0; n < arrayImg.size(); n++) {
					imgUrls.append("," + URL_PATH + news.get_id() + n);
					GetJsonUtil.storeImg(arrayImg.getString(n), paths[n]);
					System.out.println("图片地址:" + arrayImg.getString(n));
				}
				// storeImg(URL);
				// 将
				System.out.println(imgUrls);
				news.setimages(imgUrls.toString());
				System.out.println("添加路径之后：" + news.toString() + news.getimages());
			}*/

		
		
	}
	
}
