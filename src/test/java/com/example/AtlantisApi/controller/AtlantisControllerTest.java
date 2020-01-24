package com.example.AtlantisApi.controller;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.print.DocFlavor.STRING;
import javax.validation.constraints.AssertFalse.List;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

public class AtlantisControllerTest  extends AbstractTest{
	String jwtToken ="eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzkyNTMyNTYsImlzcyI6ImF0bGFudGlzIiwiaWQiOjM4ODI5OTYuMCwiZmlyc3RfbmFtZSI6IlNoYW5ub24iLCJsYXN0X25hbWUiOiJKb2huc29uIiwicmVhbG1faWQiOjE3MjIuMCwiZW1haWwiOiJBbmR1Y3Rpb24zMDU1MDlAZWR1Y2F0ZS5uZXQiLCJyb2xlcyI6eyJESVNUUklDVF9BRE1JTiI6WzQ0Mzk3Ni4wXX0sImFzc2VtYmx5X2NvZGVzX2hhc2giOiI5N0QxNzBFMTU1MEVFRTRBRkMwQUYwNjVCNzhDREEzMDJBOTc2NzRDIiwicmVhbG0iOiJmYXVxdWllciIsInVzZXJuYW1lIjoiQW5kdWN0aW9uMzA1NTA5IiwiYXBwVHlwZSI6InVua25vd24iLCJzZWNfaGFzaCI6ImNmMzJlMTk3NWE5ZjE4ZTdkOTZjYzQ5YjJhNzBmYTVkIn0.8d0f0uke-XtdwYjvyQJtYHoXzRGEiMz2eKUQzWPYIpA";

	//@Test
//	public void getStudentsByRole() throws Exception {
//		String url="/api/v1/studentsByRole";
//		 String jwtToken ="eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NzkyNTMyNTYsImlzcyI6ImF0bGFudGlzIiwiaWQiOjM4ODI5OTYuMCwiZmlyc3RfbmFtZSI6IlNoYW5ub24iLCJsYXN0X25hbWUiOiJKb2huc29uIiwicmVhbG1faWQiOjE3MjIuMCwiZW1haWwiOiJBbmR1Y3Rpb24zMDU1MDlAZWR1Y2F0ZS5uZXQiLCJyb2xlcyI6eyJESVNUUklDVF9BRE1JTiI6WzQ0Mzk3Ni4wXX0sImFzc2VtYmx5X2NvZGVzX2hhc2giOiI5N0QxNzBFMTU1MEVFRTRBRkMwQUYwNjVCNzhDREEzMDJBOTc2NzRDIiwicmVhbG0iOiJmYXVxdWllciIsInVzZXJuYW1lIjoiQW5kdWN0aW9uMzA1NTA5IiwiYXBwVHlwZSI6InVua25vd24iLCJzZWNfaGFzaCI6ImNmMzJlMTk3NWE5ZjE4ZTdkOTZjYzQ5YjJhNzBmYTVkIn0.8d0f0uke-XtdwYjvyQJtYHoXzRGEiMz2eKUQzWPYIpA";
//			HashMap<String, java.util.List<Integer>> classIds=new HashMap<String, java.util.List<Integer>>();
//			ArrayList<Integer> al=new ArrayList<Integer>();
//			al.add(742538);
//			al.add(742539);
//			classIds.put("ids",al);
//			ResultActions resultActions = peformBasicPost(url,classIds,jwtToken);
//			
//		resultActions.andExpect(MockMvcResultMatchers.status().is(200));
//		//.andExpect(jsonPath("$.status").value("SUCCESS")).andExpect(jsonPath("$.statusCode").value(200));
//
//	}
	
	@Test
	public void testgetStudentsByRole() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080"+"/api/v1/studentsByRole";
		HashMap<String, java.util.List<Integer>> classIds=new HashMap<String, java.util.List<Integer>>();
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(742538);
		al.add(742539);
		classIds.put("ids",al);
		URI uri=new URI(url);
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer"+jwtToken);
		HttpEntity entity=new HttpEntity(classIds,headers);
		ResponseEntity<String> response=restTemplate.postForEntity(uri, entity, String.class);
		assertEquals(200,response.getStatusCodeValue());
	}

}
