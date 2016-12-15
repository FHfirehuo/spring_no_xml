package com.eiecc.fire.spring_4_no_xml.user.service;

import org.springframework.stereotype.Service;

import com.eiecc.fire.spring_4_no_xml.aop.Authority;


@Service
public class UserService {
	
	@Authority(name="user:add")
	public void add() {
		System.out.println("新增一个用户");

	}
	
	
	public void delete(int id) {
		System.out.println("删除一个用户");

	}

}
