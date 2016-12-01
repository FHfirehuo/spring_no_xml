package com.eiecc.fire.spring_4_no_xml.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.DemoObj;

@Controller
public class AdviceController {

	@ResponseBody
	@RequestMapping("/advice")
	public DemoObj getSometing(DemoObj obj) {

		return obj;
	}

	@ResponseBody
	@RequestMapping("/advice/msg")
	public DemoObj getSometing(@ModelAttribute("msg") String msg, DemoObj obj) {

		obj.setName(msg);
		return obj;
	}

	@RequestMapping("/advice/error")
	public String getSomeTing(@ModelAttribute("msg") String msg, DemoObj obj) {

		throw new IllegalArgumentException("非常抱歉:" + msg);
	}
}
