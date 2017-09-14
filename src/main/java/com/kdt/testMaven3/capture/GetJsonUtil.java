package com.kdt.testMaven3.capture;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class GetJsonUtil {
	public final static String Path = "http://localhost:8080/testMaven3/Img/";
	//一个是从url获取jsonarray，这个可以是静态的，接下来是jsonarray转化成相应的对象，并将图像存储在本地磁盘中
	public static JSONArray getJsonArray(String url) {
		// TODO Auto-generated method stub
		// List<News> newsList = new ArrayList<News>();
		// 从Url获取json数据
		String strJson = getStrJson(url);
		// 将收到的字符串解析为JSONObject
		JSONObject jsonObject = JSONObject.parseObject(strJson.toString());
		// 从JSONObject获取key对应的json数组
		if (jsonObject.get("error").toString().equals("true"))
			return null;
		JSONArray array = jsonObject.getJSONArray("results");
		// List<AndroidNews> androidNewsList=new ArrayList<AndroidNews>();
		return array;
		/*
		 * AndroidNewsDAOImpl androidNewsDAO=new AndroidNewsDAOImpl();
		 * androidNewsDAO.addAndroidNews(androidNews);
		 */

	}

	/*public static List<News> getNewsList(JSONArray array,News news) {
		List<News> list = new ArrayList<News>();
		for (int i = 0; i < array.size(); i++) {
			list.add(array.getObject(i,news.getClass()));

			// 此时数组中的每个AndroidNews对象中的ImgUrl都为空，因为json数据中的ImgUrl是一个Json数组，没办法映射
			System.out.println(list.get(i).toString());

			// System.out.println(arrayImg.toString());
			// List<Object> list = Arrays.asList(arrayImg.toArray()); 
			// String imgUrl=list.get(index)

			// storeImg(list.get(0).toString());
			//怎么转换呢？
			//将object换成news作为父类   	
			 news = (News) list.get(i);
			System.out.println("添加路径之前：" + news.toString() + news.getimages());
			// 从json数组获取获取jsonObject再获取key值对应的数组
			JSONArray arrayImg = array.getJSONObject(i).getJSONArray("images");
			StringBuffer imgUrls = new StringBuffer();
			if (arrayImg != null) {
				String[] paths = generateImgPath(news.get_id(), arrayImg.size());

				// 如果有图片就把它存起来
				for (int n = 0; n < arrayImg.size(); n++) {
					imgUrls.append("," + Path + news.get_id() + n);
					storeImg(arrayImg.getString(n), paths[n]);
					System.out.println("图片地址:" + arrayImg.getString(n));
				}
				// storeImg(URL);
				// 将
				System.out.println(imgUrls);
				news.setimages(imgUrls.toString());
				System.out.println("添加路径之后：" + news.toString() + news.getimages());
			}

		}
		return null;
	}*/

	public static String getStrJson(String Url) {
		String str = null;
		StringBuffer strJson = new StringBuffer();
		InputStream inputStream = HttpConnUtil.getInputStream(Url);
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			while ((str = bufferedReader.readLine()) != null) {
				strJson.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strJson.toString();
	}

	public static String[] generateImgPath(String id, int size,String rootPath) {
		String[] paths = new String[size];
		for (int i = 0; i < size; i++) {
			paths[i] = rootPath + id + i;
		}
		return paths;

	}
	public static void storeImg(String URL, String path) {
		byte[] byteArrayImg = toImgByteArray(URL);
		storeToDisk(byteArrayImg, path);
	}

	public static byte[] toImgByteArray(String URL) {
		byte[] buffer = new byte[1024];
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		// 获取输入流
		InputStream inputStream = HttpConnUtil.getInputStream(URL);
		int len = 0;
		try {
			while ((len = inputStream.read(buffer)) != -1) {
				// 将buffer中的数据写入到byteArrayOutputStream
				byteArrayOutputStream.write(buffer, 0, len);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return byteArrayOutputStream.toByteArray();
	}

	/**
	 * 将图片存入到硬盘
	 * 
	 * @param byteArrayImg
	 *            字节图片
	 */
	public static void storeToDisk(byte[] byteArrayImg, String path) {

		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(path);
			fileOutputStream.write(byteArrayImg);
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FileInputStream fileInputStream=new FileInputStream(file);
	}

}
