package com.eiecc.fire.spring_4_no_xml.mvc.web.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeeController {

	@ResponseBody
	@RequestMapping(value = "push", produces = "text/event-stream")
	public String push() {
		Random r = new Random();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "data、 Testing 1、2、3" + r.nextInt() + "\n\n";
	}
}
