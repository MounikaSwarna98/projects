package com.example.AtlantisApi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.AtlantisApi.AtlantisApiApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=AtlantisApiApplication.class)
@WebAppConfiguration
@ActiveProfiles(profiles = "local")
public abstract class AbstractTest {
	
	protected MockMvc mvc;
	@Autowired
	   WebApplicationContext webApplicationContext;
 
	@PostConstruct
	   protected void setUp() {
	      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	   }
	   
	   protected String mapToJson(Object obj) throws JsonProcessingException {
		   ObjectMapper objectMapper=new ObjectMapper();
		  return  objectMapper.writeValueAsString(obj);
		   }
	   
	   protected ResultActions peformBasicPost(String path, Map<String,List<Integer>> bodyObj, String token) throws Exception {

			return this.mvc.perform(
					post(path).header(HttpHeaders.AUTHORIZATION, "Bearer "+token).header("Origin","*")
					.content(mapToJson(bodyObj))
					.contentType(MediaType.APPLICATION_JSON)
				);
		}
		   
	   }


