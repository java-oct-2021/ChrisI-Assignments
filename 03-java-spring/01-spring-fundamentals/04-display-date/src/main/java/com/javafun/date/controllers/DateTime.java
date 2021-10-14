package com.javafun.date.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTime {
	@GetMapping("/date")
	public String date(Model model) {
		Calendar c = Calendar.getInstance();
		
		model.addAttribute("month", c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		model.addAttribute("dayofweek", c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
		model.addAttribute("dayofmonth", c.get(Calendar.DAY_OF_MONTH));
		model.addAttribute("year", c.get(Calendar.YEAR));
		
		return "date.jsp";
	}
	@GetMapping("/time")
	public String time(Model model) {
		Calendar c = Calendar.getInstance();
		Integer hour = c.get(Calendar.HOUR);
		hour = hour == 0? 12:hour;
		model.addAttribute("hour", hour);
		Integer minute = c.get(Calendar.MINUTE);
		String min = minute < 10? "0"+minute: minute.toString();
		model.addAttribute("minute", min);
		model.addAttribute("ampm", c.getDisplayName(Calendar.AM_PM, Calendar.LONG, Locale.ENGLISH));
		
		
		return "time.jsp";
	}
}
