package com.human.hello.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	@RequestMapping("/")
    public String home(@RequestParam(value="name",required=false) String name, @RequestParam(value="last_name",required=false) String last_name, @RequestParam(value="times",required=false) Integer times) {
		if(name==null) {
			name = "Human";
		}
		
		if(last_name == null) {
			last_name = "";
		} else {
			last_name = " " + last_name;
		}
		if (times == null) {
			times = 1;
		}
		String base = "Hello " + name + last_name;
		String output = "";
		
		for(int i = 0; i < times; i++) {
			output += base;
		}
		
		return output;
    }
}
