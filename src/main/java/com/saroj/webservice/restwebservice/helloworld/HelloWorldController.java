package com.saroj.webservice.restwebservice.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	//@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {	
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping(path="/hello-world-bean/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World Bean,%s", name));
	}
	
	//@RequestMapping(method = RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world-internationalized")
	public String HelloWorldInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		//locale:Any lagunage that conviniate with user
		return messageSource.getMessage("good.morning.message", null,"Default message",
				//locale);
				LocaleContextHolder.getLocale());
	//	return "Hello World";
	}

}
