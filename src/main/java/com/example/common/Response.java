package com.example.common;

import java.util.List;
import java.util.Map;

public class Response {
	Map<String,List<Student>> studentsByClassIds;

	public Map<String, List<Student>> getStudentsByClassIds() {
		return studentsByClassIds;
	}

	public void setStudentsByClassIds(Map<String, List<Student>> studentsByClassIds) {
		this.studentsByClassIds = studentsByClassIds;
	}
	
	

}
