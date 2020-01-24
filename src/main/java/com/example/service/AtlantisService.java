package com.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.example.common.ConnectionUtilities;
import com.example.common.RequestVo;
import com.example.common.Student;

@Service
public class AtlantisService {

	ConnectionUtilities  connectionUtilities=new  ConnectionUtilities();

	public ArrayList<Student> getStudentsByRole(String jwtToken, RequestVo requestVo) throws Exception {
		int page=0;
		String response;
		HashMap<String,JSONArray> studentsByClassIds=new HashMap();
	    Logger logger=Logger.getLogger(AtlantisService.class.getName());
	    ArrayList<Student> listByStudentRole=new ArrayList();
	   
		boolean b=false;
		try {
			while(b==false) {
				String requestUrl="https://becatlantis.online:8080/api/v1/classes/users?size=2000&page="+page;
				response =connectionUtilities.getConnection(jwtToken,requestVo, requestUrl);
				if(StringUtils.isEmpty(response)|| response.equals("{}")){
					b=true;
					


				}	
				if(response!=null) {
					JSONObject jobj=new JSONObject(response);
					Set<String> classIds=jobj.keySet();
					for(String classId:classIds) {
						studentsByClassIds.put(classId,(JSONArray) jobj.get(classId));
					JSONArray stdJsonArray= (JSONArray) jobj.get(classId);
					for(int i=0;i<stdJsonArray.length();i++) {
						JSONObject studentJsonObj= (JSONObject) stdJsonArray.get(i);
					   if( studentJsonObj.get("roleName").equals("STUDENT")) {
						   Student studentObj=new Student();
						   studentObj.setClassId(classId);
						   studentObj.setFirstName(studentJsonObj.getString("firstName"));
						   studentObj.setLastName(studentJsonObj.getString("lastName"));
						   studentObj.setStdId(studentJsonObj.getInt("id"));
						   
						   listByStudentRole.add(studentObj);
					   }
					   
					}
					
					}

				}
				page++;

			}
		}
		catch(Exception e) {
			System.out.println(e);
		}

		System.out.println("hashmap size"+studentsByClassIds.size());
		logger.info("arraylist by role equal to student"+" " +listByStudentRole.size()+ ""+listByStudentRole);
		return listByStudentRole;
	}
}
