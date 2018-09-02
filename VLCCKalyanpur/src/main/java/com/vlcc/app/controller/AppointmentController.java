package com.vlcc.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class AppointmentController {
	
	@RequestMapping(value = "/bookAppointment", method = RequestMethod.GET)
	public String showBookAppointmentPage(ModelMap model) {
		System.out.println("Inside showBookAppointmentPage");
		return "bookAppointment";
	}

}
