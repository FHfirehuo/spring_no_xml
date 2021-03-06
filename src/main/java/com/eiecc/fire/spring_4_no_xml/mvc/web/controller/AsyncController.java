package com.eiecc.fire.spring_4_no_xml.mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.eiecc.fire.spring_4_no_xml.mvc.service.PushService;

@Controller
public class AsyncController {

	//这不是一种面向对象的写法
	@Autowired
	private PushService pushService;

	@ResponseBody
	@RequestMapping("defer")
	public DeferredResult<String> deferedCall() {
		
		return pushService.getAsyncUpdate();
	}
}
