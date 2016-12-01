package com.eiecc.fire.spring_4_no_xml.mvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.DemoObj;

@Controller
public class ConverterController {

	@RequestMapping(value="convert", produces = {"appliacation/x-wisely"}) //注意这里的数据格式，后台处理按此格式处理，用"_"隔开
	public @ResponseBody DemoObj convert(@RequestBody DemoObj demoObj) {
		System.out.println("?????????????????5");
		return demoObj;
	}
}
