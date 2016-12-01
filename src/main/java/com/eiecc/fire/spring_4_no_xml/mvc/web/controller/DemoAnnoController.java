package com.eiecc.fire.spring_4_no_xml.mvc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.DemoObj;

@Controller
@RequestMapping("anno")
public class DemoAnnoController {

	// @ResponseBody支持将返回值放在response体内，而不是返回一个页面

	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {

		return "url:" + request.getRequestURL() + " can access ";
	}

	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathParam(@PathVariable String str, HttpServletRequest request) {

		return "url:" + request.getRequestURL() + " can access , str: " + str;
	}

	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {

		return "url:" + request.getRequestURL() + " can access , id: " + id;
	}

	//http://localhost:8080/spring_4_no_xml/anno/obj?id=1&name=fire
	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
	@ResponseBody 
	public String passObj(DemoObj obj, HttpServletRequest request) {

		return "url:" + request.getRequestURL() + " can access , obj id: " + obj.getId() + " obj name:" + obj.getName();
	}
	
	//映射不同的路径到相同的方法
	@RequestMapping(value = {"/name1","/name2"}, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String remove(HttpServletRequest request) {

		return "url:" + request.getRequestURL() + " can access";
	}
}
