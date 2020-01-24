package com.example.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConnectionUtilities  {
	String response;
	public String getConnection(String jwtToken, RequestVo requestVo,String requestUrl) throws Exception {
		try {
			String urlParameters  = "size=2000&page=0";
            
		//URL url=new URL("https://becatlantis.online:8080/api/v1/classes/users?size=2000&page=0") ; 
	    //URL url=new URL("https://becatlantis.online:8080/api/v1/classes/users?size=2000&page=0") ;
			URL url=new URL(requestUrl) ;
			
		HttpURLConnection  urlConnection=(HttpURLConnection) url.openConnection();
	    urlConnection.setRequestProperty ("Authorization","Bearer "+ jwtToken);
	    urlConnection.setRequestMethod("POST");
	    urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
	    urlConnection.setRequestProperty("Accept","application/json");
	    urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
		urlConnection.setDoOutput(true);
		urlConnection.setChunkedStreamingMode(0);
		Map<String,List<Integer>> params = new HashMap<>();
		params.put("ids", requestVo.getIds());
		ObjectMapper mapperObj = new ObjectMapper();
		String paramString=mapperObj.writeValueAsString(params);
		
		OutputStream os=new BufferedOutputStream(urlConnection.getOutputStream());
		os.write(paramString.getBytes());
		os.flush();
		os.close();

		InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		response = sb.toString();
		//System.out.println(response);
		
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	
		return response;
}
	
}