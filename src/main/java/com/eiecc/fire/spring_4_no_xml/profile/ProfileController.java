package com.eiecc.fire.spring_4_no_xml.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	@Autowired
	DemoBean demoBean;
	
	@RequestMapping("profile")
	public String profile() {
		return demoBean.getContent();
		
	}

}
