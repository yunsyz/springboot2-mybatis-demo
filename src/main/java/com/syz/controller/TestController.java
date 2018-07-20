package com.syz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	private Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@ResponseBody
	@RequestMapping("/say/{name}")
	public Object say(@PathVariable("name") String name) {
		logger.debug("name:{}",name);
		String s = name + " say Hello to you!";
		return s;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("username") String userName, @RequestParam("password") String passWord) {
		logger.debug("username:{},password:{}", userName, passWord);
		ModelAndView mv = new ModelAndView("menu");
		mv.addObject("name", userName);
		return mv;
	}
}
