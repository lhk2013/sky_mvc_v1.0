package com.haikuo.sky.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haikuo.sky.mb.mapper.UserMapper;
import com.haikuo.sky.model.User;
import com.haikuo.sky.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private  UserService userService;
	
	@Autowired
	private com.haikuo.sky.mb.service.UserService userService2;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		User u = userService.findByPk(100L);
		System.out.println(u.getUserName());
		
		com.haikuo.sky.entity.User u2 =  userService.saveEntity(123L);
		
		System.out.println(u2.getId());
		List<com.haikuo.sky.mb.bo.User> u3List =  userService2.getById(1L);
		System.err.println(u3List);
		return "home";
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String velocityHtml(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate+"你不在啦啦啦啦" );
	
		return "test";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String velocityHtml2(Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", "我去");
		
	
		
		model.addAttribute("serverTime", "2015年12月23日16:48:09你不在啦啦啦啦" );
	
		return "test";
	}
}
