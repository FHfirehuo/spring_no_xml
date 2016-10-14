package com.eiecc.fire.spring_4_no_xml.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eiecc.fire.spring_4_no_xml.common.AjaxResult;
import com.eiecc.fire.spring_4_no_xml.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult add() {
		
		AjaxResult ar = new AjaxResult();
		try {
			userService.add();
		} catch (Exception e) {
			ar.setCode(AjaxResult.SERVER_FAIL);
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			ar.setMessage(e.getMessage());
		}
		return ar;
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult delete(@PathVariable int id) {
		
		AjaxResult ar = new AjaxResult();
		try {
			userService.delete(id);
		} catch (Exception e) {
			ar.setCode(AjaxResult.SERVER_FAIL);
			ar.setMessage(e.getMessage());
		}
		return ar;
	}

}
