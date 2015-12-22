package com.haikuo.sky;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.haikuo.sky.model.Fuck;
import com.haikuo.sky.model.User;
import com.haikuo.sky.service.FuckService;
import com.haikuo.sky.service.UserService;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:servlet-context2.xml")
//@ContextConfiguration(locations = "/WEB-INF/spring/appServlet/servlet-context2.xml")
public class UserServiceTest {
	
	    @Autowired
	    private UserService userService;
	     
	    @Test
	    public void testLoginCheck(){
	    	
	    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("servlet-context2.xml");  
	    	for (String name : applicationContext.getBeanDefinitionNames()) {
				//System.err.println("---"+name);
			}
	    	
	    	/*userService = (UserService) applicationContext.getBean("userServiceImpl");
	    	
	        User user = new User();
	        user.setUserName("hai");
	        user.setPassword("123");
	        userService.save(user);
	        System.out.println(user.getId());*/
	      /*  if(null != userService.loginCheck(user))
	            System.out.println("------OK!!------");
	        else
	            System.out.println("-----Sorry!!----");*/
	    	
	    	FuckService fuckService =  (FuckService) applicationContext.getBean("fuckServiceImpl");
	    	Fuck fc =  new Fuck();
	    	fc.setName2("卧槽 艹艹艹");
	    	fc.setTime(new Date());
	    	fuckService.add(fc);
	    	
	    	System.err.println("end----------");
	    }
	     
	 
	 
	
}
