package com.eiecc.fire.spring_4_no_xml.mvc.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eiecc.fire.spring_4_no_xml.mvc.domain.DemoObj;

@RestController //
@RequestMapping("rest")
public class DemoRestController {

	@RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")
	public DemoObj getjson(DemoObj obj) {

		return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
	}

	//需要引入jackson-dataformat-xml而不仅仅是jackson-databind
	@RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8")
	public DemoObj getxml(DemoObj obj) {

		return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
	}
}
