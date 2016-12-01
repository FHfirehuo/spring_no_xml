package com.eiecc.fire.spring_4_no_xml.mvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/***
 * 
 * @author fire
 * 
 *         通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。
 *         注解了@Controller的类的方法可以使用 @ExceptionHandler、 @InitBinder、 @ModelAttribute注解到方法上。
 * @ControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上 。
 * 
 * @ExceptionHandler：用于全局处理控制器里的异常 。
 * 
 * @InitBinder:用来设置WebDataBinder,用于自动绑定前台请求参数到Model中。
 * 
 * @ModelAttribute: 本来作用是绑定键值对到Model中, 此处让全局的@RequestMapping都能获得在此处设置的键值对。
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView exeption(Exception exception, WebRequest request) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorMessage", exception.getMessage());
		return mav;
	}

	/*@ModelAttribute
	public void addAttribute(Model model) {

		model.addAttribute("msg", "额外信息");
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {

		webDataBinder.setDisallowedFields("id");
	}*/
}
