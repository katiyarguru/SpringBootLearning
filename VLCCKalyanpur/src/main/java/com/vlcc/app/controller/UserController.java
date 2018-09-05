package com.vlcc.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.vlcc.app.model.Login;
import com.vlcc.app.service.LoginService;

@Controller
public class UserController {
	@Autowired
	LoginService service;
	@Autowired
	Login user;

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
		System.out.println("Inside create user");
		return "createuser";
	}

	@RequestMapping(value = "/findOne", method = RequestMethod.GET)
	@ResponseBody
	public Login findUser(String userName) {

		Login user = service.findByFirstName(userName);

		System.out.println("user name is =" + user.getUserName());
		return user;

	}

	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public ModelAndView showUserDetailsPage(ModelMap model, @RequestParam(defaultValue = "0") int page) {
		System.out.println("Inside userdetails");
		int numberOfPages;
		Slice<Login> data;
		ModelAndView modelAndView = new ModelAndView();
		if((service.findAll().size() % 4) ==0) {
			numberOfPages = (service.findAll().size() / 4);
		}
		else {
			numberOfPages = (service.findAll().size() / 4) + 1;
			
		}
		
		modelAndView.setViewName("userdetails");
		System.out.println("numberOfPages=" + numberOfPages);
		data = service.findAll((CassandraPageRequest.first(4)));
		System.out.println("Page Number=" + page);
		model.addAttribute("numberOfPages", numberOfPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("data", data);
		if (page != 0) {
			model.addAttribute("data", service.findAll(data.nextPageable()));

		}
		return modelAndView;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(String userName) {
		System.out.println("Inside delete" + userName);
		service.deleteById(userName);
		return "redirect:/userdetails";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(ModelMap model, @RequestParam(name = "userName") String userName) {
		System.out.println("Inside edit==" + userName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateUser");
		modelAndView.addObject("editUser", service.findByFirstName(userName));
		return modelAndView;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(Login updateUser) {
		System.out.println("Inside updateuser" + updateUser.getUserName());
		service.save(updateUser);
		return "redirect:/userdetails";
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ModelAndView createUser(ModelMap model, @ModelAttribute @Valid Login newuser, BindingResult bindingResult) {
		System.out.println("new user name =" + newuser.getFirst_name());
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {

			System.out.println("BINDING RESULT ERROR");

			modelAndView.setViewName("createuser");

		} else {

			service.save(newuser);
			modelAndView.setViewName("welcome");
		}
		return modelAndView;

	}
}
