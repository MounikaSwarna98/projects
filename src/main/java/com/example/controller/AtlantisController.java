package com.example.controller;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.RequestVo;
import com.example.common.Student;
import com.example.service.AtlantisService;

@RestController()
@RequestMapping("/api/v1")
public class AtlantisController {
	
	@Autowired
	AtlantisService atlantisService;
	@RequestMapping(value="/studentsByRole",method=RequestMethod.POST)
    public ArrayList<Student> getStudents(@RequestHeader(value="Authorization") String jwtToken,@RequestBody RequestVo requestVo )throws Exception {
   	 
         return atlantisService.getStudentsByRole(jwtToken,requestVo);
	}

}
