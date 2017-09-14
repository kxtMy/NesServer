package com.kdt.testMaven3.capture;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnUtil {
	private static final Logger log = LoggerFactory.getLogger(HttpConnUtil.class);

	public static InputStream getInputStream(String URL) {
		URL url;
		InputStream inputStream = null;
		try {
			url = new URL(URL);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			inputStream=httpURLConnection.getInputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error("Can not get connection of : " + URL);
			e.printStackTrace();
			return null;
		}

		return inputStream;

	}
}
