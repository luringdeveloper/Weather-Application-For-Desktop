package com.weatherapplication.control;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JTextField;

import org.codehaus.jackson.map.ObjectMapper;

import com.weatherapplication.model.WeatherModelClass;




public class WeatherApiDataController {
	
	private WeatherModelClass obj = null;
	
	private WeatherModelClass weatherApiLogic(String city) throws Exception {
		
		

			URL url = new URL("http://api.weatherstack.com/current?access_key=Enter_API_KEY&query="+city);
			HttpURLConnection hr = (HttpURLConnection) url.openConnection();

			InputStream im = hr.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(im));
			String line = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (line != null) {
				sb.append(line).append("\n");
				line = br.readLine();
			}
			
			ObjectMapper objm=new ObjectMapper();
			obj=new WeatherModelClass();
			obj=objm.readValue(sb.toString(), WeatherModelClass.class);
			

		
		return obj;
		
	}
	
	public  WeatherModelClass weatherApiLogicView(String city) throws Exception {
		 
		 return weatherApiLogic(city);
	}
	
	
	
	
}
