package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest
public class EmpMapperClient {
	
	@Autowired 
	EmpMapper mapper;
	
	@Test
	public void findAllTest() {
		List<EmpVO> list = mapper.findAll();
	}
}
