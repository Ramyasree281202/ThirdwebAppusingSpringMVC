package com.java.ThirdWebAppusingSpringMVC.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;
@Service
public class GreetingServiceImp implements IGreetingService {

	@Override
	public String greetMessage() {
	LocalTime time = 	LocalTime.now();
	Integer hr = time.getHour();
	if(hr<12)
		return "Good Morining";
	else if(hr>=12 && hr<4) 
		return "Good Afternoon";
	else if(hr>=4 && hr<7)
		return "Good Evening";
	else
		return "Good Night";
	
	}
	
}
