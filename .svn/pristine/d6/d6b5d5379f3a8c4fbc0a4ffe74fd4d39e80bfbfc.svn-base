package com.eiecc.fire.spring_4_no_xml.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eiecc.fire.spring_4_no_xml.common.AjaxResult;
import com.eiecc.fire.spring_4_no_xml.security.service.VerifyService;

@Controller
public class LoginController {
	private Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	VerifyService verifyService;
	
	@RequestMapping(value="login", method= RequestMethod.GET)
	public String login() {
		
		return "security/login";
	}
	
	@RequestMapping(value="login", method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult login(String username, String password) {
		
		AjaxResult ar = new AjaxResult();
		LOGGER.info(username+" 请求登陆");
		if(verifyService.check(username, password)){
			LOGGER.info(username+" 登录成功");
			LOGGER.error(username+" 登录成功");
			ar.setMessage(username+"登录成功");
		}
		
		return ar;
	}

}
