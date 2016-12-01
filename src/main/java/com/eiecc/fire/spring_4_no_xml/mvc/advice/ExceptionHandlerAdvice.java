package com.eiecc.fire.spring_4_no_xml.mvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(IllegalArgumentException.class)
	public ModelAndView exeption(Exception exception, WebRequest request) {
		ModelAndView mav = new ModelAndView("error");
		System.out.println("??????????????????????????????");
		mav.addObject("errorMessage", exception.getMessage());
		return mav;
	}
	
	@ModelAttribute
	public void addAttribute(Model model) {

		model.addAttribute("msg", "额外信息");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {

		webDataBinder.setDisallowedFields("id");
	}
}
