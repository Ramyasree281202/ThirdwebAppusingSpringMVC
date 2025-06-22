package com.java.ThirdWebAppusingSpringMVC.controller;

import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.ThirdWebAppusingSpringMVC.service.GreetingServiceImp;
import com.java.ThirdWebAppusingSpringMVC.service.IGreetingService;

import jakarta.servlet.http.HttpServletResponse;
@Controller
//@RequestMapping("controller")
public class FirstController {
	@Autowired
	private IGreetingService service;
	@GetMapping("/greetMsg")
//	public String displayGreetMsg(Model model) {
//
//		model.addAttribute("message", service.greetMessage());
//		return "greet";
//	}
	public String displayGreetMsg(Map<String,Object> map) {
		map.put("message", service.greetMessage());
		return "greet";
	}
	@GetMapping("/greetMap")
	public Map<String,Object> displayGreetMsg() {
		 Map<String,Object> map = new HashMap<>();
		map.put("message", service.greetMessage());
		System.out.println(map);
		return map;
	}
	@GetMapping("/greetResponse")
	public void displayGreetMsg1(HttpServletResponse response) {

		try {
			PrintWriter writer = response.getWriter();
			writer.println("<h1>Hello</h1>"+service.greetMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}
	
}
